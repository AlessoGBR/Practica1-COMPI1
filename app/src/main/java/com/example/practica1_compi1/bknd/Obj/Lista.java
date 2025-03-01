package com.example.practica1_compi1.bknd.Obj;

import java.util.ArrayList;

public class Lista extends  Texto{

    private ArrayList<Texto> text;
    public Lista(int estilo){
        super(estilo);
        this.text = new ArrayList<>();
    }

    public void addTexto(Texto texto){
        this.text.add(texto);
    }

    public ArrayList<Texto> getTexts(){
        return text;
    }
}
