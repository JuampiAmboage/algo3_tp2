package edu.fiuba.algo3.modelo.Razas.Tropas;

import edu.fiuba.algo3.modelo.Rango.RangoAtaque;
import edu.fiuba.algo3.modelo.Razas.Unidad;

public class AtacarAire implements Atacar{

    public void atacarTierra(RangoAtaque rango, Unidad unidadAtacable, int puntosAtaqueTierra){
        throw new IllegalArgumentException("No podes atacar a una unidad en tierra");
    }
    public void atacarAire(RangoAtaque rango, Unidad unidadAtacable, int puntosAtaqueAire) {
        rango.localizarTropaEnRango(unidadAtacable,puntosAtaqueAire);
    }
}
