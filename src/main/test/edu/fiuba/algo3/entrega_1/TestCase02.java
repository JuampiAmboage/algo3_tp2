package edu.fiuba.algo3.entrega_1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestCase02 {

    /*
    @Test
    public void unCriaderoQueTarda4TurnosEnConstruirseLanzaUnErrorCuandoSeLoQuiereUsar() {
        Criadero c = new Criadero(4);

        Executable task = () -> {
            c.engendrar();
        };

        // self should: [ task() ] raise: UnknownError.
        assertThrows(RuntimeException.class, task);
    }

    @Test
    public void unCriaderoDebeEsperar4TurnosParaPoderUsarse() {
        Criadero c = new Criadero(4);
        c.pasarTurno();
        c.pasarTurno();
        c.pasarTurno();
        c.pasarTurno();

        Executable task = () -> {
            c.engendrar();
        };

        assertDoesNotThrow(task);
    }
     */
}
