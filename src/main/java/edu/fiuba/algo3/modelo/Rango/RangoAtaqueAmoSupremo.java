package edu.fiuba.algo3.modelo.Rango;

import edu.fiuba.algo3.modelo.Excepciones.EnemigoFueraDeRango;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Razas.Tropas.Tropa;
import edu.fiuba.algo3.modelo.Razas.Unidad;

public class RangoAtaqueAmoSupremo extends RangoAtaque{
    public RangoAtaqueAmoSupremo(Tropa tropa, int radio, Posicion posicionObjetoConRango) {
        super(tropa,radio,posicionObjetoConRango);
    }

    @Override
    public void localizarTropaEnRango(Unidad victima, int puntosAtaque){
        if(posicion.solicitarDistanciaA(victima) <= radio) {
            victima.daniarIgnorandoVisibilidad(puntosAtaque);
        }
        else
            throw new EnemigoFueraDeRango();
    }
}
