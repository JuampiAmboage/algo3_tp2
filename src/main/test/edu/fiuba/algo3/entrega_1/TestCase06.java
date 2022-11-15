package edu.fiuba.algo3.entrega_1;

import org.junit.jupiter.api.Test;

public class TestCase06 {

    // Caso de uso #6: Verificar el crecimiento del moho acorde a lo estipulado.

    @Test
    public void caso06_1() {
        Partida partida = new Partida();

        Celda celdaSinMoho = new Celda("libre", null);
        Celda celdaDeAlLado = new Celda("libre", "moho");

        partida.pasarTurno();
        partida.pasarTurno();

        assertTrue(celdaSinMoho.crecerMoho(celdaDeAlLado));
    }

}
