package edu.fiuba.algo3.modelo.Ataque;

import edu.fiuba.algo3.modelo.Rango.RangoAtaque;
import edu.fiuba.algo3.modelo.Razas.Tropas.TropaAerea;
import edu.fiuba.algo3.modelo.Razas.Tropas.TropaTerrestre;
import edu.fiuba.algo3.modelo.Razas.Unidad;

public interface Atacar {
    public void atacarTierra(RangoAtaque rango, Unidad unidadAtacable, int puntosAtaqueTierra);
    public void atacarAire(RangoAtaque rango, TropaAerea unidadAtacable, int puntosAtaqueAire);
}
