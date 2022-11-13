package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.Unidades.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestCase18 {
    /*public void ataqueDeUnidadCorrecto(Unidad unidadATestear,int valorDeAtaqueEsperado){
        assertEquals(valorDeAtaqueEsperado,unidadATestear.obtenerDanio());
    }*/

    @Test
    public void testearAtaques(){

        //UNIDADES ZERG
        Zerling zerling = new Zerling();
        Hidralisco hidralisco = new Hidralisco();
        Mutalisco mutalisco = new Mutalisco();

        //UNIDADES PROTOSS
        Zealot zealot = new Zealot();
        Dragon dragon = new Dragon();
        Scout scout = new Scout();

        //ASSERTS
        assertEquals(4,zerling.obtenerDanioTerrestre());
        assertEquals(10,hidralisco.obtenerDanioTerrestre());
        assertEquals(9,mutalisco.obtenerDanioTerrestre());
        assertEquals(8,zealot.obtenerDanioTerrestre());
        assertEquals(20,dragon.obtenerDanioTerrestre());
        assertEquals(8,scout.obtenerDanioTerrestre());    }
}
