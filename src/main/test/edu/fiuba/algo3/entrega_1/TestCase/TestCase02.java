package edu.fiuba.algo3.entrega_1.TestCase;

import edu.fiuba.algo3.modelo.Comunidad.ComunidadZerg;
import edu.fiuba.algo3.modelo.Edificios.ReservaDeReproduccion;
import edu.fiuba.algo3.modelo.Excepciones.UnidadNoTerminada;
import edu.fiuba.algo3.modelo.Partida.Mapa;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Razas.Tropas.Zerling;
import edu.fiuba.algo3.modelo.Razas.Tropas.Zangano;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import edu.fiuba.algo3.modelo.Edificios.Criadero;

public class TestCase02 {


    @Test
    public void unCriaderoQueTarda4TurnosEnConstruirseLanzaUnErrorCuandoSeLoQuiereUsar() {
        Mapa.getInstance().instanciarMapa();
        Criadero criadero = new Criadero();
        criadero.instanciacionesIniciales(new Posicion(3,3));

        ComunidadZerg.obtenerInstanciaDeClase().agregarUnidad(criadero);
        assertThrows(UnidadNoTerminada.class,()->criadero.engendrar(new Zangano()));
    }

    @Test
    public void unCriaderoDebeEsperar4TurnosParaPoderUsarse() {
        Mapa.getInstance().instanciarMapa();
        Criadero criadero = new Criadero();
        criadero.instanciacionesIniciales(new Posicion(3,3));
        ComunidadZerg.obtenerInstanciaDeClase().aniadirMineral(5000);
        ComunidadZerg.obtenerInstanciaDeClase().aniadirGasVespeno(1000);
        ComunidadZerg.obtenerInstanciaDeClase().agregarUnidad(criadero);

        for(int i=0;i<4;i++) {
            criadero.pasarTurno();
        }
        assertDoesNotThrow(()->criadero.engendrar(new Zangano()));
    }
    @Test
    public void unCriaderoDebeEsperar4TurnosParaPoderUsarse2() {
        Mapa.getInstance().instanciarMapa();
        Criadero criadero = new Criadero();
        ReservaDeReproduccion reservaDeReproduccion = new ReservaDeReproduccion();
        criadero.instanciacionesIniciales(new Posicion(3,3));
        ComunidadZerg.obtenerInstanciaDeClase().agregarUnidad(reservaDeReproduccion);
        criadero.iniciarConstruccion();
        for(int i=0;i<12;i++) {
            criadero.pasarTurno();
            reservaDeReproduccion.pasarTurno();
        }
        assertDoesNotThrow(()->criadero.engendrar(new Zerling()));
    }

}
