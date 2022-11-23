package edu.fiuba.algo3.modelo.Razas.Tropas;

import edu.fiuba.algo3.modelo.Razas.Raza;
import edu.fiuba.algo3.modelo.Rango.RangoAtaque;

public class AtacarTierra implements Atacar{

    public void atacarTierra(RangoAtaque rango, Raza unidadAtacable, int puntosAtaqueTierra){
        rango.localizarTropaEnRango(unidadAtacable,puntosAtaqueTierra);
    }

    public void atacarAire(RangoAtaque rango, Raza unidadAtacable, int puntosAtaqueAire){
        throw new IllegalArgumentException("No podes atacar a una unidad aerea");
    }
}
