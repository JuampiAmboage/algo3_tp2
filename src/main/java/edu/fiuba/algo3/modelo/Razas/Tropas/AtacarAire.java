package edu.fiuba.algo3.modelo.Razas.Tropas;

import edu.fiuba.algo3.modelo.Rango.RangoAtaque;
import edu.fiuba.algo3.modelo.Razas.Unidad;

public class AtacarAire implements Atacar{

    public void atacarTierra(RangoAtaque rango, TropaTerrestre unidadAtacable, int puntosAtaqueTierra){
        throw new IllegalArgumentException("No podes atacar a una unidad en tierra");
    }
    public void atacarAire(RangoAtaque rango, TropaAerea unidadAtacable, int puntosAtaqueAire) {
        rango.localizarTropaEnRango((Unidad)unidadAtacable,puntosAtaqueAire);
    }
}
