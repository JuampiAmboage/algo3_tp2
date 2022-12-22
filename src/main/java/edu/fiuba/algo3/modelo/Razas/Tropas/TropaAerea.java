package edu.fiuba.algo3.modelo.Razas.Tropas;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Opciones.*;
import edu.fiuba.algo3.modelo.Partida.Mapa;

public abstract class TropaAerea extends Tropa {

    public TropaAerea(){
        super();
    }

    public abstract void realizarAccionesTurno();

    public void ocuparCelda(Celda celda){
        Celda celdaActual = Mapa.getInstance().obtenerCelda(this.posicion);
        celda.estaOcupadaPorAire();
        celda.ocuparPorAire(this);
        celdaActual.desocuparPorAire();
        this.cantidadMovimientos++;
    }
    @Override
    public void desaparecerUnidadDeCelda(){
        Mapa.getInstance().obtenerCelda(posicion).desocuparPorAire();
    }
}
