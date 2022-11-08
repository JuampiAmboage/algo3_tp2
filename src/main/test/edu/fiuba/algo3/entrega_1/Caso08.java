package edu.fiuba.algo3.entrega_1;

import org.junit.jupiter.api.Test;

public class Caso08 {
    /*
    Verificar que sino se tienen los recursos no se pueden construir los edificios (Para cada
    edificio para cada raza).
    */

    //Construir edificio Zerg
    @Test
    public void caso01(){
        Zangano zangano = new Zangano();

        String excepcion = zangano.construirAsimilador();
        String mensajeEsperado = "No se puede construir por falta de material";

        assertTrue(excepcion.contains(mensajeEsperado));
    }

}
