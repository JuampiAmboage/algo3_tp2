package edu.fiuba.algo3.modelo.Rango;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Excepciones.CoordenadaFueraDeRango;
import edu.fiuba.algo3.modelo.Partida.Mapa;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Visibilidad.VisibilidadCambiante;
import edu.fiuba.algo3.modelo.Razas.Tropas.Zealot;

import java.util.ArrayList;

public class RangoDetector extends Rango {
    ArrayList<VisibilidadCambiante> tropasDetectadasEnPasadaActual;
    ArrayList<VisibilidadCambiante> tropasDetectadasEnAnteriorPasada;

    public RangoDetector(int radio, Posicion posicionObjetoConRango) {
        super(posicionObjetoConRango, radio);
        tropasDetectadasEnPasadaActual = new ArrayList<>();
        tropasDetectadasEnAnteriorPasada = new ArrayList<>();
    }

    public void localizarZealots(){
        Mapa mapa = Mapa.getInstance();
        for(Posicion unaPosicion : posicionesEnRango) {
            try {
                Celda celda = mapa.obtenerCelda(unaPosicion);
                if(celda.estaOcupadaPorTierra() && celda.obtenerOcupanteTerrestre().getClass().equals(Zealot.class) ) {
                    Zealot unidadDetectada = (Zealot) celda.obtenerOcupanteTerrestre();
                    tropasDetectadasEnPasadaActual.add(unidadDetectada);
                }
            } catch (CoordenadaFueraDeRango e) {
                continue;
            }
        }
    }

    public void compararTropasDetectadasEntreTurnos(){
        for(VisibilidadCambiante tropaDetectada: tropasDetectadasEnPasadaActual){
            if(!tropasDetectadasEnAnteriorPasada.contains(tropaDetectada)){
                tropaDetectada.volverVisible();
            }
        }
        for(VisibilidadCambiante tropaDectadaAntigua: tropasDetectadasEnAnteriorPasada){
            if(!tropasDetectadasEnPasadaActual.contains(tropaDectadaAntigua)){
                tropaDectadaAntigua.volverInsvisible();
            }
        }
        tropasDetectadasEnAnteriorPasada = tropasDetectadasEnPasadaActual;
        tropasDetectadasEnPasadaActual = null;
    }
}
