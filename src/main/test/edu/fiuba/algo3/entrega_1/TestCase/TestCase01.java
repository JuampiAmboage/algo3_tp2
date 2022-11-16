package edu.fiuba.algo3.entrega_1.TestCase;
import edu.fiuba.algo3.modelo.Edificios.Criadero;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCase01 {
    @Test
    public void unCriaderoSeIniciaConTresLarvas() {
        Criadero c = new Criadero(0);
        assertEquals(3, c.cantidadDeLarvas());
    }

    @Test
    public void elCriaderoEngendraUnaLarvaYReduceSuCantidad() {
        Criadero c = new Criadero(0);
        c.engendrar();

        assertEquals(2, c.cantidadDeLarvas());
    }

    @Test
    public void alEngendrarUnaLarvaYPasarTurnoElCriaderoVuelveATenerTresLarvas() {
        Criadero c = new Criadero(0);
        c.engendrar();
        c.pasarTurno();
        assertEquals(3, c.cantidadDeLarvas());
    }

    @Test
    public void alEngendrarDosLarvasYPasarTurnoElCriaderoTerminaConDosLarvas() {
        Criadero c = new Criadero(0);
        c.engendrar();
        c.engendrar();
        c.pasarTurno();
        assertEquals(2, c.cantidadDeLarvas());
    }

    @Test
    public void unCriaderoRecienCreadoSeQuedaSinLarvasAlEngendrarTresVeces() {
        Criadero c = new Criadero(0);
        c.engendrar();
        c.engendrar();
        c.engendrar();
        assertEquals(0, c.cantidadDeLarvas());
    }
}
