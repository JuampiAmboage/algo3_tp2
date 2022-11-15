package edu.fiuba.algo3.entrega_1;

import org.junit.jupiter.api.Test;

public class TestCase08 {

    // Caso de uso #8: Verificar que sino se tienen los recursos no se pueden construir los edificios (Para cada edificio para cada raza).

    //Construir edificio Zerg
    @Test
    public void caso08_1(){
        Zangano zangano = new Zangano();

        String excepcion = zangano.construirAsimilador();
        String mensajeEsperado = "No se puede construir por falta de material";

        assertTrue(excepcion.contains(mensajeEsperado));
    }

}
