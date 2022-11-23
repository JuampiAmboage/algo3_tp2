package edu.fiuba.algo3.modelo.Rango;

import edu.fiuba.algo3.modelo.Celdas.TipoCelda;
import edu.fiuba.algo3.modelo.Partida.Mapa;
import edu.fiuba.algo3.modelo.Posicion.Posicion;

public class RangoExpansible extends Rango {
    int radio;

    public RangoExpansible(Posicion posicionOrigen, int radio) {
        super(posicionOrigen, radio);
    }

    public void expandir(TipoCelda unTipoDeCelda) {
        Mapa mapa = Mapa.getInstance();
        for(Posicion unaPosicion : posicionesEnRango) {
            mapa.obtenerCelda(unaPosicion).cambiarTipo(unTipoDeCelda);
        }
    }
}