package edu.fiuba.algo3.modelo.Razas.Tropas;

import edu.fiuba.algo3.modelo.Rango.RangoAtaque;
import edu.fiuba.algo3.modelo.Razas.Unidad;

public interface Atacar {
    public void atacarTierra(RangoAtaque rango, Unidad unidadAtacable, int puntosAtaqueTierra);
    public void atacarAire(RangoAtaque rango, Unidad unidadAtacable, int puntosAtaqueAire);
}
