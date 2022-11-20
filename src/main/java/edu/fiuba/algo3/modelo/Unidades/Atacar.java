package edu.fiuba.algo3.modelo.Unidades;

import edu.fiuba.algo3.modelo.Raza;
import edu.fiuba.algo3.modelo.Rango.RangoAtaque;

public interface Atacar {
    public void atacarTierra(RangoAtaque rango, Raza unidadAtacable, int puntosAtaqueTierra);
    public void atacarAire(RangoAtaque rango, Raza unidadAtacable, int puntosAtaqueAire);
}
