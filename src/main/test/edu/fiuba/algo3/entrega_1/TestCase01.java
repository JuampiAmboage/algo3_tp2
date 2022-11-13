package edu.fiuba.algo3.entrega_1;
import edu.fiuba.algo3.modelo.Criadero.Criadero;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCase01 {
    @Test
    public void unCriaderoSeIniciaConTresLarvas() {
        Criadero c = new Criadero();
        assertEquals(3, c.cantidadLarvas());
    }

    @Test
    public void elCriaderoEngendraUnaLarvaYReduceSuCantidad() {
        Criadero c = new Criadero();
        c.engendrar();
        assertEquals(2, c.cantidadLarvas());
    }

    @Test
    public void alEngendrarUnaLarvaYPasarTurnoElCriaderoVuelveATenerTresLarvas() {
        Criadero c = new Criadero();
        c.engendrar();
        c.pasarTurno();
        assertEquals(3, c.cantidadLarvas());
    }

    @Test
    public void alEngendrarDosLarvasYPasarTurnoElCriaderoTerminaConDosLarvas() {
        Criadero c = new Criadero();
        c.engendrar();
        c.engendrar();
        c.pasarTurno();
        assertEquals(2, c.cantidadLarvas());
    }

    @Test
    public void unCriaderoRecienCreadoSeQuedaSinLarvasAlEngendrarTresVeces() {
        Criadero c = new Criadero();
        c.engendrar();
        c.engendrar();
        c.engendrar();
        assertEquals(0, c.cantidadLarvas());
    }
 */
}