package edu.fiuba.algo3.modelo.Unidades;

import edu.fiuba.algo3.modelo.Racita;

public class AtacarTierraYAire implements Atacar{
    @Override
    public void atacarTierra(Racita unidadAtacable, int puntosAtaqueTierra){
        unidadAtacable.daniar(puntosAtaqueTierra);
    }
    public void atacarAire(Racita unidadAtacable, int puntosAtaqueAire){
        unidadAtacable.daniar(puntosAtaqueAire);
    }
}
