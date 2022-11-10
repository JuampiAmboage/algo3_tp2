package edu.fiuba.algo3.entrega_1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestCase03 {
    /*
    // Verificar que solo Asimilador y extractor se puedan construir sobre el gas

    @Test
    public void noSePuedeCrearUnCriaderoEnUnVolcan() {
        Volcan v = new Volcan();
        Criadero c = new Criadero();
        Executable task = () -> {
            v.ocupar(c);
        };

        assertThrows(RuntimeException.class, task);
    }

    @Test
    public void sePuedeCrearUnAsimiladorSobreUnVolcan() {
        Volcan v = new Volcan();
        Executable task = () -> {
            //v.ocupar(new Asimilador());
        };

        assertDoesNotThrow(task);
    }

    @Test
    public void sePuedeConstruirUnExtractorSobreUnVolcan() {
        Volcan v = new Volcan();
        Executable task = () -> {
            //v.construir(new Extractor());
        };

        assertDoesNotThrow(task);
    }

     */
}
