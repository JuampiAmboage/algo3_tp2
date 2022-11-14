package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Mapa;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MapaTest {
    @Test
    public void elMapaSeCreaConCeldasAdentro() {
        Mapa m = Mapa.getInstance();
        m.instanciarMapa(5);
        Celda c = m.obtenerCelda(0,0);

        assertTrue(Celda.esCelda(c));
    }

    @Test
    public void elMapaCargaCorrectamenteLaCantidadDeCeldasAdyacentesDeLasCeldas() {
        Mapa m = Mapa.getInstance();
        m.instanciarMapa(3);
        Celda c = m.obtenerCelda(1,1);

        assertEquals(8, c.cantidadAdyacentes());
    }

    @Test
    public void elMapaEsUnaSolaInstancia(){
        Mapa m = Mapa.getInstance();
        m.instanciarMapa(8);

        Mapa s = Mapa.getInstance();
        Mapa y = Mapa.getInstance();

        assertEquals(8,s.obtenerTamanio());
        assertEquals(8,y.obtenerTamanio());
    }

}
