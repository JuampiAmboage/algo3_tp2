package edu.fiuba.algo3.modelo.Razas.Tropas;

import edu.fiuba.algo3.modelo.Rango.RangoAtaque;
import edu.fiuba.algo3.modelo.Razas.Unidad;

public class AtacarTierra implements Atacar{

    public void atacarTierra(RangoAtaque rango, Unidad unidadAtacable, int puntosAtaqueTierra){
        rango.localizarTropaEnRango(unidadAtacable,puntosAtaqueTierra);
    }

    public void atacarAire(RangoAtaque rango, Unidad unidadAtacable, int puntosAtaqueAire){
        throw new IllegalArgumentException("No podes atacar a una unidad aerea");
    }
}
