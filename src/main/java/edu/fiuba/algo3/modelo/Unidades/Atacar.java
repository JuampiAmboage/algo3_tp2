package edu.fiuba.algo3.modelo.Unidades;

import edu.fiuba.algo3.modelo.Racita;

public interface Atacar {
    public void atacarTierra(Racita unidadAtacable, int puntosAtaqueTierra);
    public void atacarAire(Racita unidadAtacable, int puntosAtaqueAire);
}
