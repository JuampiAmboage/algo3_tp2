package edu.fiuba.algo3.modelo.Razas.Tropas;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Opciones.MoverTerrestreHaciaAbajo;
import edu.fiuba.algo3.modelo.Opciones.MoverTerrestreHaciaArriba;
import edu.fiuba.algo3.modelo.Opciones.MoverTerrestreHaciaDerecha;
import edu.fiuba.algo3.modelo.Opciones.MoverTerrestreHaciaIzquierda;
import edu.fiuba.algo3.modelo.Partida.Mapa;
import edu.fiuba.algo3.modelo.Posicion.Posicion;

public abstract class TropaTerrestre extends Tropa{

    public TropaTerrestre(){
        super();
    }
    public abstract void realizarAccionesTurno();

    public void ocuparCelda(Celda celda){
        Celda celdaActual = Mapa.getInstance().obtenerCelda(this.posicion);
        celda.estaOcupadaPorTierra();
        celda.celdaConRecurso();
        celda.ocuparPorTierra(this);
        celdaActual.desocuparPorTierra();
        this.cantidadMovimientos++;
    }
}
