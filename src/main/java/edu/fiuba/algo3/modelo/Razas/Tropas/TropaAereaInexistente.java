package edu.fiuba.algo3.modelo.Razas.Tropas;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Excepciones.NoExisteEstaUnidad;
import edu.fiuba.algo3.modelo.Excepciones.UnidadInexistente;

public class TropaAereaInexistente extends TropaAerea{
    public TropaAereaInexistente(){}

    @Override
    public boolean existe(){
        return false;
    }

    public void lanzarExcepcion(){
        throw new NoExisteEstaUnidad();
    }

    public void ocuparCelda(Celda celdaAOcupar){
        this.lanzarExcepcion();
    }

    public void realizarAccionesTurno(){
        this.lanzarExcepcion();
    }
    public void moverArriba(){
        this.lanzarExcepcion();
    }

    public void moverAbajo(){
        this.lanzarExcepcion();
    }

    public void moverDerecha(){
        this.lanzarExcepcion();
    }

    public void moverIzquierda(){
        this.lanzarExcepcion();
    }

    public String obtenerSprite(){
        throw new UnidadInexistente();
    }
}
