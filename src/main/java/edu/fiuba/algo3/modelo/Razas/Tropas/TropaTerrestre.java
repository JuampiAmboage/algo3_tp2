package edu.fiuba.algo3.modelo.Razas.Tropas;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Partida.Mapa;
import edu.fiuba.algo3.modelo.Posicion.Posicion;

public abstract class TropaTerrestre extends Tropa{

    public void ocuparCelda(Celda celda){
        celda.ocuparPorTierra(this);
    }
    public void moverArriba(){
        Celda celda = posicion.obtenerUnaCeldaLimitrofe(0,-1);
        if(!celda.estaOcupadaPorTierra()){
            posicion.movimientoSuperior();
        }
    }

    public void moverAbajo(){
        Celda celda = posicion.obtenerUnaCeldaLimitrofe(0,1);
        if(!celda.estaOcupadaPorTierra()){
            posicion.movimientoInferior();
        }
    }
    public void moverDerecha(){
        Celda celda = posicion.obtenerUnaCeldaLimitrofe(1,0);
        if(!celda.estaOcupadaPorTierra()){
            posicion.movimientoDerecha();
        }
    }

    public void moverIzquierda(){
        Celda celda = posicion.obtenerUnaCeldaLimitrofe(-1,0);
        if(!celda.estaOcupadaPorTierra()){
            posicion.movimientoIzquierda();
        }
    }


}
