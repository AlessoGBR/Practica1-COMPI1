package com.example.practica1_compi1.bknd.Obj;

public class Plot extends Action {

    private Expression funcion, inicio, fin;

    public Plot(Expression funcion, Expression inicio, Expression fin) {
        this.funcion = funcion;
        this.inicio = inicio;
        this.fin = fin;
    }

}
