package com.example.practica1_compi1.bknd.Obj;

import java.util.HashMap;
import java.util.Map;

public class Variable extends Expression {

    private String nombre;
    private static Map<String, Double> valores = new HashMap<>();

    public Variable (String nombre){
        super(null);
        this.nombre = nombre;
    }

    public Variable(Variable v) {
        super(null);
    }

    public static void asignarValor(String nombre, double valor){
        valores.put(nombre,valor);
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public Object evaluar(){
        return valores.getOrDefault(nombre, 0.0);
    }

    @Override
    public String toString() {
        return "";
    }
}
