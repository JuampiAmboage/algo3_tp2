package edu.fiuba.algo3.modelo.Celdas;
import edu.fiuba.algo3.modelo.Edificios.Edificio;

import java.util.ArrayList;

public class CeldaLibre implements Celda{
    private Edificio edificio;
    private ArrayList<Celda> celdasAdyacentes;
    private Moho moho;

    public CeldaLibre(){
        edificio = null;
    }
    public void setAdyacentes(ArrayList<Celda> adyacentes){
        celdasAdyacentes = adyacentes;
    }
    public void ocupar(Edificio nuevoEdificio){
        edificio = nuevoEdificio;
    }
    public void desocupar(){
        edificio = null;
    }
    public void pasarTurno(){
        edificio.pasarTurno();
    }
    /*public void energizar(){
        energia = new Energizada();
    }*/

    public void infectarConMoho(){
        moho = new Moho();
    }

    public boolean esCelda(){
        return true;
    }
}
