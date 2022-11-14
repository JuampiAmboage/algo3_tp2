package edu.fiuba.algo3.modelo.Recursos;

public abstract class Recurso {
    protected int cantidad;
    public Recurso() {}
    public abstract int extraer(int cantidad);

    public abstract boolean esIgualA(Object objeto);
}
