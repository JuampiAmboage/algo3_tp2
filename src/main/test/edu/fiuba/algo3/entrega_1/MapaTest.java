package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Celda;
import edu.fiuba.algo3.modelo.Mapa;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MapaTest {
    @Test
    public void elMapaSeCreaConCeldasAdentro() {
        Mapa m = new Mapa(5);
        Celda c = m.obtenerCelda(0,0);

        assertTrue(Celda.esCelda(c));
    }

    @Test
    public void elMapaCargaCorrectamenteLaCantidadDeCeldasAdyacentesDeLasCeldas() {
        Mapa m = new Mapa(3);
        Celda c = m.obtenerCelda(1,1);

        assertEquals(8, c.cantidadAdyacentes());
    }

}
