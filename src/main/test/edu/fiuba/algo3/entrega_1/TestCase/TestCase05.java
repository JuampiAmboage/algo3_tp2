package edu.fiuba.algo3.entrega_1.TestCase;

import edu.fiuba.algo3.modelo.Celdas.*;
import edu.fiuba.algo3.modelo.Comunidad.ComunidadProtoss;
import edu.fiuba.algo3.modelo.Comunidad.ComunidadZerg;
import edu.fiuba.algo3.modelo.Edificios.*;
import edu.fiuba.algo3.modelo.Excepciones.ConstruccionProhibida;

import edu.fiuba.algo3.modelo.Partida.Mapa;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Recursos.Volcan;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class TestCase05 {

    @Test
    public void siConstruyoUnPilonPuedoConstruirEnUnaCeldaEnergizada() {
        Mapa mapa = Mapa.getInstance();
        Pilon pilon = new Pilon();

        mapa.instanciarMapa();
        mapa.obtenerCelda(new Posicion(4,4)).ocuparPorTierra(pilon);
        pilon.instanciacionesIniciales(new Posicion(4,4));
        Celda celda = mapa.obtenerCelda(new Posicion(4,5));
        assertTrue(celda.esMismoTipo(new CeldaEnergizada(celda)));
    }

    @Test
    public void siConstruyoUnPilonYLuegoLoDestruyoNoPuedoConstruirEnUnaCeldaDesenergizada() {
        Mapa mapa = Mapa.getInstance();
        Pilon pilon = new Pilon();

        mapa.instanciarMapa();
        ComunidadProtoss.obtenerInstanciaDeClase().agregarUnidad(pilon);
        mapa.obtenerCelda(new Posicion(4,4)).ocuparPorTierra(pilon);
        mapa.obtenerCelda(new Posicion(4,4)).desocuparPorTierra();
        pilon.instanciacionesIniciales(new Posicion(4,4));
        pilon.daniarIgnorandoVisibilidad(600);
        Celda celda = mapa.obtenerCelda(new Posicion(4,5));
        assertFalse(celda.esMismoTipo(new CeldaEnergizada(celda)));
    }

    @Test void siConstruyoUnCriaderoPuedoConstruirEnUnaCeldaConMohoAdyacente(){
        Mapa mapa = Mapa.getInstance();
        Criadero criadero = new Criadero();

        mapa.instanciarMapa();
        mapa.obtenerCelda(new Posicion(3,3)).ocuparPorTierra(criadero);
        criadero.instanciacionesIniciales(new Posicion(3,3));
        Celda celda = mapa.obtenerCelda(new Posicion(3,4));
        assertTrue(celda.esMismoTipo(new CeldaConMoho(celda)));
    }

    @Test
    public void noPuedoConstruirUnCriaderoEnUnaCeldaIncorrecta() {
        Criadero criadero = new Criadero();
        Celda celda = new Celda(0,0);
        assertThrows(ConstruccionProhibida.class, () -> celda.quiereConstruir(criadero));
    }

    @Test
    public void noPuedoConstruirUnAsimiladorEnUnaCeldaIncorrecta() {
        Asimilador asimilador = new Asimilador(new Volcan());
        Celda celda = new Celda(0,0);
        assertThrows(ConstruccionProhibida.class, () -> celda.quiereConstruir(asimilador));
    }
}