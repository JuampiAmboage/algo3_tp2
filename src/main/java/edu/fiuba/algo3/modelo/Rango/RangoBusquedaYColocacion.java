package edu.fiuba.algo3.modelo.Rango;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Excepciones.CeldaConRecurso;
import edu.fiuba.algo3.modelo.Excepciones.CeldaOcupada;
import edu.fiuba.algo3.modelo.Excepciones.CoordenadaFueraDeRango;
import edu.fiuba.algo3.modelo.Partida.Mapa;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Razas.Tropas.Tropa;
import edu.fiuba.algo3.modelo.Razas.Tropas.TropaAerea;
import edu.fiuba.algo3.modelo.Razas.Tropas.TropaTerrestre;
import edu.fiuba.algo3.modelo.Razas.Tropas.Zealot;
import edu.fiuba.algo3.modelo.Razas.Unidad;

public class RangoBusquedaYColocacion extends Rango{
    public RangoBusquedaYColocacion(Posicion posicionObjetoConRango, int radioBusqueda) {
        super(posicionObjetoConRango,radioBusqueda);
    }
    public void colocarPorTierra(TropaTerrestre tropaAColocar){
        Mapa mapa = Mapa.getInstance();
        for(Posicion unaPosicion : posicionesEnRango) {
            try {
                Celda celda = mapa.obtenerCelda(unaPosicion);
                celda.estaOcupadaPorTierra();
                celda.ocuparPorTierra(tropaAColocar);
                celda.instanciarUnidad(tropaAColocar);
                return;
            }
            catch (CoordenadaFueraDeRango | CeldaOcupada | CeldaConRecurso ignore) {}
        }
    }
    public void colocarPorAire(TropaAerea tropaAColocar){
        Mapa mapa = Mapa.getInstance();
        for(Posicion unaPosicion : posicionesEnRango) {
            try {
                Celda celda = mapa.obtenerCelda(unaPosicion);
                celda.estaOcupadaPorAire();
                celda.ocuparPorAire((TropaAerea) tropaAColocar);
                celda.instanciarUnidad(tropaAColocar);
                return;

            } catch (CoordenadaFueraDeRango | CeldaOcupada | CeldaConRecurso ignore) {}
        }
    }
}
