package com.example.practica1_compi1.bknd.Obj;

public class Asignacion extends Expression {

    private Variable variable;
    private Expression valor;

    public Asignacion(Variable variable, Expression valor) {
        super(null);
        this.variable = variable;
        this.valor = valor;
    }

    @Override
    public Object evaluar() {
        return valor.evaluar();
    }

    @Override
    public String toString() {
        return variable + "=" + valor;
    }


}
