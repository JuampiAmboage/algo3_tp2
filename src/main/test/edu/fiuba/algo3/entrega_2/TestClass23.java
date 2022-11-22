package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Raza;
import edu.fiuba.algo3.modelo.Unidades.Dragon;
import edu.fiuba.algo3.modelo.Unidades.Zerling;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestClass23 {
    @Test
    public void siUnaTropaEstaDentroDelRangoDeOtraYEsAtacadaRecibeDanio(){
        Mapa mapa = Mapa.getInstance();
        Zerling zerling = new Zerling(); //zerling hace 4 de daño
        Dragon dragon = new Dragon(); //dragon empieza con 80 de escudo y 100 de vida

        mapa.instanciarMapa(6,6);
        Celda celdaZerling = mapa.obtenerCelda(2,3);
        Celda celdaDragon = mapa.obtenerCelda(3,3);  //el dragon esta "abajo" del zerling;

        celdaZerling.ocupar(zerling);
        celdaDragon.ocupar(dragon);
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

        mapa.instanciarMapa(6,6);
        Celda celdaZerling = mapa.obtenerCelda(2,3);
        Celda celdaDragon = mapa.obtenerCelda(2,2);
        celdaZerling.ocupar(zerling);
        zerling.instanciacionInicial(new Posicion(2,2));
        dragon.instanciacionInicial(new Posicion(2,2));
        zerling.atacarTierra(dragon);

        assertEquals(76,dragon.obtenerEscudo());
    }
}
