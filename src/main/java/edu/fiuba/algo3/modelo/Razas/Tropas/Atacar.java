package edu.fiuba.algo3.modelo.Razas.Tropas;

import edu.fiuba.algo3.modelo.Razas.Raza;
import edu.fiuba.algo3.modelo.Rango.RangoAtaque;

public interface Atacar {
    public void atacarTierra(RangoAtaque rango, Raza unidadAtacable, int puntosAtaqueTierra);
    public void atacarAire(RangoAtaque rango, Raza unidadAtacable, int puntosAtaqueAire);
}
