package edu.fiuba.algo3.modelo.Rango;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Excepciones.CeldaConRecurso;
import edu.fiuba.algo3.modelo.Excepciones.CeldaOcupada;
import edu.fiuba.algo3.modelo.Excepciones.CoordenadaFueraDeRango;
import edu.fiuba.algo3.modelo.Excepciones.ZonaOcupada;
import edu.fiuba.algo3.modelo.Partida.Mapa;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Razas.Tropas.TropaAerea;
import edu.fiuba.algo3.modelo.Razas.Tropas.TropaTerrestre;


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
                return;
            }
            catch (CoordenadaFueraDeRango | CeldaOcupada | CeldaConRecurso ignore) {}
        }
        throw new ZonaOcupada();
    }
    public void colocarPorAire(TropaAerea tropaAColocar){
        Mapa mapa = Mapa.getInstance();
        for(Posicion unaPosicion : posicionesEnRango) {
            try {
                Celda celda = mapa.obtenerCelda(unaPosicion);
                celda.estaOcupadaPorAire();
                celda.ocuparPorAire(tropaAColocar);
                return;

            } catch (CoordenadaFueraDeRango | CeldaOcupada | CeldaConRecurso ignore) {}
        }
        throw new ZonaOcupada();
    }
}
