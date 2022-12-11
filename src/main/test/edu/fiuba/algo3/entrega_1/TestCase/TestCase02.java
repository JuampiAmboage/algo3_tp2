package edu.fiuba.algo3.entrega_1.TestCase;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Celdas.CeldaConMoho;
import edu.fiuba.algo3.modelo.Comunidad.ComunidadZerg;
import edu.fiuba.algo3.modelo.Edificios.ReservaDeReproduccion;
import edu.fiuba.algo3.modelo.Excepciones.UnidadNoTerminada;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Razas.Tropas.Zerling;
import edu.fiuba.algo3.modelo.Razas.Zangano;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import edu.fiuba.algo3.modelo.Edificios.Criadero;

public class TestCase02 {

    @Test
    public void unCriaderoQueTarda4TurnosEnConstruirseLanzaUnErrorCuandoSeLoQuiereUsar() {
        Criadero criadero = new Criadero();
        criadero.iniciarConstruccion();
        assertThrows(UnidadNoTerminada.class,()->criadero.engendrar(new Zerling()));
    }

    @Test
    public void unCriaderoDebeEsperar4TurnosParaPoderUsarse() {
        Criadero criadero = new Criadero();
        criadero.iniciarConstruccion();
        for(int i=0;i<4;i++) {
            criadero.pasarTurno();
        }
        assertDoesNotThrow(()->criadero.engendrar(new Zangano()));
    }
    @Test
    public void unCriaderoDebeEsperar4TurnosParaPoderUsarse2() {
        Criadero criadero = new Criadero();
        ReservaDeReproduccion reservaDeReproduccion = new ReservaDeReproduccion();
        criadero.instanciacionesIniciales(new Posicion(3,3));
        criadero.iniciarConstruccion();
        reservaDeReproduccion.iniciarConstruccion();
        for(int i=0;i<7;i++) {
            criadero.pasarTurno();
            reservaDeReproduccion.pasarTurno();
        }
        assertDoesNotThrow(()->criadero.engendrar(new Zerling()));
    }

}
