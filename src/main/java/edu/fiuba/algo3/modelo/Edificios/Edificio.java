package edu.fiuba.algo3.modelo.Edificios;

import edu.fiuba.algo3.modelo.Almacenamiento.Almacenamiento;

public abstract class Edificio {

    protected int costo_de_construccion;
    protected Almacenamiento amlmacenamiento;
    public abstract void construir();
    public void pasarTurno(){ System.out.println("Pasar turno"); }
}
