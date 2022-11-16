package edu.fiuba.algo3.modelo.Unidades;

import edu.fiuba.algo3.modelo.Racita;

public class AtacarTierra implements Atacar{

    public void atacarTierra(Racita unidadAtacable, int puntosAtaqueTierra){
        unidadAtacable.daniar(puntosAtaqueTierra);
    }

    public void atacarAire(Racita unidadAtacable, int puntosAtaqueAire){
        throw new IllegalArgumentException("No podes atacar a una unidad aerea");
    }
}
