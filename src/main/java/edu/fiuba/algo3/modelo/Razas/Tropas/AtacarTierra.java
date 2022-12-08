package edu.fiuba.algo3.modelo.Razas.Tropas;

import edu.fiuba.algo3.modelo.Excepciones.TropaSinAtaqueAereo;
import edu.fiuba.algo3.modelo.Rango.RangoAtaque;
import edu.fiuba.algo3.modelo.Razas.Unidad;

public class AtacarTierra implements Atacar{

    public void atacarTierra(RangoAtaque rango, TropaTerrestre unidadAtacable, int puntosAtaqueTierra){
        rango.localizarTropaEnRango((Unidad) unidadAtacable,puntosAtaqueTierra);
    }

    public void atacarAire(RangoAtaque rango, TropaAerea unidadAtacable, int puntosAtaqueAire){
        throw new TropaSinAtaqueAereo();
    }
}
