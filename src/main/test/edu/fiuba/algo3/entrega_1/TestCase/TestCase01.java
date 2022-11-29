package edu.fiuba.algo3.entrega_1.TestCase;

import edu.fiuba.algo3.modelo.Edificios.Criadero;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCase01 {
    @Test
    public void unCriaderoSeIniciaConTresLarvas() {
        Criadero criadero = new Criadero(0);
        assertEquals(3, criadero.obtenerCantidadDeLarvas());
    }

    @Test
    public void elCriaderoEngendraUnaLarvaYReduceSuCantidad() {
        Criadero criadero = new Criadero(0);
        criadero.engendrar();
        assertEquals(2, criadero.obtenerCantidadDeLarvas());
    }

    @Test
    public void alEngendrarUnaLarvaYPasarTurnoElCriaderoVuelveATenerTresLarvas() {
        Criadero criadero = new Criadero(0);
        criadero.engendrar();
        criadero.pasarTurno();
        assertEquals(3, criadero.obtenerCantidadDeLarvas());
    }

    @Test
    public void alEngendrarDosLarvasYPasarTurnoElCriaderoTerminaConDosLarvas() {
        Criadero criadero = new Criadero(0);
        criadero.engendrar();
        criadero.engendrar();
        criadero.pasarTurno();
        assertEquals(2, criadero.obtenerCantidadDeLarvas());
    }

    @Test
    public void unCriaderoRecienCreadoSeQuedaSinLarvasAlEngendrarTresVeces() {
        Criadero criadero = new Criadero(0);
        criadero.engendrar();
        criadero.engendrar();
        criadero.engendrar();
        assertEquals(0, criadero.obtenerCantidadDeLarvas());
    }
}
