package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.vida.Salud;

public abstract class Racita {
    protected Salud vida;
    protected Posicion posicion;
    protected static int costoEnMinerales;
    protected static int costoEnGas;

    public static void setCostoEnMinerales(int costo){
        costoEnMinerales = costo;
    }
    public static void setCostoEnGas(int costo){
        costoEnGas = costo;
    }
    public abstract void pasarTurno();

    public void daniar(int puntosAtaque){
        vida.recibirAtaque(puntosAtaque);
    }

    public void localizarEnMapa(int coordenadaX, int coordenadaY){
        posicion = new Posicion(coordenadaX,coordenadaY);
    }
    public int obtenerVida(){return vida.getVidaActual();}

    public static int obtenerCostoEnMinerales(){return costoEnMinerales;}

    public static int obtenerCostoEnGas(){return costoEnGas;}

    public int obtenerCostoMinerales(){return costoEnMinerales;}

    public int obtenerCostoGas(){return costoEnGas;}

    public Posicion obtenerPosicion(){
        return posicion;
    }

}
