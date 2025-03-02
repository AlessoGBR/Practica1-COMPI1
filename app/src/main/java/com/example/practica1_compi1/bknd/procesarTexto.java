package com.example.practica1_compi1.bknd;

import com.example.practica1_compi1.bknd.Lexer.Texto.Lexer;
import com.example.practica1_compi1.bknd.Obj.Texto;
import com.example.practica1_compi1.bknd.Parcer.Texto.Parser;

import java.io.BufferedReader;

public class procesarTexto {

    public procesarTexto() {

    }

    public Texto verTextoKt(String texto) {
        Lexer lexer = new Lexer(new BufferedReader(new java.io.StringReader(texto)));
        Parser parser = new Parser(lexer);
        Texto t = null;
        try {
             t = (Texto) parser.parse().value;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return t;
    }


}
