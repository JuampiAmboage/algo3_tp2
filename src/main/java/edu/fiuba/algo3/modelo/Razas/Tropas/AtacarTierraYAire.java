package edu.fiuba.algo3.modelo.Razas.Tropas;

import edu.fiuba.algo3.modelo.Razas.Unidad;
import edu.fiuba.algo3.modelo.Rango.RangoAtaque;

public class AtacarTierraYAire implements Atacar{
    @Override
    public void atacarTierra(RangoAtaque rango, TropaTerrestre unidadAtacable, int puntosAtaqueTierra){
        rango.localizarTropaEnRango((Unidad) unidadAtacable,puntosAtaqueTierra);
    }
    public void atacarAire(RangoAtaque rango, TropaAerea unidadAtacable, int puntosAtaqueAire){
        rango.localizarTropaEnRango((Unidad) unidadAtacable,puntosAtaqueAire);
    }
}
