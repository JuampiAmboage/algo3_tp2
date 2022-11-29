package edu.fiuba.algo3.entrega_1.TestCase;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Celdas.CeldaConMoho;
import edu.fiuba.algo3.modelo.Excepciones.ConstruccionProhibida;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import edu.fiuba.algo3.modelo.Recursos.Volcan;
import edu.fiuba.algo3.modelo.Edificios.*;

import static org.junit.jupiter.api.Assertions.*;

public class TestCase03 {
    // Verificar que solo Asimilador y extractor se puedan construir sobre el gas

    @Test
    public void noSePuedeCrearUnCriaderoEnUnVolcan() {
        Celda celda = new Celda(new Volcan(), new CeldaConMoho(), new Posicion(0,0));
        Criadero criadero = new Criadero();

        Executable construir = () -> {
            criadero.construirSobre(celda);
        };

        assertThrows(ConstruccionProhibida.class, construir);
    }

    @Test
    public void sePuedeCrearUnAsimiladorSobreUnVolcan() {
        Celda celda = new Celda(new Volcan(), new CeldaConMoho(), new Posicion(0,0));
        Asimilador asimilador = new Asimilador();

        Executable construir = () -> {
            asimilador.construirSobre(celda);
        };

        assertDoesNotThrow(construir);
    }

    @Test
    public void sePuedeConstruirUnExtractorSobreUnVolcan() {
        Celda celda = new Celda(new Volcan(), new CeldaConMoho(), new Posicion(0,0));
        Extractor extractor = new Extractor();

        Executable construir = () -> {
            extractor.construirSobre(celda);
        };

        assertDoesNotThrow(construir);
    }

}
