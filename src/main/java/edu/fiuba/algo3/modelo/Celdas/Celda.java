package edu.fiuba.algo3.modelo.Celdas;

import edu.fiuba.algo3.modelo.Edificios.Edificio;

import java.util.ArrayList;

public class Celda {
    protected ArrayList<Celda> celdasAdyacentes;
    protected Edificio edificioEnCelda;

    public Celda(){
        edificioEnCelda = null;
    }
    static public boolean esCelda(Object objeto) {
        return objeto instanceof Celda;
    }
    public void ocupar(Edificio nuevoEdificio){
        edificioEnCelda = nuevoEdificio;
    }
    public void desocupar(){
        edificioEnCelda = null;
    }
    public void pasarTurno(){
        edificioEnCelda.pasarTurno();
    }
    public int cantidadAdyacentes() {
        return celdasAdyacentes.size();
    }
    public void setAdyacentes(ArrayList<Celda> adyacentes){
        celdasAdyacentes = adyacentes;
    }
}
