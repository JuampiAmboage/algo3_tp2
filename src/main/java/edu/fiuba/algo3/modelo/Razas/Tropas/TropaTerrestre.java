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
        if(!celda.estaOcupadaPorTierra() && cantidadMovimientos <4){
            posicion.movimientoSuperior();
            cantidadMovimientos++;

        }
    }

    public void moverAbajo(){
        Celda celda = posicion.obtenerUnaCeldaLimitrofe(0,1);
        if(!celda.estaOcupadaPorTierra() && cantidadMovimientos < 4){
            posicion.movimientoInferior();
            cantidadMovimientos++;

        }
    }
    public void moverDerecha(){
        Celda celda = posicion.obtenerUnaCeldaLimitrofe(1,0);
        if(!celda.estaOcupadaPorTierra() &&  cantidadMovimientos < 4){
            posicion.movimientoDerecha();
            cantidadMovimientos++;

        }
    }

    public void moverIzquierda(){
        Celda celda = posicion.obtenerUnaCeldaLimitrofe(-1,0);
        if(!celda.estaOcupadaPorTierra() &&  cantidadMovimientos < 4){
            posicion.movimientoIzquierda();
            cantidadMovimientos++;
        }
    }


}
