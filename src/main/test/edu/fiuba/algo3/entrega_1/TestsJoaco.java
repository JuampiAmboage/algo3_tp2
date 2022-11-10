package edu.fiuba.algo3.entrega_1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestsJoaco {

    /*
     Caso de uso #5: Verificar que no se puedan construir edificios fuera del rango de un pilon o fuera del moho.
    */

    @Test
    public void caso05_1 () {
        Celda c = new Celda("libre", "moho");
        c.construirEdificio();
        //Assert que no salte la excepcion de que no se puede construir ahi
        assertFalse();
    }

    @Test
    public void caso05_2 () {
        Celda c = new Celda("libre", "energizada");
        c.construirEdificio();
        //Assert que no salte la excepcion de que no se puede construir ahi
        assertFalse();
    }

    @Test
    public void caso05_3 () {
        Celda c = new Celda("libre", null);
        c.construirEdificio();
        //Assert que salte la excepcion de que no se puede construir ahi
        assertTrue();
    }

    /*
    CAso de uso #6: Verificar el crecimiento del moho acorde a lo estipulado.
    */

    @Test
    public void caso06_1() {
        Partida partida = new Partida();

        Celda celdaSinMoho = new Celda("libre", null);
        Celda celdaDeAlLado = new Celda("libre", "moho");

        partida.pasarTurno();
        partida.pasarTurno();

        assertTrue(celdaSinMoho.crecerMoho(celdaDeAlLado));
    }

    /*
    Caso de uso #7: Verificar la recolección de minerales para ambas razas.
    */
    @Test

    //Recoleccion de gas
    public void caso07_1(){
        int extraido;

        Zangano zangano = new Zangano();
        Zangano[] zanganosTrabajadores = new Zangano[3];

        Partida partida = new partida();

        //Extractor extractor = zangano.construirExtractor();

        zanganosTrabajadores[0] = zangano;

        for (int i = 0; i == 3; i++) {
            partida.pasarTurno();
            extraido = extractor.extraerGas(zanganosTrabajadores);
        }

        assertEquals(30, extraido);

    }

    //Recoleccion de minerales (Nexo mineral)
    @Test
    public void caso07_2() {
        NexoMineral nexo = new NexoMineral();
        Partida partida = new Partida();

        partida.pasarTurno();

        assertEquals(5, nexo.minar());
    }

    /*
    Caso de uso #8: Verificar que sino se tienen los recursos no se pueden construir los edificios (Para cada edificio para cada raza).
    */

    //Construir edificio Zerg
    @Test
    public void caso08_1(){
        Zangano zangano = new Zangano();

        String excepcion = zangano.construirAsimilador();
        String mensajeEsperado = "No se puede construir por falta de material";

        assertTrue(excepcion.contains(mensajeEsperado));
    }

}
