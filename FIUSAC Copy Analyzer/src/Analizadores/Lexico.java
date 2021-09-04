package analizadores;
import java_cup.runtime.*; 


public class Lexico implements java_cup.runtime.Scanner {
	private final int YY_BUFFER_SIZE = 512;
	private final int YY_F = -1;
	private final int YY_NO_STATE = -1;
	private final int YY_NOT_ACCEPT = 0;
	private final int YY_START = 1;
	private final int YY_END = 2;
	private final int YY_NO_ANCHOR = 4;
	private final int YY_BOL = 65536;
	private final int YY_EOF = 65537;
	private java.io.BufferedReader yy_reader;
	private int yy_buffer_index;
	private int yy_buffer_read;
	private int yy_buffer_start;
	private int yy_buffer_end;
	private char yy_buffer[];
	private int yychar;
	private int yyline;
	private boolean yy_at_bol;
	private int yy_lexical_state;

	public Lexico (java.io.Reader reader) {
		this ();
		if (null == reader) {
			throw (new Error("Error: Bad input stream initializer."));
		}
		yy_reader = new java.io.BufferedReader(reader);
	}

	public Lexico (java.io.InputStream instream) {
		this ();
		if (null == instream) {
			throw (new Error("Error: Bad input stream initializer."));
		}
		yy_reader = new java.io.BufferedReader(new java.io.InputStreamReader(instream));
	}

	private Lexico () {
		yy_buffer = new char[YY_BUFFER_SIZE];
		yy_buffer_read = 0;
		yy_buffer_index = 0;
		yy_buffer_start = 0;
		yy_buffer_end = 0;
		yychar = 0;
		yyline = 0;
		yy_at_bol = true;
		yy_lexical_state = YYINITIAL;
 
    yyline = 1; 
    yychar = 1;
	}

