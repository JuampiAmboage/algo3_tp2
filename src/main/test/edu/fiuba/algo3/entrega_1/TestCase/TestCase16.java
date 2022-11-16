package edu.fiuba.algo3.entrega_1.TestCase;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Celdas.CeldaEnergizada;
import edu.fiuba.algo3.modelo.Edificios.Asimilador;
import edu.fiuba.algo3.modelo.Edificios.Extractor;
import edu.fiuba.algo3.modelo.Recursos.Volcan;
import edu.fiuba.algo3.modelo.Unidades.Dragon;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestCase16 {
    @Test
    public void noSePuedeConstruirSobreUnVolcanConUnEdificioExistente() {
        Celda celda = new Celda();
        Volcan volcan = new Volcan();
        Extractor extractor = new Extractor();
        Asimilador asimilador = new Asimilador();

        celda.agregarRecurso(volcan);
        celda.ocupar(extractor);

        assertThrows(IllegalArgumentException.class, () -> celda.ocupar(asimilador));
    }

    @Test
    public void noSePuedeConstruirUnEdificioDondeHayUnaUnidad() {
        Celda celda = new Celda();
        CeldaEnergizada energizada = new CeldaEnergizada(celda);
        Dragon dragon = new Dragon();
        Asimilador asimilador = new Asimilador();

        celda.cambiarTipo(energizada);
        celda.ocupar(dragon);

        assertThrows(IllegalArgumentException.class, () -> celda.ocupar(asimilador));
    }

    @Test
    public void noSePuedeTrasladarUnaUnidadDondeHayUnEdificio() {
        Celda celda = new Celda();
        CeldaEnergizada energizada = new CeldaEnergizada(celda);
        Asimilador asimilador = new Asimilador();
        Dragon dragon = new Dragon();

        celda.cambiarTipo(energizada);
        celda.ocupar(asimilador);

        assertThrows(IllegalArgumentException.class, () -> celda.ocupar(dragon));
    }
}
