import java.io.*;
import java_cup.runtime.*;
import exceptions.*;

%%

%class OberonScanner
%eofval{
    return symbol(sym.EOF, new String("EOF"));
%eofval}
%yylexthrow LexicalException
%cup
%line
%column
%ignorecase

%{
    public static void main(String argv[]){
	if (argv.length == 0){
	    System.out.println("Please give an input file...");
	} else {
	    try{
		OberonScanner scanner = new OberonScanner(new FileReader(argv[0]));
		Symbol token;
		while(true){
		    token = scanner.next_token();
		    if(token.sym == sym.EOF || token.sym == sym.ERROR){
			break;
		    } else {
			System.out.print(" <" + token.value.toString() + "> ");
		    }
		}
	    } catch (FileNotFoundException e){
		System.err.println("File not found!");
	    } catch (IOException e){
		System.err.println("IO exception!");
	    } catch (LexicalException e){
		System.err.println(e);
	    }
	}
    }
    private Symbol symbol(int sym, Object value)
    {
      return new Symbol(sym, yyline, yycolumn, value);
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
    {COMMENT} {System.out.print(yytext());}
    {BLANK} {System.out.print(yytext());}
    
    {ILLMISCOMMENT} {System.out.println(yytext());throw new MismatchedCommentException(yyline, yycolumn);}
    {ILLINTEGER} {System.out.println(yytext());throw new IllegalIntegerException(yyline, yycolumn);}
    {ILLOCTAL} {System.out.println(yytext());throw new IllegalOctalException(yyline, yycolumn);}
    
    "BOOLEAN" {return symbol(sym.IDENTIFIER, new String("BOOLEAN"));}
    "INTEGER" {return symbol(sym.IDENTIFIER, new String("INTEGER"));}
    "MODULE" {return symbol(sym.MODULE, new String("MODULE"));}
    "BEGIN" {return symbol(sym.BEGIN, new String("BEGIN"));}
    "END" {return symbol(sym.END, new String("END"));}
    "CONST" {return symbol(sym.CONST, new String("CONST"));}
    "TYPE" {return symbol(sym.TYPE, new String("TYPE"));}
    "VAR" {return symbol(sym.VAR, new String("VAR"));}
    "PROCEDURE" {return symbol(sym.PROCEDURE, new String("PROCEDURE"));}
    "RECORD" {return symbol(sym.RECORD, new String("RECORD"));}
    "ARRAY" {return symbol(sym.ARRAY, new String("ARRAY"));}
    "OF" {return symbol(sym.OF, new String("OF"));}
    "WHILE" {return symbol(sym.WHILE, new String("WHILE"));}
    "DO" {return symbol(sym.DO, new String("DO"));}
    "IF" {return symbol(sym.IF, new String("IF"));}
    "THEN" {return symbol(sym.THEN, new String("THEN"));}
    "ELSIF" {return symbol(sym.ELSIF, new String("ELSIF"));}
    "ELSE" {return symbol(sym.ELSE, new String("ELSE"));}
    "OR" {return symbol(sym.OR, new String("OR"));}
    "DIV" {return symbol(sym.DIV, new String("DIV"));}
    "MOD" {return symbol(sym.MOD, new String("MOD"));}
    {IDENTIFIER} {
	if(yylength() > 24){
	    System.out.println(yytext());
	    throw new IllegalIdentifierLengthException(yyline, yycolumn);
	} else {
	return symbol(sym.IDENTIFIER, new String(yytext()).toLowerCase());
	}
    }
    {DECNUMBER} {
	if(yylength() > 12){
	    System.out.println(yytext());
	    throw new IllegalIntegerRangeException(yyline, yycolumn);
	} else {
	    return symbol(sym.NUMBER, Integer.parseInt(yytext(), 10));
	}
    }
    {OCTNUMBER} {
	if(yylength() > 12){
	    System.out.println(yytext());
	    throw new IllegalIntegerRangeException(yyline, yycolumn);
	} else {
	    return symbol(sym.NUMBER, Integer.parseInt(yytext(), 8));
	}
    }
    "+" {return symbol(sym.ADD, new String("+"));}
    "-" {return symbol(sym.MINUS, new String("-"));}
    "*" {return symbol(sym.MUL, new String("*"));}
    ">" {return symbol(sym.BIG, new String(">"));}
    ">=" {return symbol(sym.BIGEQ, new String(">="));}
    "<" {return symbol(sym.LESS, new String("<"));}
    "<=" {return symbol(sym.LESSEQ, new String("<="));}
    "#" {return symbol(sym.NOTEQ, new String("#"));}
    "=" {return symbol(sym.EQUAL, new String("="));}
    "&" {return symbol(sym.AND, new String("&"));}
    "~" {return symbol(sym.NOT, new String("~"));}
    ":=" {return symbol(sym.ASSIGN, new String(":="));}
    "." {return symbol(sym.DOT, new String("."));}
    "[" {return symbol(sym.LSQBRACKET, new String("["));}
    "]" {return symbol(sym.RSQBRACKET, new String("]"));}
    "(" {return symbol(sym.LPARENTHESE, new String("("));}
    ")" {return symbol(sym.RPARENTHESE, new String(")"));}
    ":" {return symbol(sym.COLON, new String(":"));}
    ";" {return symbol(sym.SEMI, new String(";"));}
    "," {return symbol(sym.COMMA, new String(","));}
    
    .  {System.out.println(yytext());throw new IllegalSymbolException(yyline, yycolumn);}
}