	private boolean yy_eof_done = false;
	private final int YYINITIAL = 0;
	private final int yy_state_dtrans[] = {
		0
	};
	private void yybegin (int state) {
		yy_lexical_state = state;
	}
	private int yy_advance ()
		throws java.io.IOException {
		int next_read;
		int i;
		int j;

		if (yy_buffer_index < yy_buffer_read) {
			return yy_buffer[yy_buffer_index++];
		}

		if (0 != yy_buffer_start) {
			i = yy_buffer_start;
			j = 0;
			while (i < yy_buffer_read) {
				yy_buffer[j] = yy_buffer[i];
				++i;
				++j;
			}
			yy_buffer_end = yy_buffer_end - yy_buffer_start;
			yy_buffer_start = 0;
			yy_buffer_read = j;
			yy_buffer_index = j;
			next_read = yy_reader.read(yy_buffer,
					yy_buffer_read,
					yy_buffer.length - yy_buffer_read);
			if (-1 == next_read) {
				return YY_EOF;
			}
			yy_buffer_read = yy_buffer_read + next_read;
		}

		while (yy_buffer_index >= yy_buffer_read) {
			if (yy_buffer_index >= yy_buffer.length) {
				yy_buffer = yy_double(yy_buffer);
			}
			next_read = yy_reader.read(yy_buffer,
					yy_buffer_read,
					yy_buffer.length - yy_buffer_read);
			if (-1 == next_read) {
				return YY_EOF;
			}
			yy_buffer_read = yy_buffer_read + next_read;
		}
		return yy_buffer[yy_buffer_index++];
	}
	private void yy_move_end () {
		if (yy_buffer_end > yy_buffer_start &&
		    '\n' == yy_buffer[yy_buffer_end-1])
			yy_buffer_end--;
		if (yy_buffer_end > yy_buffer_start &&
		    '\r' == yy_buffer[yy_buffer_end-1])
			yy_buffer_end--;
	}
	private boolean yy_last_was_cr=false;
	private void yy_mark_start () {
		int i;
		for (i = yy_buffer_start; i < yy_buffer_index; ++i) {
			if ('\n' == yy_buffer[i] && !yy_last_was_cr) {
				++yyline;
			}
			if ('\r' == yy_buffer[i]) {
				++yyline;
				yy_last_was_cr=true;
			} else yy_last_was_cr=false;
		}
		yychar = yychar
			+ yy_buffer_index - yy_buffer_start;
		yy_buffer_start = yy_buffer_index;
	}
	private void yy_mark_end () {
		yy_buffer_end = yy_buffer_index;
	}
	private void yy_to_mark () {
		yy_buffer_index = yy_buffer_end;
		yy_at_bol = (yy_buffer_end > yy_buffer_start) &&
		            ('\r' == yy_buffer[yy_buffer_end-1] ||
		             '\n' == yy_buffer[yy_buffer_end-1] ||
		             2028/*LS*/ == yy_buffer[yy_buffer_end-1] ||
		             2029/*PS*/ == yy_buffer[yy_buffer_end-1]);
	}
	private java.lang.String yytext () {
		return (new java.lang.String(yy_buffer,
			yy_buffer_start,
			yy_buffer_end - yy_buffer_start));
	}
	private int yylength () {
		return yy_buffer_end - yy_buffer_start;
	}
	private char[] yy_double (char buf[]) {
		int i;
		char newbuf[];
		newbuf = new char[2*buf.length];
		for (i = 0; i < buf.length; ++i) {
			newbuf[i] = buf[i];
		}
		return newbuf;
	}
	private final int YY_E_INTERNAL = 0;
	private final int YY_E_MATCH = 1;
	private java.lang.String yy_error_string[] = {
		"Error: Internal error.\n",
		"Error: Unmatched input.\n"
	};
	private void yy_error (int code,boolean fatal) {
		java.lang.System.out.print(yy_error_string[code]);
		java.lang.System.out.flush();
		if (fatal) {
			throw new Error("Fatal Error.\n");
		}
	}
	private int[][] unpackFromString(int size1, int size2, String st) {
		int colonIndex = -1;
		String lengthString;
		int sequenceLength = 0;
		int sequenceInteger = 0;

		int commaIndex;
		String workString;

		int res[][] = new int[size1][size2];
		for (int i= 0; i < size1; i++) {
			for (int j= 0; j < size2; j++) {
				if (sequenceLength != 0) {
					res[i][j] = sequenceInteger;
					sequenceLength--;
					continue;
				}
				commaIndex = st.indexOf(',');
				workString = (commaIndex==-1) ? st :
					st.substring(0, commaIndex);
				st = st.substring(commaIndex+1);
				colonIndex = workString.indexOf(':');
				if (colonIndex == -1) {
					res[i][j]=Integer.parseInt(workString);
					continue;
				}
				lengthString =
					workString.substring(colonIndex+1);
				sequenceLength=Integer.parseInt(lengthString);
				workString=workString.substring(0,colonIndex);
				sequenceInteger=Integer.parseInt(workString);
				res[i][j] = sequenceInteger;
				sequenceLength--;
			}
		}
		return res;
	}
	private int yy_acpt[] = {
		/* 0 */ YY_NOT_ACCEPT,
		/* 1 */ YY_NO_ANCHOR,
		/* 2 */ YY_NO_ANCHOR,
		/* 3 */ YY_NO_ANCHOR,
		/* 4 */ YY_NO_ANCHOR,
		/* 5 */ YY_NO_ANCHOR,
		/* 6 */ YY_NO_ANCHOR,
		/* 7 */ YY_NO_ANCHOR,
		/* 8 */ YY_NO_ANCHOR,
		/* 9 */ YY_NO_ANCHOR,
		/* 10 */ YY_NO_ANCHOR,
		/* 11 */ YY_NO_ANCHOR,
		/* 12 */ YY_NO_ANCHOR,
		/* 13 */ YY_NO_ANCHOR,
		/* 14 */ YY_NO_ANCHOR,
		/* 15 */ YY_NO_ANCHOR,
		/* 16 */ YY_NO_ANCHOR,
		/* 17 */ YY_NO_ANCHOR,
		/* 18 */ YY_NO_ANCHOR,
		/* 19 */ YY_NO_ANCHOR,
		/* 20 */ YY_NO_ANCHOR,
		/* 21 */ YY_NO_ANCHOR,
		/* 22 */ YY_NO_ANCHOR,
		/* 23 */ YY_NO_ANCHOR,
		/* 24 */ YY_NO_ANCHOR,
		/* 25 */ YY_NO_ANCHOR,
		/* 26 */ YY_NO_ANCHOR,
		/* 27 */ YY_NO_ANCHOR,
		/* 28 */ YY_NO_ANCHOR,
		/* 29 */ YY_NO_ANCHOR,
		/* 30 */ YY_NO_ANCHOR,
		/* 31 */ YY_NO_ANCHOR,
		/* 32 */ YY_NO_ANCHOR,
		/* 33 */ YY_NO_ANCHOR,
		/* 34 */ YY_NO_ANCHOR,
		/* 35 */ YY_NO_ANCHOR,
		/* 36 */ YY_NOT_ACCEPT,
		/* 37 */ YY_NO_ANCHOR,
		/* 38 */ YY_NO_ANCHOR,
		/* 39 */ YY_NO_ANCHOR,
		/* 40 */ YY_NO_ANCHOR,
		/* 41 */ YY_NO_ANCHOR,
		/* 42 */ YY_NOT_ACCEPT,
		/* 43 */ YY_NO_ANCHOR,
		/* 44 */ YY_NO_ANCHOR,
		/* 45 */ YY_NOT_ACCEPT,
		/* 46 */ YY_NO_ANCHOR,
		/* 47 */ YY_NO_ANCHOR,
		/* 48 */ YY_NOT_ACCEPT,
		/* 49 */ YY_NO_ANCHOR,
		/* 50 */ YY_NO_ANCHOR,
		/* 51 */ YY_NOT_ACCEPT,
		/* 52 */ YY_NO_ANCHOR,
		/* 53 */ YY_NOT_ACCEPT,
		/* 54 */ YY_NO_ANCHOR,
		/* 55 */ YY_NOT_ACCEPT,
		/* 56 */ YY_NO_ANCHOR,
		/* 57 */ YY_NOT_ACCEPT,
		/* 58 */ YY_NO_ANCHOR,
		/* 59 */ YY_NOT_ACCEPT,
		/* 60 */ YY_NO_ANCHOR,
		/* 61 */ YY_NOT_ACCEPT,
		/* 62 */ YY_NO_ANCHOR,
		/* 63 */ YY_NO_ANCHOR,
		/* 64 */ YY_NO_ANCHOR,
		/* 65 */ YY_NO_ANCHOR,
		/* 66 */ YY_NO_ANCHOR,
		/* 67 */ YY_NO_ANCHOR,
		/* 68 */ YY_NOT_ACCEPT,
		/* 69 */ YY_NO_ANCHOR,
		/* 70 */ YY_NOT_ACCEPT,
		/* 71 */ YY_NO_ANCHOR,
		/* 72 */ YY_NO_ANCHOR,
		/* 73 */ YY_NO_ANCHOR,
		/* 74 */ YY_NO_ANCHOR,
		/* 75 */ YY_NO_ANCHOR,
		/* 76 */ YY_NO_ANCHOR,
		/* 77 */ YY_NO_ANCHOR,
		/* 78 */ YY_NO_ANCHOR,
		/* 79 */ YY_NO_ANCHOR,
		/* 80 */ YY_NO_ANCHOR,
		/* 81 */ YY_NO_ANCHOR,
		/* 82 */ YY_NO_ANCHOR,
		/* 83 */ YY_NO_ANCHOR,
		/* 84 */ YY_NO_ANCHOR,
		/* 85 */ YY_NO_ANCHOR,
		/* 86 */ YY_NO_ANCHOR,
		/* 87 */ YY_NO_ANCHOR,
		/* 88 */ YY_NO_ANCHOR,
		/* 89 */ YY_NO_ANCHOR,
		/* 90 */ YY_NO_ANCHOR,
		/* 91 */ YY_NO_ANCHOR,
		/* 92 */ YY_NO_ANCHOR,
		/* 93 */ YY_NO_ANCHOR,
		/* 94 */ YY_NO_ANCHOR,
		/* 95 */ YY_NO_ANCHOR,
		/* 96 */ YY_NO_ANCHOR,
		/* 97 */ YY_NO_ANCHOR,
		/* 98 */ YY_NO_ANCHOR,
		/* 99 */ YY_NO_ANCHOR,
		/* 100 */ YY_NO_ANCHOR,
		/* 101 */ YY_NO_ANCHOR,
		/* 102 */ YY_NO_ANCHOR,
		/* 103 */ YY_NO_ANCHOR,
		/* 104 */ YY_NO_ANCHOR,
		/* 105 */ YY_NO_ANCHOR,
		/* 106 */ YY_NO_ANCHOR,
		/* 107 */ YY_NO_ANCHOR,
		/* 108 */ YY_NO_ANCHOR,
		/* 109 */ YY_NO_ANCHOR,
		/* 110 */ YY_NO_ANCHOR,
		/* 111 */ YY_NO_ANCHOR,
		/* 112 */ YY_NO_ANCHOR,
		/* 113 */ YY_NO_ANCHOR,
		/* 114 */ YY_NO_ANCHOR,
		/* 115 */ YY_NO_ANCHOR,
		/* 116 */ YY_NO_ANCHOR,
		/* 117 */ YY_NO_ANCHOR,
		/* 118 */ YY_NO_ANCHOR,
		/* 119 */ YY_NO_ANCHOR,
		/* 120 */ YY_NO_ANCHOR,
		/* 121 */ YY_NO_ANCHOR,
		/* 122 */ YY_NO_ANCHOR,
		/* 123 */ YY_NO_ANCHOR,
		/* 124 */ YY_NO_ANCHOR,
		/* 125 */ YY_NO_ANCHOR,
		/* 126 */ YY_NO_ANCHOR,
		/* 127 */ YY_NO_ANCHOR,
		/* 128 */ YY_NO_ANCHOR,
		/* 129 */ YY_NO_ANCHOR,
		/* 130 */ YY_NO_ANCHOR,
		/* 131 */ YY_NO_ANCHOR,
		/* 132 */ YY_NO_ANCHOR,
		/* 133 */ YY_NO_ANCHOR,
		/* 134 */ YY_NO_ANCHOR,
		/* 135 */ YY_NO_ANCHOR,
		/* 136 */ YY_NO_ANCHOR,
		/* 137 */ YY_NO_ANCHOR,
		/* 138 */ YY_NO_ANCHOR,
		/* 139 */ YY_NO_ANCHOR,
		/* 140 */ YY_NO_ANCHOR,
		/* 141 */ YY_NO_ANCHOR,
		/* 142 */ YY_NO_ANCHOR,
		/* 143 */ YY_NO_ANCHOR,
		/* 144 */ YY_NO_ANCHOR,
		/* 145 */ YY_NO_ANCHOR,
		/* 146 */ YY_NO_ANCHOR,
		/* 147 */ YY_NO_ANCHOR,
		/* 148 */ YY_NO_ANCHOR,
		/* 149 */ YY_NO_ANCHOR,
		/* 150 */ YY_NO_ANCHOR,
		/* 151 */ YY_NO_ANCHOR,
		/* 152 */ YY_NO_ANCHOR,
		/* 153 */ YY_NO_ANCHOR,
		/* 154 */ YY_NO_ANCHOR,
		/* 155 */ YY_NO_ANCHOR,
		/* 156 */ YY_NO_ANCHOR,
		/* 157 */ YY_NO_ANCHOR,
		/* 158 */ YY_NO_ANCHOR,
		/* 159 */ YY_NO_ANCHOR,
		/* 160 */ YY_NO_ANCHOR,
		/* 161 */ YY_NO_ANCHOR,
		/* 162 */ YY_NO_ANCHOR,
		/* 163 */ YY_NO_ANCHOR,
		/* 164 */ YY_NO_ANCHOR,
		/* 165 */ YY_NO_ANCHOR,
		/* 166 */ YY_NO_ANCHOR,
		/* 167 */ YY_NO_ANCHOR,
		/* 168 */ YY_NO_ANCHOR
	};
	private int yy_cmap[] = unpackFromString(1,65538,
"8:9,4,5,8:2,1,8:18,43,7,47,8:4,48,36,37,8:2,33,8,42,2,41:10,32,31,6,40,3,8:" +
"2,13,26,20,25,15,22,16,30,21,14,45,18,24,11,23,9,45,17,19,12,10,28,45,27,29" +
",45,38,8,39,8,46,8,13,26,20,25,15,22,16,30,21,14,45,18,24,11,23,9,45,17,19," +
"12,10,28,45,27,29,45,34,44,35,8:65410,0:2")[0];

