package edu.fiuba.algo3.modelo.Unidades;

import edu.fiuba.algo3.modelo.Racita;
import edu.fiuba.algo3.modelo.Rango.RangoAtaque;

public interface Atacar {
    public void atacarTierra(RangoAtaque rango, Racita unidadAtacable, int puntosAtaqueTierra, int X, int Y);
    public void atacarAire(RangoAtaque rango, Racita unidadAtacable, int puntosAtaqueAire, int X, int Y);
}
