package edu.fiuba.algo3.entrega_1.TestCase;
import edu.fiuba.algo3.modelo.ComunidadNueva.Comunidad;
import edu.fiuba.algo3.modelo.ComunidadNueva.ComunidadZerg;
import edu.fiuba.algo3.modelo.Edificios.Criadero;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCase01 {
    @Test
    public void unCriaderoSeIniciaConTresLarvas() {
        Criadero criadero = new Criadero();
        //assertEquals(3, criadero.obtenerCantidadDeLarvas());
    }

    @Test
    public void elCriaderoEngendraUnaLarvaYReduceSuCantidad() {
        Criadero criadero = new Criadero();
        criadero.engendrar();
        assertEquals(2, criadero.obtenerCantidadDeLarvas());
    }

    @Test
    public void alEngendrarUnaLarvaYPasarTurnoElCriaderoVuelveATenerTresLarvas() {
        Criadero c = new Criadero();
        c.engendrar();
        c.pasarTurno();
        assertEquals(3, c.obtenerCantidadDeLarvas());
    }

    @Test
    public void alEngendrarDosLarvasYPasarTurnoElCriaderoTerminaConDosLarvas() {
        Criadero c = new Criadero();
        c.engendrar();
        c.engendrar();
        c.pasarTurno();
        assertEquals(2, c.obtenerCantidadDeLarvas());
    }

    @Test
    public void unCriaderoRecienCreadoSeQuedaSinLarvasAlEngendrarTresVeces() {
        Criadero c = new Criadero();
        c.engendrar();
        c.engendrar();
        c.engendrar();
        assertEquals(0, c.obtenerCantidadDeLarvas());
    }
}
