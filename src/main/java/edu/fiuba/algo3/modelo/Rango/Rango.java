package edu.fiuba.algo3.modelo.Rango;

import edu.fiuba.algo3.modelo.Posicion.Posicion;

import java.util.ArrayList;

public class Rango {
    protected int radio;
    protected final ArrayList<Posicion> posicionesEnRango;
    protected final Posicion posicionOrigen;

    public Rango(Posicion posicionOrigen, int radio) {
        this.posicionOrigen = posicionOrigen;
        this.radio = radio;
        this.posicionesEnRango = this.crearPosiciones();
    }


    protected ArrayList<Posicion> crearPosiciones() {
        return this.posicionOrigen.obtenerPosicionesEnRadio(this.radio);
    }

}
