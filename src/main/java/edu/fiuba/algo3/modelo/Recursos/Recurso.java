package edu.fiuba.algo3.modelo.Recursos;

import edu.fiuba.algo3.modelo.Edificios.Construible;

public abstract class Recurso {
    protected int cantidad;
    public Recurso() {}
    public abstract int extraer(int cantidad);
    public abstract void quiereConstruir(Construible construible);
}
