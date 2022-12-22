package edu.fiuba.algo3.entrega_1.TestCase;

import edu.fiuba.algo3.modelo.Comunidad.ComunidadZerg;
import edu.fiuba.algo3.modelo.Edificios.Criadero;
import edu.fiuba.algo3.modelo.Partida.Mapa;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Razas.Tropas.Zangano;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCase01 {
    @Test
    public void unCriaderoSeIniciaConTresLarvas() {
        Criadero criadero = new Criadero();
        criadero.construccionInstantanea();
        assertEquals(3, criadero.obtenerCantidadDeLarvas());
    }

    @Test
    public void elCriaderoEngendraUnaLarvaYReduceSuCantidad() {
        Mapa.getInstance().instanciarMapa();
        Criadero criadero = new Criadero();
        ComunidadZerg.obtenerInstanciaDeClase().agregarUnidad(criadero);
        criadero.construccionInstantanea();
        criadero.instanciacionesIniciales(new Posicion(3,3));
        criadero.engendrar(new Zangano());
        assertEquals(2, criadero.obtenerCantidadDeLarvas());
    }

    @Test
    public void alEngendrarUnaLarvaYPasarTurnoElCriaderoVuelveATenerTresLarvas() {
        Mapa.getInstance().instanciarMapa();
        Criadero criadero = new Criadero();
        ComunidadZerg.obtenerInstanciaDeClase().agregarUnidad(criadero);
        ComunidadZerg.obtenerInstanciaDeClase().aniadirMineral(700);
        criadero.construccionInstantanea();
        criadero.instanciacionesIniciales(new Posicion(3,3));
        criadero.engendrar(new Zangano());
        criadero.pasarTurno();
        assertEquals(3, criadero.obtenerCantidadDeLarvas());
    }

    @Test
    public void alEngendrarDosLarvasYPasarTurnoElCriaderoTerminaConDosLarvas() {
        Mapa.getInstance().instanciarMapa();
        Criadero criadero = new Criadero();
        ComunidadZerg.obtenerInstanciaDeClase().agregarUnidad(criadero);
        ComunidadZerg.obtenerInstanciaDeClase().aniadirMineral(1500);
        criadero.construccionInstantanea();
        criadero.instanciacionesIniciales(new Posicion(3,3));
        criadero.engendrar(new Zangano());
        criadero.engendrar(new Zangano());
        criadero.pasarTurno();
        assertEquals(2, criadero.obtenerCantidadDeLarvas());
    }

    @Test
    public void unCriaderoRecienCreadoSeQuedaSinLarvasAlEngendrarTresVeces() {
        Mapa.getInstance().instanciarMapa();
        Criadero criadero = new Criadero();
        ComunidadZerg.obtenerInstanciaDeClase().agregarUnidad(criadero);
        ComunidadZerg.obtenerInstanciaDeClase().aniadirMineral(1500);
        criadero.construccionInstantanea();
        criadero.instanciacionesIniciales(new Posicion(3,3));
        criadero.engendrar(new Zangano());
        criadero.engendrar(new Zangano());
        criadero.engendrar(new Zangano());
        assertEquals(0, criadero.obtenerCantidadDeLarvas());
    }
}
