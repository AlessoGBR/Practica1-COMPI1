package com.example.practica1_compi1.bknd;

import com.example.practica1_compi1.bknd.Lexer.Codigo.Lexer;
import com.example.practica1_compi1.bknd.Obj.Expression;
import com.example.practica1_compi1.bknd.Parcer.Codigo.Parser;

import java.io.BufferedReader;

public class procesarCodigo {

    public procesarCodigo(){

    }

    public Expression verTextoKt(String texto) {
        Lexer lexer = new Lexer(new BufferedReader(new java.io.StringReader(texto)));
        Parser parser = new Parser(lexer);
        Expression t = null;
        try {
            t = (Expression) parser.parse().value;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return t;
    }
}
