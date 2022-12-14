package edu.fiuba.algo3.modelo.Ataque;

import edu.fiuba.algo3.modelo.Razas.Tropas.TropaAerea;
import edu.fiuba.algo3.modelo.Razas.Unidad;
import edu.fiuba.algo3.modelo.Rango.RangoAtaque;

public class AtacarTierraYAire implements Atacar {
    @Override
    public void atacarTierra(RangoAtaque rango, Unidad unidadAtacable, int puntosAtaqueTierra){
        rango.localizarTropaEnRango(unidadAtacable,puntosAtaqueTierra);
    }
    public void atacarAire(RangoAtaque rango, TropaAerea unidadAtacable, int puntosAtaqueAire){
        rango.localizarTropaEnRango((Unidad) unidadAtacable,puntosAtaqueAire);
    }
}
