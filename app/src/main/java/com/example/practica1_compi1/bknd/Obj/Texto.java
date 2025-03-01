package com.example.practica1_compi1.bknd.Obj;

public class Texto {

    private int style;
    private String content;

    public Texto(int style, String content) {
        this.style = style;
        this.content = content;
    }

    public Texto() {
    }

    public Texto(int style) {
        this.style = style;
    }

    public int getStyle() {
        return style;
    }

    public void setStyle(int style) {
        this.style = style;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
