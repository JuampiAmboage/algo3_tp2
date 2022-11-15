package edu.fiuba.algo3.entrega_1.TestCase;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Edificios.Asimilador;
import edu.fiuba.algo3.modelo.Edificios.Extractor;
import edu.fiuba.algo3.modelo.Recursos.Volcan;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestCase16 {
    @Test
    public void caso16() {
        //Verificar que no se pueda construir sobre un volcán con una edificación ya existente
        Celda celda = new Celda();
        Volcan volcan = new Volcan();
        Extractor extractor = new Extractor();
        Asimilador asimilador = new Asimilador();

        celda.agregarRecurso(volcan);
        celda.ocupar(extractor);

        assertThrows(IllegalArgumentException.class, () -> celda.ocupar(asimilador));
    }
}
