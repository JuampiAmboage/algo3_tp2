package edu.fiuba.algo3.modelo.Razas.Tropas;

import edu.fiuba.algo3.modelo.Celdas.Celda;

public abstract class TropaAerea extends Tropa {
    public void ocuparCelda(Celda celda){
        celda.ocuparPorAire(this);
    }
    public void moverArriba(){
        Celda celda = posicion.obtenerUnaCeldaLimitrofe(-1,0);
        if(!celda.estaOcupadaPorAire()){
            posicion.movimientoSuperior();
        }
    }

    public void moverAbajo(){
        Celda celda = posicion.obtenerUnaCeldaLimitrofe(1,0);
        if(!celda.estaOcupadaPorAire()){
            posicion.movimientoInferior();
        }
    }
    public void moverDerecha(){
        Celda celda = posicion.obtenerUnaCeldaLimitrofe(0,1);
        if(!celda.estaOcupadaPorAire()){
            posicion.movimientoDerecha();
        }
    }

    public void moverIzquierda(){
        Celda celda = posicion.obtenerUnaCeldaLimitrofe(0,-1);
        if(!celda.estaOcupadaPorAire()){
            posicion.movimientoIzquierda();
        }
    }
}
