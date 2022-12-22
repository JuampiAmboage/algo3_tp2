package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.Comunidad.ComunidadZerg;
import edu.fiuba.algo3.modelo.Edificios.*;
import edu.fiuba.algo3.modelo.Excepciones.EdificioHabilitadorNoCreado;
import edu.fiuba.algo3.modelo.Excepciones.UnidadNoTerminada;
import edu.fiuba.algo3.modelo.Partida.Mapa;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Razas.Tropas.Mutalisco;
import edu.fiuba.algo3.modelo.Razas.Tropas.Zerling;
import edu.fiuba.algo3.modelo.Razas.Tropas.Zangano;
import edu.fiuba.algo3.modelo.Recursos.Volcan;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class TestClass22 {
    @Test
    public void siConstruyoUnZanganoTardaYLoQuieroUsarSinTerminarSuConstruccionLanzaExcepcion(){
        Zangano zangano = new Zangano();
        zangano.iniciarConstruccion();
        assertThrows(UnidadNoTerminada.class,()->zangano.asignarTrabajoEnExtractor(new Extractor(new Volcan())));
    }

    @Test
    public void siConstruyoUnZanganoYPasaElTurnoCorrespondienteLoPuedoUsar(){
        Mapa.getInstance().instanciarMapa();
        Zangano zangano = new Zangano();
        Extractor extractor = new Extractor(new Volcan());

        zangano.instanciacionesIniciales(new Posicion(3,3));
        extractor.instanciacionesIniciales(new Posicion(3,4));
        zangano.iniciarConstruccion();
        zangano.pasarTurno();
        extractor.construccionInstantanea();

        assertDoesNotThrow(()->zangano.asignarTrabajoEnExtractor(extractor));
    }


    @Test
    public void puedoConstruirUnZerlingSiHayUnaReservaDeReproduccion(){
        Criadero criadero = new Criadero();
        Zerling zerling= new Zerling();
        ReservaDeReproduccion reservaDeReproduccion = new ReservaDeReproduccion();
        ComunidadZerg comunidadZerg = ComunidadZerg.obtenerInstanciaDeClase();

        Mapa.getInstance().instanciarMapa();
        comunidadZerg.aniadirCapacidadSuministro(200);
        comunidadZerg.aniadirMineral(175);
        comunidadZerg.agregarUnidad(criadero);
        comunidadZerg.agregarUnidad(reservaDeReproduccion);
        criadero.instanciacionesIniciales(new Posicion(3,3));

        for(int i=0;i<12;i++) {
            criadero.pasarTurno(); //construyo el criadero
            reservaDeReproduccion.pasarTurno(); //construyo la reserva
        }
        Executable construirZerling = () -> {
            ComunidadZerg.obtenerInstanciaDeClase().crearUnidadTerrestre(criadero,zerling);
        };
        assertDoesNotThrow(construirZerling);
    }

    @Test
    public void puedoConstruirUnMutaliscoSiHayUnaEspiral(){
        Criadero criadero = new Criadero();
        Mutalisco mutalisco= new Mutalisco();
        Espiral espiral = new Espiral(); //para poder construir mutalisco

        Mapa.getInstance().instanciarMapa();
        ComunidadZerg comunidadZerg = ComunidadZerg.obtenerInstanciaDeClase();
        comunidadZerg.aniadirCapacidadSuministro(200);
        comunidadZerg.aniadirMineral(600);
        comunidadZerg.aniadirGasVespeno(300);
        comunidadZerg.agregarUnidad(criadero);
        comunidadZerg.agregarUnidad(espiral);
        criadero.instanciacionesIniciales(new Posicion(6,8));

        for(int i=0;i<12;i++) {
            criadero.pasarTurno(); //construyo el criadero
            espiral.pasarTurno(); //construyo la espiral
        }
        //ACLARACION: no necesito las correlativas de espiral porque uso agregarUnidad en lugar de construirEdificio
        Executable construirZerling = () -> {
            ComunidadZerg.obtenerInstanciaDeClase().crearUnidadAerea(criadero,mutalisco);
        };
        assertDoesNotThrow(construirZerling);
    }

}
