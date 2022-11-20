package edu.fiuba.algo3.entrega_1.UnitTest;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MapaTest {
    @Test
    public void elMapaSeCreaConCeldasAdentro() {
        Mapa m = Mapa.getInstance();
        m.instanciarMapa(5,5);
        Celda c = m.obtenerCelda(new Posicion(5,5));

        assertTrue(Celda.esCelda(c));
    }

    @Test
    public void elMapaCargaCorrectamenteLaCantidadDeCeldasAdyacentesDeLasCeldas() {
        Mapa m = Mapa.getInstance();
        m.instanciarMapa(3,3);
        Celda c = m.obtenerCelda(new Posicion(3,3));

        assertEquals(8, c.cantidadAdyacentes());
    }

    @Test
    public void elMapaEsUnaSolaInstancia(){
        Mapa m = Mapa.getInstance();
        m.instanciarMapa(8,8);

        Mapa s = Mapa.getInstance();
        Mapa y = Mapa.getInstance();

        /*assertEquals(8,s.());
        assertEquals(8,y.obtenerTamanio());*/
    }

}
