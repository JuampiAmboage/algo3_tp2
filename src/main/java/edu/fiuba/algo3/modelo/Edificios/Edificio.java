package edu.fiuba.algo3.modelo.Edificios;

import edu.fiuba.algo3.modelo.Almacenamiento.Almacenamiento;
import edu.fiuba.algo3.modelo.Celdas.Celda;

public abstract class Edificio {

    protected int costo_de_construccion;
    protected Almacenamiento amlmacenamiento;

    public abstract String construir_en(Celda celda);
    public void pasarTurno(){ System.out.println("Pasar turno"); }
}
