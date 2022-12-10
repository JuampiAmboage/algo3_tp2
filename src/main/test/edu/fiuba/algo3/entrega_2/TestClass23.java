package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Partida.Mapa;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Razas.Tropas.Dragon;
import edu.fiuba.algo3.modelo.Razas.Tropas.Zerling;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestClass23 {
    @Test
    public void siUnaTropaEstaDentroDelRangoDeOtraYEsAtacadaRecibeDanio(){
        Mapa mapa = Mapa.getInstance();
        Zerling zerling = new Zerling(); //zerling hace 4 de daño
        Dragon dragon = new Dragon(); //dragon empieza con 80 de escudo y 100 de vida

        //mapa.instanciarMapa(6,6);
        Celda celdaZerling = mapa.obtenerCelda(new Posicion(2,3));
        Celda celdaDragon = mapa.obtenerCelda(new Posicion(3,3));  //el dragon esta "abajo" del zerling;

        celdaZerling.ocuparPorTierra(zerling);
        celdaDragon.ocuparPorTierra(dragon);
        zerling.instanciacionInicial(new Posicion(2,3));
        dragon.instanciacionInicial(new Posicion(2,3));
        zerling.atacarTierra(dragon);

        assertEquals(76,dragon.obtenerEscudo());
    }

    @Test
    public void siUnaTropaNoEstaDentroDelRangoDeOtraNoPuedeSerAtacada(){
        Mapa mapa = Mapa.getInstance();
        Zerling zerling = new Zerling(); //zerling hace 4 de daño
        Dragon dragon = new Dragon(); //dragon empieza con 80 de escudo y 100 de vida

        //mapa.instanciarMapa(6,6);
        mapa.instanciarMapa();
        Celda celdaZerling = mapa.obtenerCelda(new Posicion(2,3));
        Celda celdaDragon = mapa.obtenerCelda(new Posicion(2,2));
        celdaZerling.ocuparPorTierra(zerling);
        zerling.instanciacionInicial(new Posicion(2,2));
        dragon.instanciacionInicial(new Posicion(2,2));
        zerling.atacarTierra(dragon);

        assertEquals(76,dragon.obtenerEscudo());
    }
}
