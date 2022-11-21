package edu.fiuba.algo3.modelo.Unidades;

import edu.fiuba.algo3.modelo.Racita;
import edu.fiuba.algo3.modelo.Rango.RangoAtaque;

public class AtacarTierra implements Atacar{

    public void atacarTierra(RangoAtaque rango, Racita unidadAtacable, int puntosAtaqueTierra, int X, int Y){
        rango.localizarTropaEnRango(unidadAtacable,puntosAtaqueTierra,X,Y);
    }

    public void atacarAire(RangoAtaque rango, Racita unidadAtacable, int puntosAtaqueAire, int X, int Y){
        throw new IllegalArgumentException("No podes atacar a una unidad aerea");
    }
}
