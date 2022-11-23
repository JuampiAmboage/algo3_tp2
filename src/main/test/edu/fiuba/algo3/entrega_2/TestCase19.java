package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.Razas.Tropas.Mutalisco;
import edu.fiuba.algo3.modelo.Razas.Tropas.Scout;
import edu.fiuba.algo3.modelo.Razas.Tropas.Zerling;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;



public class TestCase19 {
    @Test
    public void siUnaUnidadTerrestreSinAtaqueAereoAtacaAUnaUnidadAereaLanzaError() {
        Zerling zerling = new Zerling();
        Mutalisco mutalisco = new Mutalisco();
        assertThrows(IllegalArgumentException.class, () -> zerling.atacarAire(mutalisco));
    }
    @Test
    public void siUnaUnidadConAtaqueAereoAtacaAUnaUnidadAereaElAtaqueEsEfectivo(){
        Mutalisco mutalisco = new Mutalisco(); //el mutalisco empieza con 80 de vida
        Scout scout = new Scout(); //cuando el scout ataca a una unidad aerea hace 14 de daño
        scout.atacarAire(mutalisco);
        assertEquals(66,mutalisco.obtenerVida());
    }
    @Test
    public void siUnaUnidadConAtaqueTerrestreAtacaAOtraTerrestreElAtaqueEsEfectivo(){
        Zerling zerling = new Zerling(); //el zerling empieza con 35 de vida
        Scout scout = new Scout(); //cuando el scout ataca a una unidad terrestre hace 8 de daño
        scout.atacarTierra(zerling);
        assertEquals(27,zerling.obtenerVida());
    }
}
