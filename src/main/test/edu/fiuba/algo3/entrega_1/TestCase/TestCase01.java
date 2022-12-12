package edu.fiuba.algo3.entrega_1.TestCase;

import edu.fiuba.algo3.modelo.Comunidad.ComunidadZerg;
import edu.fiuba.algo3.modelo.Edificios.Criadero;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Razas.Tropas.Zangano;
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
        ComunidadZerg.obtenerInstanciaDeClase().agregarUnidad(criadero);
        criadero.instanciacionesIniciales(new Posicion(3,3));
        criadero.engendrar(new Zangano());
        assertEquals(2, criadero.obtenerCantidadDeLarvas());
    }

    @Test
    public void alEngendrarUnaLarvaYPasarTurnoElCriaderoVuelveATenerTresLarvas() {
        Criadero criadero = new Criadero(0);
        ComunidadZerg.obtenerInstanciaDeClase().agregarUnidad(criadero);
        criadero.instanciacionesIniciales(new Posicion(3,3));
        criadero.engendrar(new Zangano());
        criadero.pasarTurno();
        assertEquals(3, criadero.obtenerCantidadDeLarvas());
    }

    @Test
    public void alEngendrarDosLarvasYPasarTurnoElCriaderoTerminaConDosLarvas() {
        Criadero criadero = new Criadero(0);
        ComunidadZerg.obtenerInstanciaDeClase().agregarUnidad(criadero);
        criadero.instanciacionesIniciales(new Posicion(3,3));
        criadero.engendrar(new Zangano());
        criadero.engendrar(new Zangano());
        criadero.pasarTurno();
        assertEquals(2, criadero.obtenerCantidadDeLarvas());
    }

    @Test
    public void unCriaderoRecienCreadoSeQuedaSinLarvasAlEngendrarTresVeces() {
        Criadero criadero = new Criadero(0);
        ComunidadZerg.obtenerInstanciaDeClase().agregarUnidad(criadero);
        criadero.instanciacionesIniciales(new Posicion(3,3));
        criadero.engendrar(new Zangano());
        criadero.engendrar(new Zangano());
        criadero.engendrar(new Zangano());
        assertEquals(0, criadero.obtenerCantidadDeLarvas());
    }
}
