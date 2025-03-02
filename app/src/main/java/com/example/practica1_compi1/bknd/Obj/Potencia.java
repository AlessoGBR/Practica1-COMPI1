package com.example.practica1_compi1.bknd.Obj;

public class Potencia extends Expression{

    private Expression base, exponente;

    public Potencia(Expression base, Expression exponente) {
        super(null);
        this.base = base;
        this.exponente = exponente;
    }

    @Override
    public Object evaluar() {
        double baseE = (double) base.evaluar();
        double expoE = (double) exponente.evaluar();
        return Math.pow(baseE, expoE);
    }

    @Override
    public String toString() {
        return base + "^" + exponente;
    }
}
