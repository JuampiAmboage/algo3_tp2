package edu.fiuba.algo3.modelo.Rango;

import edu.fiuba.algo3.modelo.Celdas.*;
import edu.fiuba.algo3.modelo.Edificios.EdificioProtoss;
import edu.fiuba.algo3.modelo.Excepciones.CoordenadaFueraDeRango;
import edu.fiuba.algo3.modelo.Partida.Mapa;
import edu.fiuba.algo3.modelo.Posicion.Posicion;

public class RangoExpansible extends Rango {
    int radio;

    public RangoExpansible(Posicion posicionOrigen, int radio) {
        super(posicionOrigen, radio);
    }

    public void expandirMoho() {
        Mapa mapa = Mapa.getInstance();
        for(Posicion unaPosicion : posicionesEnRango) {
            try {
                Celda celda = mapa.obtenerCelda(unaPosicion);
                celda.cambiarTipo(new CeldaConMoho(celda));
            }
            catch (CoordenadaFueraDeRango e){continue;}
        }
    }

    public void energizar() {
        Mapa mapa = Mapa.getInstance();
        for(Posicion unaPosicion : posicionesEnRango) {
            try {
                Celda celda = mapa.obtenerCelda(unaPosicion);
                celda.cambiarTipo(new CeldaEnergizada(celda));
                if(celda.estaOcupadaPorTierra() && celda.obtenerOcupanteTerrestre().getClass().equals(EdificioProtoss.class)){
                    EdificioProtoss edificioProtoss = (EdificioProtoss) celda.obtenerOcupanteTerrestre();
                    edificioProtoss.energizar();
                }
            }
            catch (CoordenadaFueraDeRango e){continue;}
        }
    }

    public void desenergizar() {
        Mapa mapa = Mapa.getInstance();
        for(Posicion unaPosicion : posicionesEnRango) {
            try {
                Celda celda = mapa.obtenerCelda(unaPosicion);
                celda.cambiarTipo(new CeldaLibre(celda));
                if(celda.estaOcupadaPorTierra() && celda.obtenerOcupanteTerrestre().getClass().equals(EdificioProtoss.class)){
                    EdificioProtoss edificioProtoss = (EdificioProtoss) celda.obtenerOcupanteTerrestre();
                    edificioProtoss.desenergizar();
                }
            }
            catch (CoordenadaFueraDeRango e){continue;}
        }
    }
}