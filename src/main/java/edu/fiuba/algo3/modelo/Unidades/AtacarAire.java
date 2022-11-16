package edu.fiuba.algo3.modelo.Unidades;

import edu.fiuba.algo3.modelo.Racita;

public class AtacarAire implements Atacar{

    public void atacarTierra(Racita unidadAtacable, int puntosAtaqueTierra){
        throw new IllegalArgumentException("No podes atacar a una unidad en tierra");
    }
    public void atacarAire(Racita unidadAtacable, int puntosAtaqueAire) {
        unidadAtacable.daniar(puntosAtaqueAire);
    }
}
