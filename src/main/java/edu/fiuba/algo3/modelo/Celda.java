package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Celda {
    static public boolean esCelda(Object obj) {
        return obj instanceof Celda;
    }
    private ArrayList<Celda> adyacentes;
    public Celda() {
    }

    public void setAdyacentes(ArrayList<Celda> adyacentes) {
        this.adyacentes = adyacentes;
    }

    public int cantidadAdyacentes() {
        return adyacentes.size();
    }


}
