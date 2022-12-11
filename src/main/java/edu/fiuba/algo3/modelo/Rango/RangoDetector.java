package edu.fiuba.algo3.modelo.Rango;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Celdas.CeldaLibre;
import edu.fiuba.algo3.modelo.Excepciones.CoordenadaFueraDeRango;
import edu.fiuba.algo3.modelo.Excepciones.EnemigoFueraDeRango;
import edu.fiuba.algo3.modelo.Partida.Mapa;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Razas.Tropas.Tropa;
import edu.fiuba.algo3.modelo.Razas.Tropas.VisibilidadCambiante;
import edu.fiuba.algo3.modelo.Razas.Tropas.Zealot;
import edu.fiuba.algo3.modelo.Razas.Unidad;

import java.util.ArrayList;

public class RangoDetector extends Rango {
    ArrayList<VisibilidadCambiante> tropasDetectadasEnPasadaActual;
    ArrayList<VisibilidadCambiante> tropasDetectadasEnAnteriorPasada;

    public RangoDetector(int radio, Posicion posicionObjetoConRango) {
        super(posicionObjetoConRango, radio);
        tropasDetectadasEnPasadaActual = new ArrayList<>();
        tropasDetectadasEnAnteriorPasada = new ArrayList<>();
    }

    public void localizarTropasInvisibles(){
        Mapa mapa = Mapa.getInstance();
        for(Posicion unaPosicion : posicionesEnRango) {
            try {
                Celda celda = mapa.obtenerCelda(unaPosicion);
                if(celda.estaOcupadaPorTierra() && celda.obtenerOcupante().getClass().equals(VisibilidadCambiante.class) ) {
                    VisibilidadCambiante unidadDetectada = (VisibilidadCambiante) celda.obtenerOcupante();
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
