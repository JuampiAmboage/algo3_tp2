package edu.fiuba.algo3.entrega_1.UnitTest;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Partida.Mapa;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MapaTest {
    @Test
    public void elMapaSeCreaConCeldasAdentro() {
        Mapa mapa = Mapa.getInstance();
        //mapa.instanciarMapa(5,5);
        mapa.instanciarMapa();
        Celda celdaRandom = mapa.obtenerCelda(new Posicion(3,3));

        assertTrue(Celda.esCelda(celdaRandom));
    }

    /*@Test
    public void elMapaCargaCorrectamenteLaCantidadDeCeldasAdyacentesDeLasCeldas() {
        Mapa m = Mapa.getInstance();
        m.instanciarMapa(3,3);
        Celda c = m.obtenerCelda(new Posicion(3,3));

        assertEquals(8, c.cantidadAdyacentes());
    }*/

    @Test
    public void elMapaEsUnaSolaInstancia(){
        Mapa mapa = Mapa.getInstance();
        //mapa.instanciarMapa(8,8);
        mapa.instanciarMapa();

        Mapa unaInstancia = Mapa.getInstance();
        Mapa otraInstancia = Mapa.getInstance();

        //assertEquals(8,unaInstancia.obtenerLongitudFilas());
        //assertEquals(8,otraInstancia.obtenerLongitudColumnas());
    }

}
