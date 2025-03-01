package com.example.practica1_compi1.bknd.Lexer;

import java_cup.runtime.*;
import com.example.practica1_compi1.bknd.Parcer.ParserSym;

%%

//JFlex Config
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
INITLIST        = "1. "
LETTER          = [a-zA-Z]
STRING          = [ .,\u00A0/\\-]?[A-Za-zÁÉÍÓÚÜÑáéíóúü][A-Za-z0-9ÁÉÍÓÚÜÑáéíóúü]+([ .,#\u00A0/\\-]+[A-Za-z0-9ÁÉÍÓÚÜÑáéíóúü]*)*[\n]?
BLACKED         = "**"[^*]+"**"
ITALIC          = "*"[^*]+"*"
BLITALIC        = "***"[^*]+"***"

PLUS            = "+"
MINUS           = "-"
DIVIDE          = "/"
ASTHERISK       = "*"
POTENCIA        = "^"
R_PAREN         = "("
L_PAREN         = ")"
DOT            = "."

NUMERAL = "#"

%{
    StringBuffer sb = new StringBuffer();

    private Symbol symbol(int type) {
        return new Symbol(type, yyline+1, yycolumn+1);
    }

    private Symbol symbol(int type, Object value) {
        return new Symbol(type, yyline+1, yycolumn+1, value);
    }

    private void addError(String message) {
      }
%}

%eofval{
	return new Symbol(ParserSym.EOF);
%eofval}

%%

{INITLIST}      {return symbol(ParserSym.INITLIST, yytext());}
{DOT}           {return symbol(ParserSym.DOT, yytext());}
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
{STRING}        {return symbol(ParserSym.STRING, yytext());}
{ITALIC}        {return symbol(ParserSym.ITALIC, yytext());}
{BLACKED}       {return symbol(ParserSym.BLACKED, yytext());}
{BLITALIC}      {return symbol(ParserSym.BLITALIC, yytext());}
{WHITESPC}      {/*return symbol(ParserSym.WHITESPC, yytext());*/}


.             {System.out.println("No se reconoce el simbolo: " + yytext());}
