package com.example.practica1_compi1.bknd.Obj;

public class Operacion extends Expression {

    private Expression izq, der;
    private String tipo;

    public Operacion(Expression izq, Expression der, String tipo) {
        super(null);
        this.izq = izq;
        this.der = der;
        this.tipo = tipo;
    }

    @Override

    public Object evaluar(){
        double valorIzq = (double) izq.evaluar();
        double valorDer = (double) der.evaluar();

        switch (tipo){
            case "+":
                return valorIzq + valorDer;
            case "-":
                return valorIzq - valorDer;
            case "*":
                return valorIzq * valorDer;
            case "/":
                return valorIzq / valorDer;
            default:
                return 0;
        }
    }

    @Override
    public String toString() {
        return "(" + izq + " " + tipo + " " + der + ")";
    }
}
