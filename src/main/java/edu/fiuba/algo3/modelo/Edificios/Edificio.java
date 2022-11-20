package edu.fiuba.algo3.modelo.Edificios;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Raza;

public abstract class Edificio extends Raza {
    protected int tiempoDeConstruccion;
    public Edificio() {}
    public abstract void construirEn(Celda celda);
    public abstract void pasarTurno();
    public int obtenerTiempoConstruccion(){ return tiempoDeConstruccion;}
}
