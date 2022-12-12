package edu.fiuba.algo3.modelo.Ataque;

import edu.fiuba.algo3.modelo.Ataque.Atacar;
import edu.fiuba.algo3.modelo.Excepciones.TropaSinAtaqueATierra;
import edu.fiuba.algo3.modelo.Rango.RangoAtaque;
import edu.fiuba.algo3.modelo.Razas.Tropas.TropaAerea;
import edu.fiuba.algo3.modelo.Razas.Tropas.TropaTerrestre;
import edu.fiuba.algo3.modelo.Razas.Unidad;

public class AtacarAire implements Atacar {

    public void atacarTierra(RangoAtaque rango, TropaTerrestre unidadAtacable, int puntosAtaqueTierra){
        throw new TropaSinAtaqueATierra();
    }
    public void atacarAire(RangoAtaque rango, TropaAerea unidadAtacable, int puntosAtaqueAire) {
        rango.localizarTropaEnRango((Unidad)unidadAtacable,puntosAtaqueAire);
    }
}
