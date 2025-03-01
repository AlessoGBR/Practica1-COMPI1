package com.example.practica1_compi1.bknd.Obj;

public class Header extends Texto {

    private int level;

    public Header() {
        super(TextStyle.HEADER.ordinal());
        this.level = 1;
    }

    public Header(int level) {
        this.level = level;
    }

    public void incrementLevel(){
        if(this.level<6){
            this.level++;
        }
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @Override
    public String getContent() {
        return super.getContent();
    }

    @Override
    public void setContent(String content) {
        super.setContent(content);
    }
}
