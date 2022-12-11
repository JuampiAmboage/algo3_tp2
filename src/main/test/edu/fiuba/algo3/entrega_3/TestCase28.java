package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.modelo.Comunidad.ComunidadZerg;
import edu.fiuba.algo3.modelo.Excepciones.TropaNoVisible;
import edu.fiuba.algo3.modelo.Partida.Mapa;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Razas.Tropas.AmoSupremo;
import edu.fiuba.algo3.modelo.Razas.Tropas.Scout;
import edu.fiuba.algo3.modelo.Razas.Tropas.Zealot;
import edu.fiuba.algo3.modelo.Razas.Tropas.Zerling;
import edu.fiuba.algo3.modelo.Razas.Zangano;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestCase28 {

    @Test void unZealotEsAtacableSiNoMatoATresEnemigos(){
        Zealot zealot = new Zealot();
        Zerling zerling = new Zerling();
        Mapa mapa = Mapa.getInstance();
        mapa.instanciarMapa(9,9);
        zealot.instanciacionesIniciales(new Posicion(5,6));

        zerling.instanciacionesIniciales(new Posicion(5,5));

        mapa.obtenerCelda(new Posicion(5,7)).ocuparPorTierra(zealot);
        mapa.obtenerCelda(new Posicion(5,5)).ocuparPorTierra(zerling);

        zerling.iniciarConstruccion();
        for(int i=0;i<2;i++)
            zerling.pasarTurno();

        zerling.atacarTierra(zealot);

        assertEquals(56,zealot.obtenerEscudo());

    }

    @Test void siUnZealotSeVuelveInvisibleNoEsAtacable(){
        Zealot zealot = new Zealot();
        Zerling zerling = new Zerling();
        Mapa mapa = Mapa.getInstance();
        mapa.instanciarMapa(9,9);
        zealot.instanciacionesIniciales(new Posicion(7,8));

        zerling.instanciacionesIniciales(new Posicion(7,7));

        mapa.obtenerCelda(new Posicion(7,8)).ocuparPorTierra(zealot);
        mapa.obtenerCelda(new Posicion(7,7)).ocuparPorTierra(zerling);

        zerling.iniciarConstruccion();
        for(int i=0;i<2;i++)
            zerling.pasarTurno();

        zealot.volverInsvisible();

        assertThrows(TropaNoVisible.class,()->zerling.atacarTierra(zealot));
    }
    @Test
    void siUnZealotEsInvisiblePeroLoAtacaUnAmoSupremoRecibeDanio(){
        Zealot zealot = new Zealot();
        AmoSupremo amoSupremo = new AmoSupremo();
        Zerling zerling = new Zerling();
        Mapa mapa = Mapa.getInstance();

        mapa.instanciarMapa(9,9);
        zealot.instanciacionesIniciales(new Posicion(7,8));
        amoSupremo.instanciacionesIniciales(new Posicion(8,8));
        zerling.instanciacionesIniciales(new Posicion(7,7));
        zerling.iniciarConstruccion();
        amoSupremo.iniciarConstruccion();

        mapa.obtenerCelda(new Posicion(7,8)).ocuparPorTierra(zealot);
        mapa.obtenerCelda(new Posicion(8,8)).ocuparPorAire(amoSupremo);
        mapa.obtenerCelda(new Posicion(7,7)).ocuparPorTierra(zerling);

        amoSupremo.iniciarConstruccion();
        for(int i=0;i<5;i++) {
            amoSupremo.pasarTurno();
            zerling.pasarTurno();
        }
        zealot.volverInsvisible();
        amoSupremo.realizarAccionesTurno();

        assertDoesNotThrow(()->zerling.atacarTierra(zealot));
    }

    @Test void siUnZealotMataATresEnemigosSeVuelveInvisible(){
        Zealot zealot = new Zealot();
        Zangano zangano1 = new Zangano();
        Zangano zangano2 = new Zangano();
        Zangano zangano3 = new Zangano();
        Zerling zerlingQueVaAAtacarLuego = new Zerling();
        Mapa mapa = Mapa.getInstance();
        ComunidadZerg comunidadZerg = ComunidadZerg.obtenerInstanciaDeClase();
        comunidadZerg.aniadirCapacidadSuministro(10);
        comunidadZerg.agregarUnidad(zangano1);
        comunidadZerg.agregarUnidad(zangano2);
        comunidadZerg.agregarUnidad(zangano3);

        mapa.instanciarMapa(9,9);
        zealot.instanciacionesIniciales(new Posicion(2,2));
        zangano1.instanciacionesIniciales(new Posicion(2,3));
        zangano2.instanciacionesIniciales(new Posicion(3,2));
        zangano3.instanciacionesIniciales(new Posicion(1,2));
        zerlingQueVaAAtacarLuego.instanciacionesIniciales(new Posicion(2,1));
        mapa.obtenerCelda(new Posicion(2,2)).ocuparPorTierra(zealot);
        mapa.obtenerCelda(new Posicion(2,3)).ocuparPorTierra(zangano1);
        mapa.obtenerCelda(new Posicion(3,2)).ocuparPorTierra(zangano2);
        mapa.obtenerCelda(new Posicion(1,2)).ocuparPorTierra(zangano3);
        mapa.obtenerCelda(new Posicion(2,1)).ocuparPorTierra(zerlingQueVaAAtacarLuego);

        zealot.iniciarConstruccion();
        zerlingQueVaAAtacarLuego.iniciarConstruccion();
        for(int i=0;i<4;i++) {
            zealot.pasarTurno();
            zerlingQueVaAAtacarLuego.pasarTurno();
        }

        for(int i=0;i<4;i++)
            zealot.atacarTierra(zangano1);
        for(int i=0;i<4;i++)
            zealot.atacarTierra(zangano2);
        for(int i=0;i<4;i++)
            zealot.atacarTierra(zangano3);
        assertThrows(TropaNoVisible.class,()->zerlingQueVaAAtacarLuego.atacarTierra(zealot));
    }
}
