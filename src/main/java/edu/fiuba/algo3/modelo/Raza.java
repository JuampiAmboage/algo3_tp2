package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.vida.Salud;

public abstract class Raza {
    protected Salud vida;
    protected Posicion posicion;
    protected int costoEnMinerales;
    protected int costoEnGas;
    protected int tiempoConstruccion;
    public abstract void pasarTurno();

    public void daniar(int puntosAtaque){
        vida.recibirAtaque(puntosAtaque);
    }

    public void localizarEnMapa(int coordenadaX, int coordenadaY){
        posicion = new Posicion(coordenadaX,coordenadaY);
    }
    public int obtenerVida(){return vida.getVidaActual();}

    public int obtenerCostoMinerales(){return costoEnMinerales;}

    public int obtenerCostoGas(){return costoEnGas;}

    public int obtenerTiempoConstruccion(){return tiempoConstruccion;}
    public Posicion obtenerPosicion(){
        return posicion;
    }

}
