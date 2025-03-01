package com.example.practica1_compi1.bknd.Obj;

import java.util.ArrayList;

public class Paragraph extends Texto {

    private ArrayList<Texto> texts;

    public Paragraph() {
        super(TextStyle.PARAGRAPH.ordinal());
        this.texts = new ArrayList<>();
    }

    public Paragraph(String contenido){
        super(TextStyle.PARAGRAPH.ordinal(),contenido);
    }
    public void addTexto(Texto text){
        this.texts.add(text);
    }

    public ArrayList<Texto> getTexts() {
        return texts;
    }

    public void setTexts(ArrayList<Texto> texts) {
        this.texts = texts;
    }
}
