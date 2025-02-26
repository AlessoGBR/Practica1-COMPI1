package com.example.practica1_compi1.bknd.Lexer;

import org.xml.sax.Parser;import java.util.ArrayList;
import java_cup.runtime.*;

%%
%class Lexer
%unicode
%line
%column
%caseless
%cup
%public

WHITESPC        = ([\s\t\r\n]+)
NUMBER          = ([0-9][0-9]*)
DECIMAL         = ([0-9][0-9]*"."[0-9][0-9]*)
LETTER          = [a-zA-Z]
STRING          = [a-zA-Z]+
BLACKED         = "**"[^\t\r\n]+"**"


//Operaciones matematicas
PLUS            = "+"
MINUS           = "-"
DIVIDE          = "/"
ASTHERISK       = "*"
POTENCIA        = "^"
R_PAREN         = "("
L_PAREN         = ")"

//Markdown
NUMERAL = "#"

%{
    StringBuffer sb = new StringBuffer();
    ArrayList<ErrorP> errors = new ArrayList<ErrorP>();

    private Symbol symbol(int type) {
        return new Symbol(type, yyline+1, yycolumn+1);
    }

    private Symbol symbol(int type, Object value) {
        return new Symbol(type, yyline+1, yycolumn+1, value);
    }

    private void addError(String message) {
        errors.add(new ErrorP(yyline+1, yycolumn+1, "No se reconoce el simbolo: ", 0, message ));
      }
%}

%eofval{
	return new Symbol(ParserSym.EOF);
%eofval}

%%

{WHITESPC}      {return symbol(ParserSym.WHITESPC, yytext());}
{NUMBER}        {return symbol(ParserSym.NUMBER, yytext());}
{DECIMAL}       {return symbol(ParserSym.DECIMAL, yytext());}
{LETTER}        {return symbol(ParserSym.LETTER, yytext());}
{PLUS}          {return symbol(ParserSym.PLUS, yytext());}
{MINUS}         {return symbol(ParserSym.MINUS, yytext());}
{DIVIDE}        {return symbol(ParserSym.DIVIDE, yytext());}
{ASTHERISK}     {return symbol(ParserSym.ASTHERISK, yytext());}
{POTENCIA}      {return symbol(ParserSym.POTENCIA, yytext());}
{R_PAREN}       {return symbol(ParserSym.R_PAREN, yytext());}
{L_PAREN}       {return symbol(ParserSym.L_PAREN, yytext());}
{NUMERAL}       {return symbol(ParserSym.NUMERAL, yytext());}
