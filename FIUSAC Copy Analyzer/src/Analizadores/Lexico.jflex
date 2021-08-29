package analizadores;
import Errores.Excepciones;
import java_cup.runtime.Symbol;
import java.util.ArrayList; 

%% 
%class Lexico
%public 
%cupsym sym
%line 
%char 
%cup 
%unicode
%ignorecase

%{
    public ArrayList<Excepciones> Errores; 
%}

%init{ 
    yyline = 1; 
    yychar = 1;
    Errores = new ArrayList();
%init} 

BLANCOS = [ \r\t\n]+
COMENTLINEA = ("//".*\n)|("//".*\r\n)|("//".*\r)
COMENTMULTILINEA = "<!""!"*([^!>]|[^!]">"|"!"[^>])*"!"*"!>"
ESPECIALES =  [\\]("n"|"'"|"\"")+
ENTERO=[0-9]+
DD=[0-9]+("."[  |0-9]+)?
LETRA = [a-zA-Z]
IDENTIFICADOR = {LETRA}({LETRA}|"_"|{ENTERO})*
CASOA = [0-9]+"~"[0-9]+
CASOB = [A-Z]+"~"[A-Z]+
CASOC = [a-z]+"~"[a-z]+
CASOE = (["!"-"/"]|[":"-"@"]|["["-"`"]|["{"-"}"])+"~"+(["!"-"/"]|[":"-"@"]|["["-"`"]|["{"-"}"])
CASOD = ([0-9]|[A-Z]|[a-z])+"~"([0-9]|[A-Z]|[a-z])+
CUERPOCONJUNTO = {CASOA}|{CASOB}|{CASOC}|{CASOE}|{CASOD}
BPCADENA = "\""[^"\""]*"\""


%%

{BLANCOS} {} 
{COMENTLINEA} {}
{COMENTMULTILINEA} {}
{ESPECIALES} {return new Symbol(sym.ESPECIALES,yyline,yychar, yytext());}

"COMPARE" {return new Symbol(sym.BPCOMPARE,yyline,yychar,yytect());}
"DefinirGlobales" {return new Symbol(sym.BPDEG,yyline,yychar,yytect());}
"GenerarReporteEstadistico" {return new Symbol(sym.BPGRE,yyline,yychar,yytect());}
"string" {return new Symbol(sym.BPSTG,yyline,yychar,yytect());}
"double" {return new Symbol(sym.BPDOUBLE,yyline,yychar,yytect());}
"GraficaBarras" {return new Symbol(sym.BPGBARRAS,yyline,yychar,yytect());}
"Titulo" {return new Symbol(sym.BPTITULO,yyline,yychar,yytect());}
"Ejex" {return new Symbol(sym.BPEJEX,yyline,yychar,yytect());}
"Valores" {return new Symbol(sym.BPVALORES,yyline,yychar,yytect());}
"TituloX" {return new Symbol(sym.BPTTX,yyline,yychar,yytect());}
"TituloY" {return new Symbol(sym.BPTTY,yyline,yychar,yytect());}
"GraficaPie" {return new Symbol(sym.BPGPIE,yyline,yychar,yytect());}
"GraficaLineas" {return new Symbol(sym.BPGLINEAS,yyline,yychar,yytect());}
"Archivo" {return new Symbol(sym.BPARCHIVO,yyline,yychar,yytect());}
";" {return new Symbol(sym.BPPTCOMA,yyline,yychar, yytext());}
":" {return new Symbol(sym.BPDOSPUNTOS,yyline,yychar, yytext());} 
"." {return new Symbol(sym.BPPUNTO,yyline,yychar, yytext());} 
"," {return new Symbol(sym.BPCOMA,yyline,yychar, yytext());} 
"(" {return new Symbol(sym.BPPARIZQ,yyline,yychar, yytext());} 
")" {return new Symbol(sym.BPPARDER,yyline,yychar, yytext());} 
"{" {return new Symbol(sym.BPLLAIZQ,yyline,yychar, yytext());} 
"}" {return new Symbol(sym.BPLLADER,yyline,yychar, yytext());} 
"[" {return new Symbol(sym.BPCORIZQ,yyline,yychar, yytext());} 
"]" {return new Symbol(sym.BPCORDER,yyline,yychar, yytext());} 
"+" {return new Symbol(sym.BPMAS,yyline,yychar, yytext());} 
"-" {return new Symbol(sym.BPGUION,yyline,yychar, yytext());} 
"*" {return new Symbol(sym.BPPOR,yyline,yychar, yytext());} 
"/" {return new Symbol(sym.BPDIVIDIR,yyline,yychar, yytext());}
">" {return new Symbol(sym.BPMAYOR,yyline,yychar, yytext());}
"<" {return new Symbol(sym.BPMENOR,yyline,yychar, yytext());}
"?" {return new Symbol(sym.BPPREGUNTA,yyline,yychar, yytext());}
"%" {return new Symbol(sym.BPPORCENTAJE,yyline,yychar, yytext());}
"&" {return new Symbol(sym.BPYAND,yyline,yychar, yytext());}
"|" {return new Symbol(sym.BPOOR,yyline,yychar, yytext());}
"=" {return new Symbol(sym.BPEQUAL,yyline,yychar, yytext());}

 
\n {yychar=1;}
\n {yyline=1;}


{ENTERO} {return new Symbol(sym.ENTERO,yyline,yychar, yytext());} 
{DD} {return new Symbol(sym.DECIMAL,yyline,yychar, yytext());}
{IDENTIFICADOR} {return new Symbol(sym.IDENTIFICADOR,yyline,yychar, yytext());}
{CUERPOCONJUNTO} {return new Symbol(sym.CUERPOCONJUNTO,yyline,yychar, yytext());}
{BPCADENA} {return new Symbol(sym.EECADENA,yyline,yychar, yytext());}


 
. {
    Errores.add(new Excepciones("Léxico", "Caracter no válido detectado: " + yytext(), yyline + "", yychar + ""));
    /*
     *System.out.println("Este es un error lexico: "+yytext()+
     *", en la linea: "+yyline+", en la columna: "+yychar);
     */
  }