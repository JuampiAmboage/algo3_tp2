package edu.fiuba.algo3.entrega_1.TestCase;

import edu.fiuba.algo3.modelo.Edificios.Criadero;
import Mapa;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCase01 {
    @Test
    public void unCriaderoSeIniciaConTresLarvas() {
        Criadero criadero = new Criadero();
        assertEquals(3, criadero.obtenerCantidadDeLarvas());
    }

    @Test
    public void elCriaderoEngendraUnaLarvaYReduceSuCantidad() {
        Criadero criadero = new Criadero();
        criadero.engendrar();
        assertEquals(2, criadero.obtenerCantidadDeLarvas());
    }

    @Test
    public void alEngendrarUnaLarvaYPasarTurnoElCriaderoVuelveATenerTresLarvas() {
        Mapa mapa = Mapa.getInstance();
        Criadero criadero = new Criadero();

        mapa.instanciarMapa(10,10);
        criadero.instanciacionInicial(new Posicion(4,4));
        criadero.engendrar();
        criadero.pasarTurno();

        assertEquals(3, criadero.obtenerCantidadDeLarvas());
    }

    @Test
    public void alEngendrarDosLarvasYPasarTurnoElCriaderoTerminaConDosLarvas() {
        Mapa mapa = Mapa.getInstance();
        Criadero criadero = new Criadero();

        mapa.instanciarMapa(10,10);
        criadero.instanciacionInicial(new Posicion(4,4));
        criadero.engendrar();
        criadero.engendrar();
        criadero.pasarTurno();
        assertEquals(2, criadero.obtenerCantidadDeLarvas());
    }

    @Test
    public void unCriaderoRecienCreadoSeQuedaSinLarvasAlEngendrarTresVeces() {
        Mapa mapa = Mapa.getInstance();
        Criadero criadero = new Criadero();

        mapa.instanciarMapa(10,10);
        criadero.instanciacionInicial(new Posicion(4,4));
        Criadero c = new Criadero();
        c.engendrar();
        c.engendrar();
        c.engendrar();
        assertEquals(0, c.obtenerCantidadDeLarvas());
    }
}
