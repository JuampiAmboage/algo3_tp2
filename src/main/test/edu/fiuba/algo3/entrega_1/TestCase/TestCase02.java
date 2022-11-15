package edu.fiuba.algo3.entrega_1.TestCase;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import edu.fiuba.algo3.modelo.Edificios.Criadero;
import edu.fiuba.algo3.modelo.Celdas.Celda;

public class TestCase02 {

    @Test
    public void unCriaderoQueTarda4TurnosEnConstruirseLanzaUnErrorCuandoSeLoQuiereUsar() {
        Criadero c = new Criadero();


        Executable task = () -> {
            c.engendrar();
        };

        // self should: [ task() ] raise: UnknownError.
        assertThrows(RuntimeException.class, task);
    }

    @Test
    public void unCriaderoDebeEsperar4TurnosParaPoderUsarse() {
        Criadero c = new Criadero();
        Celda celda = new Celda();

        c.construir_en(celda);

        c.pasarTurno();
        c.pasarTurno();
        c.pasarTurno();
        c.pasarTurno();

        Executable task = () -> {
            c.engendrar();
        };

        assertDoesNotThrow(task);
    }

}
