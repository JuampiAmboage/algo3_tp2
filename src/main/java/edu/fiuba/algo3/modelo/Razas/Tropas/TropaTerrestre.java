package edu.fiuba.algo3.modelo.Razas.Tropas;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Partida.Mapa;
import edu.fiuba.algo3.modelo.Posicion.Posicion;

public abstract class TropaTerrestre extends Tropa{

    public void ocuparCelda(Celda celda){
        Celda celdaActual = Mapa.getInstance().obtenerCelda(this.posicion);
        celda.ocuparPorTierra(this);
        celdaActual.desocuparPorTierra();
    }
}