	private int yy_rmap[] = unpackFromString(1,169,
"0,1,2,3,4,1:10,5,1:2,6,7,8,9,8:14,10,1,11,12,1:2,13,14,15,12,16,17,16,18,19" +
",18,20,7,21,22,23,24,25,26,27,28,29,30,31,32,33,34,24,35,36,37,38,39,40,41," +
"42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66," +
"67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91," +
"92,93,94,95,96,97,98,99,100,101,102,103,104,105,106,107,108,109,110,111,112" +
",113,114,115,116,117,118,8,119,120,121,122,123,124,125,126,127,128,129,130," +
"8,131,132")[0];

	private int yy_nxt[][] = unpackFromString(133,49,
"1,2,3,37,2:2,43,37:2,4,166:2,110,123,166,83,141,166:2,111,124,166:4,112,166" +
":2,125,166:2,5,6,7,8,9,10,11,12,13,14,15,37,2,37,166,37,46,49,-1:50,2,-1:2," +
"2:2,-1:37,2,-1:7,36,-1:55,166,152,166:20,-1:10,153,-1:3,166,153,-1:43,15,45" +
",-1:11,40,-1:46,70,-1:54,166:22,-1:10,153,-1:3,166,153,-1:11,166:18,24,166," +
"25,166,-1:10,153,-1:3,166,153,-1:3,18,36:3,40,36:43,-1:9,166:18,20,166:3,-1" +
":10,153,-1:3,166,153,-1:43,39,-1,39:2,-1:5,68:2,53,68:3,55,68:41,-1:7,42,-1" +
":50,166:14,21,166:7,-1:10,153,-1:3,166,153,-1:3,48:46,16,48,-1:9,166:7,22,1" +
"66:14,-1:10,153,-1:3,166,153,-1:3,51:47,17,-1:9,166:6,23,166:15,-1:10,153,-" +
"1:3,166,153,-1:11,166:14,26,166:7,-1:10,153,-1:3,166,153,-1:11,166:6,27,166" +
":15,-1:10,153,-1:3,166,153,-1:3,68:2,19,68:3,55,68:41,-1:9,166:10,28,166:11" +
",-1:10,153,-1:3,166,153,-1:3,68:2,57,68:3,59,68:41,-1:9,166:6,29,166:15,-1:" +
"10,153,-1:3,166,153,-1:3,70:2,41,70:3,61,70:41,-1:9,166:10,30,166:11,-1:10," +
"153,-1:3,166,153,-1:3,68:2,19,68:3,59,68:41,-1:9,166:10,31,166:11,-1:10,153" +
",-1:3,166,153,-1:11,166:9,32,166:12,-1:10,153,-1:3,166,153,-1:11,166:10,33," +
"166:11,-1:10,153,-1:3,166,153,-1:11,166:14,34,166:7,-1:10,153,-1:3,166,153," +
"-1:11,166:14,35,166:7,-1:10,153,-1:3,166,153,-1:11,166:6,38,166:15,-1:10,15" +
"3,-1:3,166,153,-1:11,166:9,44,166:12,-1:10,153,-1:3,166,153,-1:3,68:2,53,68" +
":3,59,68:41,-1:9,166:2,47,166:19,-1:10,153,-1:3,166,153,-1:11,166:9,50,166:" +
"12,-1:10,153,-1:3,166,153,-1:11,166:19,52,166:2,-1:10,153,-1:3,166,153,-1:1" +
"1,166:8,54,166:13,-1:10,153,-1:3,166,153,-1:11,166:6,56,166:15,-1:10,153,-1" +
":3,166,153,-1:11,166:12,58,166:9,-1:10,153,-1:3,166,153,-1:11,166:4,60,166:" +
"17,-1:10,153,-1:3,166,153,-1:11,166:4,62,166:17,-1:10,153,-1:3,166,153,-1:1" +
"1,166:4,63,166:17,-1:10,153,-1:3,166,153,-1:11,166:6,64,166:15,-1:10,153,-1" +
":3,166,153,-1:11,166:11,65,166:10,-1:10,153,-1:3,166,153,-1:11,166:11,66,16" +
"6:10,-1:10,153,-1:3,166,153,-1:11,166:5,67,166:16,-1:10,153,-1:3,166,153,-1" +
":11,166,69,166:20,-1:10,153,-1:3,166,153,-1:11,166:12,71,166:9,-1:10,153,-1" +
":3,166,153,-1:11,166:17,72,166:4,-1:10,153,-1:3,166,153,-1:11,166:12,73,166" +
":9,-1:10,153,-1:3,166,153,-1:11,166:4,74,166:17,-1:10,153,-1:3,166,153,-1:1" +
"1,166:8,75,166:13,-1:10,153,-1:3,166,153,-1:11,76,166:8,117,166:7,118,166:4" +
",-1:10,153,-1:3,166,153,-1:11,166:6,77,166:15,-1:10,153,-1:3,166,153,-1:11," +
"166:8,78,166:13,-1:10,153,-1:3,166,153,-1:11,166:8,79,166:13,-1:10,153,-1:3" +
",166,153,-1:11,166:9,80,166:12,-1:10,153,-1:3,166,153,-1:11,166:12,81,166:9" +
",-1:10,153,-1:3,166,153,-1:11,166:12,82,166:9,-1:10,153,-1:3,166,153,-1:11," +
"166:3,84,166:18,-1:10,153,-1:3,166,153,-1:11,166:8,85,166:13,-1:10,153,-1:3" +
",166,153,-1:11,166,86,166:20,-1:10,153,-1:3,166,153,-1:11,166:21,87,-1:10,1" +
"53,-1:3,166,153,-1:11,88,166:21,-1:10,153,-1:3,166,153,-1:11,166:14,89,166:" +
"7,-1:10,153,-1:3,166,153,-1:11,166:4,90,166:17,-1:10,153,-1:3,166,153,-1:11" +
",166:2,91,166:19,-1:10,153,-1:3,166,153,-1:11,166:8,92,166:13,-1:10,153,-1:" +
"3,166,153,-1:11,166:6,93,166:15,-1:10,153,-1:3,166,153,-1:11,166:4,94,166:1" +
"7,-1:10,153,-1:3,166,153,-1:11,166:13,95,166:8,-1:10,153,-1:3,166,153,-1:11" +
",166:3,96,166:18,-1:10,153,-1:3,166,153,-1:11,166:12,97,166:9,-1:10,153,-1:" +
"3,166,153,-1:11,166:3,98,166:18,-1:10,153,-1:3,166,153,-1:11,166:6,155,166:" +
"7,99,166:7,-1:10,153,-1:3,166,153,-1:11,166:11,100,166:10,-1:10,153,-1:3,16" +
"6,153,-1:11,166:15,101,166:6,-1:10,153,-1:3,166,153,-1:11,166:9,102,166:12," +
"-1:10,153,-1:3,166,153,-1:11,166:11,103,166:10,-1:10,153,-1:3,166,153,-1:11" +
",166:12,104,166:9,-1:10,153,-1:3,166,153,-1:11,166:4,105,166:17,-1:10,153,-" +
"1:3,166,153,-1:11,166:2,106,166:19,-1:10,153,-1:3,166,153,-1:11,166:17,107," +
"166:4,-1:10,153,-1:3,166,153,-1:11,166:12,108,166:9,-1:10,153,-1:3,166,153," +
"-1:11,166:10,109,166:11,-1:10,153,-1:3,166,153,-1:11,166:8,113,166:13,-1:10" +
",153,-1:3,166,153,-1:11,166:14,114,166:7,-1:10,153,-1:3,166,153,-1:11,166:4" +
",115,166:17,-1:10,153,-1:3,166,153,-1:11,166:12,116,166:9,-1:10,153,-1:3,16" +
"6,153,-1:11,166:6,119,166:15,-1:10,153,-1:3,166,153,-1:11,166:14,120,166:7," +
"-1:10,153,-1:3,166,153,-1:11,166:11,121,166:10,-1:10,153,-1:3,166,153,-1:11" +
",166:12,122,166:9,-1:10,153,-1:3,166,153,-1:11,166:13,126,166:8,-1:10,153,-" +
"1:3,166,153,-1:11,166:6,144,127,166:14,-1:10,153,-1:3,166,153,-1:11,166:9,1" +
"28,166:12,-1:10,153,-1:3,166,153,-1:11,166:6,129,166:15,-1:10,153,-1:3,166," +
"153,-1:11,166:16,130,166:5,-1:10,153,-1:3,166,153,-1:11,166:4,131,166:17,-1" +
":10,153,-1:3,166,153,-1:11,166:6,132,166:15,-1:10,153,-1:3,166,153,-1:11,16" +
"6:7,133,166:14,-1:10,153,-1:3,166,153,-1:11,134,166:21,-1:10,153,-1:3,166,1" +
"53,-1:11,166:4,135,166:17,-1:10,153,-1:3,166,153,-1:11,166:6,154,166,136,16" +
"6:13,-1:10,153,-1:3,166,153,-1:11,166:5,137,166:16,-1:10,153,-1:3,166,153,-" +
"1:11,166:8,138,166:13,-1:10,153,-1:3,166,153,-1:11,166:10,139,166:11,-1:10," +
"153,-1:3,166,153,-1:11,166:3,140,166:18,-1:10,153,-1:3,166,153,-1:11,166:4," +
"142,166:17,-1:10,153,-1:3,166,153,-1:11,166:12,143,166:9,-1:10,153,-1:3,166" +
",153,-1:11,166:10,145,166:11,-1:10,153,-1:3,166,153,-1:11,166:3,146,166:18," +
"-1:10,153,-1:3,166,153,-1:11,166:2,147,166:19,-1:10,153,-1:3,166,153,-1:11," +
"166:6,148,166:15,-1:10,153,-1:3,166,153,-1:11,166:2,149,166:19,-1:10,153,-1" +
":3,166,153,-1:11,166:2,156,166:19,-1:10,153,-1:3,166,153,-1:11,166:13,157,1" +
"66:8,-1:10,153,-1:3,166,153,-1:11,166:6,158,166:15,-1:10,153,-1:3,166,153,-" +
"1:11,166:12,150,166:9,-1:10,153,-1:3,166,153,-1:11,166:8,159,166:13,-1:10,1" +
"53,-1:3,166,153,-1:11,166:4,160,166:17,-1:10,153,-1:3,166,153,-1:11,166:8,1" +
"67,166:13,-1:10,153,-1:3,166,153,-1:11,166:6,162,166:15,-1:10,153,-1:3,166," +
"153,-1:11,163,166:21,-1:10,153,-1:3,166,153,-1:11,166:14,168,166:7,-1:10,15" +
"3,-1:3,166,153,-1:11,166:3,165,166:18,-1:10,153,-1:3,166,153,-1:11,166:6,15" +
"1,166:15,-1:10,153,-1:3,166,153,-1:11,166:8,161,166:13,-1:10,153,-1:3,166,1" +
"53,-1:11,166:8,164,166:13,-1:10,153,-1:3,166,153,-1:2");

