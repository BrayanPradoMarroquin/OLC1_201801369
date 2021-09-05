package analizadorJs;
import java_cup.runtime.Symbol;
import java.util.ArrayList; 


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
		/* 36 */ YY_NO_ANCHOR,
		/* 37 */ YY_NO_ANCHOR,
		/* 38 */ YY_NO_ANCHOR,
		/* 39 */ YY_NO_ANCHOR,
		/* 40 */ YY_NO_ANCHOR,
		/* 41 */ YY_NO_ANCHOR,
		/* 42 */ YY_NO_ANCHOR,
		/* 43 */ YY_NO_ANCHOR,
		/* 44 */ YY_NO_ANCHOR,
		/* 45 */ YY_NO_ANCHOR,
		/* 46 */ YY_NO_ANCHOR,
		/* 47 */ YY_NO_ANCHOR,
		/* 48 */ YY_NO_ANCHOR,
		/* 49 */ YY_NO_ANCHOR,
		/* 50 */ YY_NO_ANCHOR,
		/* 51 */ YY_NO_ANCHOR,
		/* 52 */ YY_NO_ANCHOR,
		/* 53 */ YY_NOT_ACCEPT,
		/* 54 */ YY_NO_ANCHOR,
		/* 55 */ YY_NO_ANCHOR,
		/* 56 */ YY_NO_ANCHOR,
		/* 57 */ YY_NO_ANCHOR,
		/* 58 */ YY_NO_ANCHOR,
		/* 59 */ YY_NOT_ACCEPT,
		/* 60 */ YY_NO_ANCHOR,
		/* 61 */ YY_NO_ANCHOR,
		/* 62 */ YY_NOT_ACCEPT,
		/* 63 */ YY_NO_ANCHOR,
		/* 64 */ YY_NO_ANCHOR,
		/* 65 */ YY_NOT_ACCEPT,
		/* 66 */ YY_NO_ANCHOR,
		/* 67 */ YY_NO_ANCHOR,
		/* 68 */ YY_NOT_ACCEPT,
		/* 69 */ YY_NO_ANCHOR,
		/* 70 */ YY_NOT_ACCEPT,
		/* 71 */ YY_NO_ANCHOR,
		/* 72 */ YY_NOT_ACCEPT,
		/* 73 */ YY_NO_ANCHOR,
		/* 74 */ YY_NOT_ACCEPT,
		/* 75 */ YY_NO_ANCHOR,
		/* 76 */ YY_NOT_ACCEPT,
		/* 77 */ YY_NO_ANCHOR,
		/* 78 */ YY_NOT_ACCEPT,
		/* 79 */ YY_NO_ANCHOR,
		/* 80 */ YY_NOT_ACCEPT,
		/* 81 */ YY_NO_ANCHOR,
		/* 82 */ YY_NOT_ACCEPT,
		/* 83 */ YY_NO_ANCHOR,
		/* 84 */ YY_NOT_ACCEPT,
		/* 85 */ YY_NO_ANCHOR,
		/* 86 */ YY_NO_ANCHOR,
		/* 87 */ YY_NO_ANCHOR,
		/* 88 */ YY_NO_ANCHOR,
		/* 89 */ YY_NO_ANCHOR,
		/* 90 */ YY_NO_ANCHOR,
		/* 91 */ YY_NOT_ACCEPT,
		/* 92 */ YY_NO_ANCHOR,
		/* 93 */ YY_NOT_ACCEPT,
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
		/* 128 */ YY_NO_ANCHOR
	};
	private int yy_cmap[] = unpackFromString(1,65538,
"8:9,4,5,8:2,1,8:18,45,7,48,8:2,40,41,49,33,34,39,37,32,38,24,2,44:10,31,30," +
"6,43,3,8:2,11,28,9,23,15,20,25,22,19,46,29,10,46,18,17,46,26,14,12,16,27,13" +
",21,46:3,8:4,47,8,11,28,9,23,15,20,25,22,19,46,29,10,46,18,17,46,26,14,12,1" +
"6,27,13,21,46:3,35,42,36,8:65410,0:2")[0];

	private int yy_rmap[] = unpackFromString(1,129,
"0,1,2,3,4,5,6,1,7,1:8,8,9,10,1,11,12,1:3,13:2,1:8,14,13:3,15,13:11,1,16,17," +
"18,19,1:2,20,21,22,19,23,24,23,25,26,25,27,15,28,29,30,31,32,33,34,35,36,37" +
",38,39,40,41,42,43,44,45,46,47,31,48,49,50,51,52,13,53,54,55,56,57,58,59,60" +
",61,62,63,64,65,66,67,68,69,70,71,72,73,74,13,75,76,77,78,79,80,81,82")[0];

	private int yy_nxt[][] = unpackFromString(83,50,
"1,2,3,4,2:2,5,6,7,8,90,120,122,92,123,124,125,120:2,55,94,126,120,61,9,120:" +
"3,127,120,10,11,12,13,14,15,16,17,18,19,20,54,60,21,22,2,120,7,63,66,-1:51," +
"2,-1:2,2:2,-1:39,2,-1:6,53,-1:90,23,-1:13,59,-1:35,24,-1:49,25,-1:15,120,12" +
"8,95,120:5,96,120:6,-1,120:5,-1:14,97,-1,120,97,-1:39,28,-1:50,29,-1:50,30," +
"-1:53,33,-1:30,62,-1:19,22,-1:14,120:15,-1,120:5,-1:14,97,-1,120,97,-1:7,57" +
",-1:47,93,-1:47,36,53:3,57,53:44,-1:41,31,-1:17,120:11,26,120:3,-1,120:5,-1" +
":14,97,-1,120,97,-1:44,56,-1,56:2,-1:5,91:2,70,91:3,72,91:42,-1:42,32,-1:16" +
",120:6,103,120,27,120:6,-1,120:5,-1:14,97,-1,120,97,-1:3,65:47,34,65,-1:9,1" +
"20:7,37,120:7,-1,120:5,-1:14,97,-1,120,97,-1:3,68:48,35,-1:9,120:5,38,120:9" +
",-1,120:5,-1:14,97,-1,120,97,-1:11,120:5,39,120:9,-1,120:5,-1:14,97,-1,120," +
"97,-1:11,120:6,41,120:8,-1,120:5,-1:14,97,-1,120,97,-1:3,91:2,40,91:3,72,91" +
":42,-1:9,120:6,42,120:8,-1,120:5,-1:14,97,-1,120,97,-1:3,91:2,74,91:3,76,91" +
":42,-1:9,120:6,43,120:8,-1,120:5,-1:14,97,-1,120,97,-1:3,93:2,58,93:3,78,93" +
":42,-1:9,120:3,44,120:11,-1,120:5,-1:14,97,-1,120,97,-1:3,91:2,40,91:3,76,9" +
"1:42,-1:9,120:7,45,116,120:6,-1,120:5,-1:14,97,-1,120,97,-1:12,82,-1:48,120" +
":6,46,120:8,-1,120:5,-1:14,97,-1,120,97,-1:19,84,-1:41,120:6,47,120:8,-1,12" +
"0:5,-1:14,97,-1,120,97,-1:27,52,-1:33,120:15,-1,120:4,48,-1:14,97,-1,120,97" +
",-1:11,120:13,49,120,-1,120:5,-1:14,97,-1,120,97,-1:11,120:6,50,120:8,-1,12" +
"0:5,-1:14,97,-1,120,97,-1:11,120:7,51,120:7,-1,120:5,-1:14,97,-1,120,97,-1:" +
"11,120:15,80,120:5,-1:14,97,-1,120,97,-1:11,120:6,64,120:8,-1,120:5,-1:14,9" +
"7,-1,120,97,-1:11,120:2,67,120:12,-1,120:5,-1:14,97,-1,120,97,-1:3,91:2,70," +
"91:3,76,91:42,-1:9,120:2,102,120:5,69,120:6,-1,120:5,-1:14,97,-1,120,97,-1:" +
"11,120:3,71,120:11,-1,120:5,-1:14,97,-1,120,97,-1:11,120:9,106,120:5,-1,120" +
":5,-1:14,97,-1,120,97,-1:11,120:10,107,120:4,-1,120:5,-1:14,97,-1,120,97,-1" +
":11,120:15,-1,120,108,120:3,-1:14,97,-1,120,97,-1:11,120:3,73,120:11,-1,120" +
":5,-1:14,97,-1,120,97,-1:11,120:15,-1,120:2,75,120:2,-1:14,97,-1,120,97,-1:" +
"11,120,109,120:13,-1,120:5,-1:14,97,-1,120,97,-1:11,120:11,111,120:3,-1,120" +
":5,-1:14,97,-1,120,97,-1:11,120:6,112,120:8,-1,120:5,-1:14,97,-1,120,97,-1:" +
"11,120:3,77,120:11,-1,120:5,-1:14,97,-1,120,97,-1:11,120:3,79,120:11,-1,120" +
":5,-1:14,97,-1,120,97,-1:11,120:7,113,120:7,-1,120:5,-1:14,97,-1,120,97,-1:" +
"11,120:15,-1,120:2,114,120:2,-1:14,97,-1,120,97,-1:11,120:3,81,120:11,-1,12" +
"0:5,-1:14,97,-1,120,97,-1:11,120,83,120:13,-1,120:5,-1:14,97,-1,120,97,-1:1" +
"1,120:2,115,120:12,-1,120:5,-1:14,97,-1,120,97,-1:11,120:2,85,120:12,-1,120" +
":5,-1:14,97,-1,120,97,-1:11,86,120:14,-1,120:5,-1:14,97,-1,120,97,-1:11,120" +
":10,117,120:4,-1,120:5,-1:14,97,-1,120,97,-1:11,120:15,-1,120:2,118,120:2,-" +
"1:14,97,-1,120,97,-1:11,120,119,120:13,-1,120:5,-1:14,97,-1,120,97,-1:11,12" +
"0:5,87,120:9,-1,120:5,-1:14,97,-1,120,97,-1:11,120,88,120:13,-1,120:5,-1:14" +
",97,-1,120,97,-1:11,120:6,89,120:8,-1,120:5,-1:14,97,-1,120,97,-1:11,120:10" +
",110,120:4,-1,120:5,-1:14,97,-1,120,97,-1:11,120:12,98,120:2,-1,120:5,-1:14" +
",97,-1,120,97,-1:11,120:6,99,120:8,-1,120:5,-1:14,97,-1,120,97,-1:11,120,10" +
"0,120:13,-1,120:5,-1:14,97,-1,120,97,-1:11,120:5,101,120:9,-1,120:5,-1:14,9" +
"7,-1,120,97,-1:11,120:13,121,120,-1,120:5,-1:14,97,-1,120,97,-1:11,120:5,10" +
"4,120:9,-1,120:5,-1:14,97,-1,120,97,-1:11,120:2,105,120:12,-1,120:5,-1:14,9" +
"7,-1,120,97,-1:2");

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
						{return new Symbol(sym.BPDIVIDIR,yyline,yychar, yytext());}
					case -4:
						break;
					case 4:
						{return new Symbol(sym.BPMAYOR,yyline,yychar, yytext());}
					case -5:
						break;
					case 5:
						{return new Symbol(sym.BPMENOR,yyline,yychar, yytext());}
					case -6:
						break;
					case 6:
						{return new Symbol(sym.BPNEG,yyline,yychar, yytext());}
					case -7:
						break;
					case 7:
						{
    System.out.println("Este es un error lexico: " + yytext()+ ", en la linea: "+yyline+", en la columna: "+yychar);
}
					case -8:
						break;
					case 8:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -9:
						break;
					case 9:
						{return new Symbol(sym.BPPUNTO,yyline,yychar, yytext());}
					case -10:
						break;
					case 10:
						{return new Symbol(sym.BPPTCOMA,yyline,yychar, yytext());}
					case -11:
						break;
					case 11:
						{return new Symbol(sym.BPDOSPUNTOS,yyline,yychar, yytext());}
					case -12:
						break;
					case 12:
						{return new Symbol(sym.BPCOMA,yyline,yychar, yytext());}
					case -13:
						break;
					case 13:
						{return new Symbol(sym.BPPARIZQ,yyline,yychar, yytext());}
					case -14:
						break;
					case 14:
						{return new Symbol(sym.BPPARDER,yyline,yychar, yytext());}
					case -15:
						break;
					case 15:
						{return new Symbol(sym.BPLLAIZQ,yyline,yychar, yytext());}
					case -16:
						break;
					case 16:
						{return new Symbol(sym.BPLLADER,yyline,yychar, yytext());}
					case -17:
						break;
					case 17:
						{return new Symbol(sym.BPMAS,yyline,yychar, yytext());}
					case -18:
						break;
					case 18:
						{return new Symbol(sym.BPGUION,yyline,yychar, yytext());}
					case -19:
						break;
					case 19:
						{return new Symbol(sym.BPPOR,yyline,yychar, yytext());}
					case -20:
						break;
					case 20:
						{return new Symbol(sym.BPMOD,yyline,yychar, yytext());}
					case -21:
						break;
					case 21:
						{return new Symbol(sym.BPEQUAL,yyline,yychar, yytext());}
					case -22:
						break;
					case 22:
						{return new Symbol(sym.DD,yyline,yychar, yytext());}
					case -23:
						break;
					case 23:
						{return new Symbol(sym.BPMAYOREQUALS,yyline,yychar, yytext());}
					case -24:
						break;
					case 24:
						{return new Symbol(sym.BPMENOREQUALS,yyline,yychar, yytext());}
					case -25:
						break;
					case 25:
						{return new Symbol(sym.BPNOTEQUALS,yyline,yychar, yytext());}
					case -26:
						break;
					case 26:
						{return new Symbol(sym.BPIF,yyline,yychar,yytext());}
					case -27:
						break;
					case 27:
						{return new Symbol(sym.BPDO,yyline,yychar,yytext());}
					case -28:
						break;
					case 28:
						{return new Symbol(sym.BPAUMENTO,yyline,yychar, yytext());}
					case -29:
						break;
					case 29:
						{return new Symbol(sym.BPDISMINUIR,yyline,yychar, yytext());}
					case -30:
						break;
					case 30:
						{return new Symbol(sym.BPPON,yyline,yychar, yytext());}
					case -31:
						break;
					case 31:
						{return new Symbol(sym.BPYAND,yyline,yychar, yytext());}
					case -32:
						break;
					case 32:
						{return new Symbol(sym.BPOOR,yyline,yychar, yytext());}
					case -33:
						break;
					case 33:
						{return new Symbol(sym.BPEQUALCONDITION,yyline,yychar, yytext());}
					case -34:
						break;
					case 34:
						{return new Symbol(sym.BPCADENA,yyline,yychar, yytext());}
					case -35:
						break;
					case 35:
						{return new Symbol(sym.BPRUTA,yyline,yychar, yytext());}
					case -36:
						break;
					case 36:
						{}
					case -37:
						break;
					case 37:
						{return new Symbol(sym.BPLET,yyline,yychar,yytext());}
					case -38:
						break;
					case 38:
						{return new Symbol(sym.BPVAR,yyline,yychar,yytext());}
					case -39:
						break;
					case 39:
						{return new Symbol(sym.BPFOR,yyline,yychar,yytext());}
					case -40:
						break;
					case 40:
						{}
					case -41:
						break;
					case 41:
						{return new Symbol(sym.BPCASE,yyline,yychar,yytext());}
					case -42:
						break;
					case 42:
						{return new Symbol(sym.BPELSE,yyline,yychar,yytext());}
					case -43:
						break;
					case 43:
						{return new Symbol(sym.BPTRUE,yyline,yychar, yytext());}
					case -44:
						break;
					case 44:
						{return new Symbol(sym.BPCLASS,yyline,yychar,yytext());}
					case -45:
						break;
					case 45:
						{return new Symbol(sym.BPCNST,yyline,yychar,yytext());}
					case -46:
						break;
					case 46:
						{return new Symbol(sym.BPFALSE,yyline,yychar, yytext());}
					case -47:
						break;
					case 47:
						{return new Symbol(sym.BPWHILE,yyline,yychar,yytext());}
					case -48:
						break;
					case 48:
						{return new Symbol(sym.BPBREAK,yyline,yychar,yytext());}
					case -49:
						break;
					case 49:
						{return new Symbol(sym.BPSWITCH,yyline,yychar,yytext());}
					case -50:
						break;
					case 50:
						{return new Symbol(sym.BPRQRE,yyline,yychar,yytext());}
					case -51:
						break;
					case 51:
						{return new Symbol(sym.BPDEFAULT,yyline,yychar,yytext());}
					case -52:
						break;
					case 52:
						{return new Symbol(sym.BPCONS,yyline,yychar,yytext());}
					case -53:
						break;
					case 54:
						{
    System.out.println("Este es un error lexico: " + yytext()+ ", en la linea: "+yyline+", en la columna: "+yychar);
}
					case -54:
						break;
					case 55:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -55:
						break;
					case 56:
						{return new Symbol(sym.DD,yyline,yychar, yytext());}
					case -56:
						break;
					case 57:
						{}
					case -57:
						break;
					case 58:
						{}
					case -58:
						break;
					case 60:
						{
    System.out.println("Este es un error lexico: " + yytext()+ ", en la linea: "+yyline+", en la columna: "+yychar);
}
					case -59:
						break;
					case 61:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -60:
						break;
					case 63:
						{
    System.out.println("Este es un error lexico: " + yytext()+ ", en la linea: "+yyline+", en la columna: "+yychar);
}
					case -61:
						break;
					case 64:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -62:
						break;
					case 66:
						{
    System.out.println("Este es un error lexico: " + yytext()+ ", en la linea: "+yyline+", en la columna: "+yychar);
}
					case -63:
						break;
					case 67:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -64:
						break;
					case 69:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -65:
						break;
					case 71:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -66:
						break;
					case 73:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -67:
						break;
					case 75:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -68:
						break;
					case 77:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -69:
						break;
					case 79:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -70:
						break;
					case 81:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -71:
						break;
					case 83:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -72:
						break;
					case 85:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -73:
						break;
					case 86:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -74:
						break;
					case 87:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -75:
						break;
					case 88:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -76:
						break;
					case 89:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -77:
						break;
					case 90:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -78:
						break;
					case 92:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -79:
						break;
					case 94:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -80:
						break;
					case 95:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -81:
						break;
					case 96:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -82:
						break;
					case 97:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -83:
						break;
					case 98:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -84:
						break;
					case 99:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -85:
						break;
					case 100:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -86:
						break;
					case 101:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -87:
						break;
					case 102:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -88:
						break;
					case 103:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -89:
						break;
					case 104:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -90:
						break;
					case 105:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -91:
						break;
					case 106:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -92:
						break;
					case 107:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -93:
						break;
					case 108:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -94:
						break;
					case 109:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -95:
						break;
					case 110:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -96:
						break;
					case 111:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -97:
						break;
					case 112:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -98:
						break;
					case 113:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -99:
						break;
					case 114:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -100:
						break;
					case 115:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -101:
						break;
					case 116:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -102:
						break;
					case 117:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -103:
						break;
					case 118:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -104:
						break;
					case 119:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -105:
						break;
					case 120:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -106:
						break;
					case 121:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -107:
						break;
					case 122:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -108:
						break;
					case 123:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -109:
						break;
					case 124:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -110:
						break;
					case 125:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -111:
						break;
					case 126:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -112:
						break;
					case 127:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -113:
						break;
					case 128:
						{return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
					case -114:
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
