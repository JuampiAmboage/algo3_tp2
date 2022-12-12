package edu.fiuba.algo3.modelo.Razas.Tropas;

import edu.fiuba.algo3.modelo.Celdas.Celda;

public abstract class TropaAerea extends Tropa {
    public void ocuparCelda(Celda celda){
        celda.ocuparPorAire(this);
    }
    public void moverArriba(){
        Celda celda = posicion.obtenerUnaCeldaLimitrofe(0,-1);
        if(!celda.estaOcupadaPorAire() && cantidadMovimientos < 4){
            posicion.movimientoSuperior();
            cantidadMovimientos++;
        }
    }

    public void moverAbajo(){
        Celda celda = posicion.obtenerUnaCeldaLimitrofe(0,1);
        if(!celda.estaOcupadaPorAire() && cantidadMovimientos < 4){
            posicion.movimientoInferior();
            cantidadMovimientos++;

        }
    }
    public void moverDerecha(){
        Celda celda = posicion.obtenerUnaCeldaLimitrofe(1,0);
        if(!celda.estaOcupadaPorAire() &&  cantidadMovimientos < 4){
            posicion.movimientoDerecha();
            cantidadMovimientos++;
        }
    }

    public void moverIzquierda(){
        Celda celda = posicion.obtenerUnaCeldaLimitrofe(-1,0);
        if(!celda.estaOcupadaPorAire() && cantidadMovimientos < 4){
            posicion.movimientoIzquierda();
            cantidadMovimientos++;
        }
    }
}
