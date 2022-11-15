package edu.fiuba.algo3.entrega_1.TestCase;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import edu.fiuba.algo3.modelo.Recursos.Volcan;
import edu.fiuba.algo3.modelo.Edificios.*;

import static org.junit.jupiter.api.Assertions.*;

public class TestCase03 {
    // Verificar que solo Asimilador y extractor se puedan construir sobre el gas

    @Test
    public void noSePuedeCrearUnCriaderoEnUnVolcan() {
        Volcan v = new Volcan();

        assertFalse(v.ocupar_con(new Criadero()));

    }

    @Test
    public void sePuedeCrearUnAsimiladorSobreUnVolcan() {
        Volcan v = new Volcan();

        assertTrue(v.ocupar_con(new Asimilador()));
    }

    @Test
    public void sePuedeConstruirUnExtractorSobreUnVolcan() {
        Volcan v = new Volcan();

        assertTrue(v.ocupar_con(new Extractor()));
    }

}
