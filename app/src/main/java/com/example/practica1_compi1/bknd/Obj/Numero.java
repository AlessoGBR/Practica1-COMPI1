package com.example.practica1_compi1.bknd.Obj;

public class Numero extends Expression{

    public Numero(double valor){
        super(valor);
    }

    @Override
    public Object evaluar(){
        return super.evaluar();
    }

    @Override
    public String toString() {
        return String.valueOf(getValor());
    }
}
