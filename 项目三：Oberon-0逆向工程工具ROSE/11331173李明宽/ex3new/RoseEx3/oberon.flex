import java.io.*;

import org.omg.CORBA.PUBLIC_MEMBER;

import java_cup.runtime.*;
import exceptions.*;

%%

%class OberonScanner
%eofval{
    return symbol(Symbol.EOF, new String("EOF"));
%eofval}
%yylexthrow LexicalException
%cup
%line
%column
%ignorecase

%{
    public static void init(){}
    private java_cup.runtime.Symbol symbol(int sym, Object value)
    {
      return new java_cup.runtime.Symbol(sym, yyline, yycolumn, value);
    }
    
    public int getLine(){
	return yyline+1;
    }
    public int getColumn(){
	return yycolumn;
    }
%}

BLANK = " " | \r | \n | \r\n | \t | \f | \b
COMMENT = \(\*([^\*]|(\*)+[^\*\)])*(\*)*\*\)
// COMMENT = "(*"~"*)"

ILLMISCOMMENT = \(\*([^\*\)]|[\*]+[^\)])*|([^\(]|(\()+[^\*])*\*\)
IDENTIFIER = [a-zA-Z][0-9a-zA-Z]*
DECNUMBER = [1-9][0-9]*
OCTNUMBER = 0[0-7]*
ILLINTEGER = [0-9]+[a-zA-Z][0-9a-zA-Z]*
ILLOCTAL = 0[0-7]*[89]+[0-9]*

%%

<YYINITIAL>
{
    {COMMENT} {/*Do Nothing*/}
    {BLANK} {/*Do Nothing*/}
    
    {ILLMISCOMMENT} {throw new MismatchedCommentException(yyline, yycolumn);}
    {ILLINTEGER} {throw new IllegalIntegerException(yyline, yycolumn);}
    {ILLOCTAL} {throw new IllegalOctalException(yyline, yycolumn);}
    
    "BOOLEAN" {return symbol(Symbol.BOOLEAN, new String("BOOLEAN"));}
    "INTEGER" {return symbol(Symbol.INTEGER, new String("INTEGER"));}
    "MODULE" {return symbol(Symbol.MODULE, new String("MODULE"));}
    "BEGIN" {return symbol(Symbol.BEGIN, new String("BEGIN"));}
    "END" {return symbol(Symbol.END, new String("END"));}
    "CONST" {return symbol(Symbol.CONST, new String("CONST"));}
    "TYPE" {return symbol(Symbol.TYPE, new String("TYPE"));}
    "VAR" {return symbol(Symbol.VAR, new String("VAR"));}
    "PROCEDURE" {return symbol(Symbol.PROCEDURE, new String("PROCEDURE"));}
    "RECORD" {return symbol(Symbol.RECORD, new String("RECORD"));}
    "ARRAY" {return symbol(Symbol.ARRAY, new String("ARRAY"));}
    "OF" {return symbol(Symbol.OF, new String("OF"));}
    "WHILE" {return symbol(Symbol.WHILE, new String("WHILE"));}
    "DO" {return symbol(Symbol.DO, new String("DO"));}
    "IF" {return symbol(Symbol.IF, new String("IF"));}
    "THEN" {return symbol(Symbol.THEN, new String("THEN"));}
    "ELSIF" {return symbol(Symbol.ELSIF, new String("ELSIF"));}
    "ELSE" {return symbol(Symbol.ELSE, new String("ELSE"));}
    "OR" {return symbol(Symbol.OR, new String("OR"));}
    "DIV" {return symbol(Symbol.DIV, new String("DIV"));}
    "MOD" {return symbol(Symbol.MOD, new String("MOD"));}
    {IDENTIFIER} {
	if(yylength() > 24){
	    throw new IllegalIdentifierLengthException(yyline, yycolumn);
	} else {
	return symbol(Symbol.IDENTIFIER, new String(yytext()).toLowerCase());
	}
    }
    {DECNUMBER} {
	if(yylength() > 12){
	    throw new IllegalIntegerRangeException(yyline, yycolumn);
	} else {
	    return symbol(Symbol.NUMBER, Integer.parseInt(yytext(), 10));
	}
    }
    {OCTNUMBER} {
	if(yylength() > 12){
	    throw new IllegalIntegerRangeException(yyline, yycolumn);
	} else {
	    return symbol(Symbol.NUMBER, Integer.parseInt(yytext(), 8));
	}
    }
    "+" {return symbol(Symbol.ADD, new String("+"));}
    "-" {return symbol(Symbol.MINUS, new String("-"));}
    "*" {return symbol(Symbol.MUL, new String("*"));}
    ">" {return symbol(Symbol.BIG, new String(">"));}
    ">=" {return symbol(Symbol.BIGEQ, new String(">="));}
    "<" {return symbol(Symbol.LESS, new String("<"));}
    "<=" {return symbol(Symbol.LESSEQ, new String("<="));}
    "#" {return symbol(Symbol.NOTEQ, new String("#"));}
    "=" {return symbol(Symbol.EQUAL, new String("="));}
    "&" {return symbol(Symbol.AND, new String("&"));}
    "~" {return symbol(Symbol.NOT, new String("~"));}
    ":=" {return symbol(Symbol.ASSIGN, new String(":="));}
    "." {return symbol(Symbol.DOT, new String("."));}
    "[" {return symbol(Symbol.LSQBRACKET, new String("["));}
    "]" {return symbol(Symbol.RSQBRACKET, new String("]"));}
    "(" {return symbol(Symbol.LPARENTHESE, new String("("));}
    ")" {return symbol(Symbol.RPARENTHESE, new String(")"));}
    ":" {return symbol(Symbol.COLON, new String(":"));}
    ";" {return symbol(Symbol.SEMI, new String(";"));}
    "," {return symbol(Symbol.COMMA, new String(","));}
    
    .  {throw new IllegalSymbolException(yyline, yycolumn);}
}