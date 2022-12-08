package edu.fiuba.algo3.entrega_1.TestCase;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Celdas.CeldaEnergizada;
import edu.fiuba.algo3.modelo.Edificios.Asimilador;
import edu.fiuba.algo3.modelo.Edificios.Extractor;
import edu.fiuba.algo3.modelo.Edificios.NexoMineral;
import edu.fiuba.algo3.modelo.Excepciones.CeldaOcupada;
import edu.fiuba.algo3.modelo.Recursos.Volcan;
import edu.fiuba.algo3.modelo.Razas.Tropas.Dragon;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestCase16 {
    @Test
    public void noSePuedeConstruirSobreUnVolcanConUnEdificioExistente() {
        Celda celda = new Celda(0,0);
        Volcan volcan = new Volcan();
        Extractor extractor = new Extractor();
        Asimilador asimilador = new Asimilador();

        celda.agregarRecurso(volcan);
        celda.ocuparPorTierra(extractor);

        assertThrows(CeldaOcupada.class, () -> celda.ocuparPorTierra(asimilador));
    }

    @Test
    public void noSePuedeConstruirUnEdificioDondeHayUnaUnidad() {
        Celda celda = new Celda(0,0);
        CeldaEnergizada energizada = new CeldaEnergizada(celda);
        Dragon dragon = new Dragon();
        NexoMineral nexoMineral = new NexoMineral();

        celda.cambiarTipo(energizada);
        celda.ocuparPorTierra(dragon);

        assertThrows(CeldaOcupada.class, () -> celda.ocuparPorTierra(nexoMineral));
    }

    @Test
    public void noSePuedeTrasladarUnaUnidadDondeHayUnEdificio() {
        Celda celda = new Celda(0,0);
        CeldaEnergizada energizada = new CeldaEnergizada(celda);
        NexoMineral nexoMineral = new NexoMineral();
        Dragon dragon = new Dragon();

        celda.cambiarTipo(energizada);
        celda.ocuparPorTierra(nexoMineral);

        assertThrows(CeldaOcupada.class, () -> celda.ocuparPorTierra(dragon));
    }
}