	public java_cup.runtime.Symbol next_token ()
		throws java.io.IOException {
		int yy_lookahead;
		int yy_anchor = YY_NO_ANCHOR;
		int yy_state = yy_state_dtrans[yy_lexical_state];
		int yy_next_state = YY_NO_STATE;
		int yy_last_accept_state = YY_NO_STATE;
		boolean yy_initial = true;
		int yy_this_accept;

		yy_mark_start();
		yy_this_accept = yy_acpt[yy_state];
		if (YY_NOT_ACCEPT != yy_this_accept) {
			yy_last_accept_state = yy_state;
			yy_mark_end();
		}
		while (true) {
			if (yy_initial && yy_at_bol) yy_lookahead = YY_BOL;
			else yy_lookahead = yy_advance();
			yy_next_state = YY_F;
			yy_next_state = yy_nxt[yy_rmap[yy_state]][yy_cmap[yy_lookahead]];
			if (YY_EOF == yy_lookahead && true == yy_initial) {
				return null;
			}
			if (YY_F != yy_next_state) {
				yy_state = yy_next_state;
				yy_initial = false;
				yy_this_accept = yy_acpt[yy_state];
				if (YY_NOT_ACCEPT != yy_this_accept) {
					yy_last_accept_state = yy_state;
					yy_mark_end();
				}
			}
			else {
				if (YY_NO_STATE == yy_last_accept_state) {
					throw (new Error("Lexical Error: Unmatched Input."));
				}
				else {
					yy_anchor = yy_acpt[yy_last_accept_state];
					if (0 != (YY_END & yy_anchor)) {
						yy_move_end();
					}
					yy_to_mark();
					switch (yy_last_accept_state) {
					case 1:
						
					case -2:
						break;
					case 2:
						{}
					case -3:
						break;
					case 3:
						{
    System.out.println("Este es un error lexico: "+yytext()+", en la linea: "+yyline+", en la columna: "+yychar);
  }
					case -4:
						break;
					case 4:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -5:
						break;
					case 5:
						{return new Symbol(sym.BPPTCOMA,yyline,yychar, yytext());}
					case -6:
						break;
					case 6:
						{return new Symbol(sym.BPDOSPUNTOS,yyline,yychar, yytext());}
					case -7:
						break;
					case 7:
						{return new Symbol(sym.BPCOMA,yyline,yychar, yytext());}
					case -8:
						break;
					case 8:
						{return new Symbol(sym.BPLLAIZQ,yyline,yychar, yytext());}
					case -9:
						break;
					case 9:
						{return new Symbol(sym.BPLLADER,yyline,yychar, yytext());}
					case -10:
						break;
					case 10:
						{return new Symbol(sym.BPPAA,yyline,yychar,yytext());}
					case -11:
						break;
					case 11:
						{return new Symbol(sym.BPPAC,yyline,yychar,yytext());}
					case -12:
						break;
					case 12:
						{return new Symbol(sym.BPCORIZQ,yyline,yychar, yytext());}
					case -13:
						break;
					case 13:
						{return new Symbol(sym.BPCORDER,yyline,yychar, yytext());}
					case -14:
						break;
					case 14:
						{return new Symbol(sym.BPEQUAL,yyline,yychar, yytext());}
					case -15:
						break;
					case 15:
						{return new Symbol(sym.DD,yyline,yychar, yytext());}
					case -16:
						break;
					case 16:
						{return new Symbol(sym.BPCADENA,yyline,yychar, yytext());}
					case -17:
						break;
					case 17:
						{return new Symbol(sym.BPRUTA,yyline,yychar, yytext());}
					case -18:
						break;
					case 18:
						{}
					case -19:
						break;
					case 19:
						{}
					case -20:
						break;
					case 20:
						{return new Symbol(sym.BPEJEX,yyline,yychar,yytext());}
					case -21:
						break;
					case 21:
						{return new Symbol(sym.BPTITULO,yyline,yychar,yytext());}
					case -22:
						break;
					case 22:
						{return new Symbol(sym.BPSTG,yyline,yychar,yytext());}
					case -23:
						break;
					case 23:
						{return new Symbol(sym.BPDOUBLE,yyline,yychar,yytext());}
					case -24:
						break;
					case 24:
						{return new Symbol(sym.BPTTX,yyline,yychar,yytext());}
					case -25:
						break;
					case 25:
						{return new Symbol(sym.BPTTY,yyline,yychar,yytext());}
					case -26:
						break;
					case 26:
						{return new Symbol(sym.BPARCHIVO,yyline,yychar,yytext());}
					case -27:
						break;
					case 27:
						{return new Symbol(sym.BPCOMPARE,yyline,yychar,yytext());}
					case -28:
						break;
					case 28:
						{return new Symbol(sym.BPVALORES,yyline,yychar,yytext());}
					case -29:
						break;
					case 29:
						{return new Symbol(sym.BPGPIE,yyline,yychar,yytext());}
					case -30:
						break;
					case 30:
						{return new Symbol(sym.BPGLINEAS,yyline,yychar,yytext());}
					case -31:
						break;
					case 31:
						{return new Symbol(sym.BPGBARRAS,yyline,yychar,yytext());}
					case -32:
						break;
					case 32:
						{return new Symbol(sym.BPPUGE,yyline,yychar,yytext());}
					case -33:
						break;
					case 33:
						{return new Symbol(sym.BPDEG,yyline,yychar,yytext());}
					case -34:
						break;
					case 34:
						{return new Symbol(sym.BPPUES,yyline,yychar,yytext());}
					case -35:
						break;
					case 35:
						{return new Symbol(sym.BPGRE,yyline,yychar,yytext());}
					case -36:
						break;
					case 37:
						{
    System.out.println("Este es un error lexico: "+yytext()+", en la linea: "+yyline+", en la columna: "+yychar);
  }
					case -37:
						break;
					case 38:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -38:
						break;
					case 39:
						{return new Symbol(sym.DD,yyline,yychar, yytext());}
					case -39:
						break;
					case 40:
						{}
					case -40:
						break;
					case 41:
						{}
					case -41:
						break;
					case 43:
						{
    System.out.println("Este es un error lexico: "+yytext()+", en la linea: "+yyline+", en la columna: "+yychar);
  }
					case -42:
						break;
					case 44:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -43:
						break;
					case 46:
						{
    System.out.println("Este es un error lexico: "+yytext()+", en la linea: "+yyline+", en la columna: "+yychar);
  }
					case -44:
						break;
					case 47:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -45:
						break;
					case 49:
						{
    System.out.println("Este es un error lexico: "+yytext()+", en la linea: "+yyline+", en la columna: "+yychar);
  }
					case -46:
						break;
					case 50:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -47:
						break;
					case 52:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -48:
						break;
					case 54:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -49:
						break;
					case 56:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -50:
						break;
					case 58:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -51:
						break;
					case 60:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -52:
						break;
					case 62:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -53:
						break;
					case 63:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -54:
						break;
					case 64:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -55:
						break;
					case 65:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -56:
						break;
					case 66:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -57:
						break;
					case 67:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -58:
						break;
					case 69:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -59:
						break;
					case 71:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -60:
						break;
					case 72:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -61:
						break;
					case 73:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -62:
						break;
					case 74:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -63:
						break;
					case 75:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -64:
						break;
					case 76:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -65:
						break;
					case 77:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -66:
						break;
					case 78:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -67:
						break;
					case 79:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -68:
						break;
					case 80:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -69:
						break;
					case 81:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -70:
						break;
					case 82:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -71:
						break;
					case 83:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -72:
						break;
					case 84:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -73:
						break;
					case 85:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -74:
						break;
					case 86:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -75:
						break;
					case 87:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -76:
						break;
					case 88:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -77:
						break;
					case 89:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -78:
						break;
					case 90:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -79:
						break;
					case 91:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -80:
						break;
					case 92:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -81:
						break;
					case 93:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -82:
						break;
					case 94:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -83:
						break;
					case 95:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -84:
						break;
					case 96:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -85:
						break;
					case 97:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -86:
						break;
					case 98:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -87:
						break;
					case 99:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -88:
						break;
					case 100:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -89:
						break;
					case 101:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -90:
						break;
					case 102:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -91:
						break;
					case 103:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -92:
						break;
					case 104:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -93:
						break;
					case 105:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -94:
						break;
					case 106:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -95:
						break;
					case 107:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -96:
						break;
					case 108:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -97:
						break;
					case 109:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -98:
						break;
					case 110:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -99:
						break;
					case 111:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -100:
						break;
					case 112:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -101:
						break;
					case 113:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -102:
						break;
					case 114:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -103:
						break;
					case 115:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -104:
						break;
					case 116:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -105:
						break;
					case 117:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -106:
						break;
					case 118:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -107:
						break;
					case 119:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -108:
						break;
					case 120:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -109:
						break;
					case 121:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -110:
						break;
					case 122:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -111:
						break;
					case 123:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -112:
						break;
					case 124:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -113:
						break;
					case 125:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -114:
						break;
					case 126:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -115:
						break;
					case 127:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -116:
						break;
					case 128:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -117:
						break;
					case 129:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -118:
						break;
					case 130:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -119:
						break;
					case 131:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -120:
						break;
					case 132:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -121:
						break;
					case 133:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -122:
						break;
					case 134:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -123:
						break;
					case 135:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -124:
						break;
					case 136:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -125:
						break;
					case 137:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -126:
						break;
					case 138:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -127:
						break;
					case 139:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -128:
						break;
					case 140:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -129:
						break;
					case 141:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -130:
						break;
					case 142:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -131:
						break;
					case 143:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -132:
						break;
					case 144:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -133:
						break;
					case 145:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -134:
						break;
					case 146:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -135:
						break;
					case 147:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -136:
						break;
					case 148:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -137:
						break;
					case 149:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -138:
						break;
					case 150:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -139:
						break;
					case 151:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -140:
						break;
					case 152:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -141:
						break;
					case 153:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -142:
						break;
					case 154:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -143:
						break;
					case 155:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -144:
						break;
					case 156:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -145:
						break;
					case 157:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -146:
						break;
					case 158:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -147:
						break;
					case 159:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -148:
						break;
					case 160:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -149:
						break;
					case 161:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -150:
						break;
					case 162:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -151:
						break;
					case 163:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -152:
						break;
					case 164:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -153:
						break;
					case 165:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -154:
						break;
					case 166:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -155:
						break;
					case 167:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -156:
						break;
					case 168:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -157:
						break;
					default:
						yy_error(YY_E_INTERNAL,false);
					case -1:
					}
					yy_initial = true;
					yy_state = yy_state_dtrans[yy_lexical_state];
					yy_next_state = YY_NO_STATE;
					yy_last_accept_state = YY_NO_STATE;
					yy_mark_start();
					yy_this_accept = yy_acpt[yy_state];
					if (YY_NOT_ACCEPT != yy_this_accept) {
						yy_last_accept_state = yy_state;
						yy_mark_end();
					}
				}
			}
		}
	}
}
