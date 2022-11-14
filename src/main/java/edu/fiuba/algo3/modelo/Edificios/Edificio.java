package edu.fiuba.algo3.modelo.Edificios;

import edu.fiuba.algo3.modelo.Almacenamiento.Almacenamiento;
import edu.fiuba.algo3.modelo.Celdas.Celda;

public abstract class Edificio {

    protected int costo_de_construccion;
    protected Almacenamiento amlmacenamiento;

    public abstract void construir_en(Celda celda);
    public abstract void pasarTurno();
}
