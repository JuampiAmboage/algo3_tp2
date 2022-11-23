package edu.fiuba.algo3.modelo.Razas.Tropas;

import edu.fiuba.algo3.modelo.Razas.Raza;
import edu.fiuba.algo3.modelo.Rango.RangoAtaque;

public class AtacarAire implements Atacar{

    public void atacarTierra(RangoAtaque rango, Raza unidadAtacable, int puntosAtaqueTierra){
        throw new IllegalArgumentException("No podes atacar a una unidad en tierra");
    }
    public void atacarAire(RangoAtaque rango, Raza unidadAtacable, int puntosAtaqueAire) {
        rango.localizarTropaEnRango(unidadAtacable,puntosAtaqueAire);
    }
}
