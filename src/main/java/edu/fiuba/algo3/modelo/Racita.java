package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.vida.Salud;

public abstract class Racita {
    protected Salud vida;
    protected int costoEnMinerales;
    protected int costoEnGas;

    public abstract void pasarTurno();

    public void daniar(int puntosAtaque){
        vida.recibirAtaque(puntosAtaque);
    }

    public int obtenerVida(){return vida.getVidaActual();}

    public int obtenerCostoEnMinerales(){return costoEnMinerales;}

    public int obtenerCostoEnGas(){return costoEnGas;}

}
