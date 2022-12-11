package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Excepciones.EnemigoFueraDeRango;
import edu.fiuba.algo3.modelo.Partida.Mapa;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Razas.Tropas.Dragon;
import edu.fiuba.algo3.modelo.Razas.Tropas.Zerling;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class TestClass23 {
    @Test
    public void siUnaTropaEstaDentroDelRangoDeOtraYEsAtacadaRecibeDanio(){
        Mapa mapa = Mapa.getInstance();
        mapa.instanciarMapa(6,6);

        Zerling zerling = new Zerling(); //zerling hace 4 de daño
        Dragon dragon = new Dragon(); //dragon empieza con 80 de escudo y 100 de vida
        Celda celdaZerling = mapa.obtenerCelda(new Posicion(2,3));
        Celda celdaDragon = mapa.obtenerCelda(new Posicion(3,3));  //el dragon esta "abajo" del zerling;

        zerling.iniciarConstruccion();
        zerling.instanciacionesIniciales(new Posicion(2,3));
        dragon.instanciacionInicial(new Posicion(2,3));
        celdaZerling.ocuparPorTierra(zerling);
        celdaDragon.ocuparPorTierra(dragon);

        for(int i=0;i<2;i++)
            zerling.pasarTurno(); //el zerling necesita estar construido para atacar

        zerling.atacarTierra(dragon);

        assertEquals(76,dragon.obtenerEscudo());
    }

    @Test
    public void siUnaTropaNoEstaDentroDelRangoDeOtraNoPuedeSerAtacada(){
        Mapa mapa = Mapa.getInstance();
        Zerling zerling = new Zerling(); //zerling hace 4 de daño
        Dragon dragon = new Dragon(); //dragon empieza con 80 de escudo y 100 de vida
        Celda celdaZerling = mapa.obtenerCelda(new Posicion(3,4));
        Celda celdaDragon = mapa.obtenerCelda(new Posicion(3,3));

        zerling.iniciarConstruccion();

        mapa.instanciarMapa(6,6);

        celdaZerling.ocuparPorTierra(zerling);
        zerling.instanciacionesIniciales(new Posicion(3,6));
        dragon.instanciacionInicial(new Posicion(3,3));

        for(int i=0;i<2;i++)
            zerling.pasarTurno();

        assertThrows(EnemigoFueraDeRango.class,()->zerling.atacarTierra(dragon));

    }
}
