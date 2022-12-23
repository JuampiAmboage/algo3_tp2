package edu.fiuba.algo3.modelo.Rango;

import edu.fiuba.algo3.modelo.Excepciones.EnemigoFueraDeRango;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Razas.Tropas.Tropa;
import edu.fiuba.algo3.modelo.Razas.Unidad;

import java.util.ArrayList;

public class RangoAtaque {
    Tropa tropa;
    Posicion posicion;
    int radio;
    public RangoAtaque(Tropa tropa, int radio, Posicion posicionObjetoConRango) {
        this.tropa = tropa;
        this.radio = radio;
        posicion = posicionObjetoConRango;
    }
    public void localizarTropaEnRango(Unidad victima, int puntosAtaque){
        if(posicion.solicitarDistanciaAUnidad(victima) <= radio) {
            victima.daniar(puntosAtaque);
        }
        else
            throw new EnemigoFueraDeRango();
    }

}
