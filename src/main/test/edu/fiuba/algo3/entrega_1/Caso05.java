package edu.fiuba.algo3.entrega_1;

import org.junit.jupiter.api.Test;

public class Caso05 {
    /*
     Verificar que no se puedan construir edificios fuera del rango de un pilon o fuera del moho.
    */

    @Test
    public void caso01 () {
        Celda c = new Celda("libre", "moho");
        c.construirEdificio();
        //Assert que no salte la excepcion de que no se puede construir ahi
        assertFalse();
    }

    @Test
    public void caso02 () {
        Celda c = new Celda("libre", "energizada");
        c.construirEdificio();
        //Assert que no salte la excepcion de que no se puede construir ahi
        assertFalse();
    }

    @Test
    public void caso03 () {
        Celda c = new Celda("libre", null);
        c.construirEdificio();
        //Assert que salte la excepcion de que no se puede construir ahi
        assertTrue();
    }

}
