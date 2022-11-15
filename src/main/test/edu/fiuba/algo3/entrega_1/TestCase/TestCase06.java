package edu.fiuba.algo3.entrega_1.TestCase;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Celdas.CeldaConMoho;
import edu.fiuba.algo3.modelo.Mapa;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestCase06 {

    // Caso de uso #6: Verificar el crecimiento del moho acorde a lo estipulado.
    @Test
    public void unaCeldaConMohoInfectaASusCeldasAdyacentesPasados2Turnos() {
        Mapa m = Mapa.getInstance();
        m.instanciarMapa(3);
        Celda centro = m.obtenerCelda(1,1);
        centro.cambiarTipo(new CeldaConMoho(centro));
        m.pasarTurno();
        m.pasarTurno();
        // todas las celdas del mapa deberían tener moho
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertTrue(m.obtenerCelda(i,j).esMismoTipo(new CeldaConMoho(centro)));
            }
        }
    }
    @Test
    public void unaCeldaConMohoNoInfectaASusCeldasAdyacentesSiPasa1Turno() {
        Mapa m = Mapa.getInstance();
        m.instanciarMapa(3);
        Celda centro = m.obtenerCelda(1,1);
        centro.cambiarTipo(new CeldaConMoho(centro));
        m.pasarTurno();
        // solo la celda del centro debería tener moho
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 1 && j == 1) {
                    assertTrue(m.obtenerCelda(i,j).esMismoTipo(new CeldaConMoho(centro)));
                } else {
                    assertFalse(m.obtenerCelda(i, j).esMismoTipo(new CeldaConMoho(centro)));
                }
            }
        }
    }
    @Test
    public void unMapaDe5x5EsTotalmenteInfectadoAlPasar4Turnos() {
        Mapa m = Mapa.getInstance();
        m.instanciarMapa(5);
        Celda centro = m.obtenerCelda(2,2);
        centro.cambiarTipo(new CeldaConMoho(centro));
        m.pasarTurno();
        m.pasarTurno();
        m.pasarTurno();
        m.pasarTurno();
        // todas las celdas del mapa deberían tener moho
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                assertTrue(m.obtenerCelda(i,j).esMismoTipo(new CeldaConMoho(centro)));
            }
        }
    }
    @Test
    public void unaCeldaInfectadaSoloInfectaASusAdyacentesPasados2Turnos() {
        Mapa m = Mapa.getInstance();
        m.instanciarMapa(5);
        Celda centro = m.obtenerCelda(2,2);
        centro.cambiarTipo(new CeldaConMoho(centro));
        m.pasarTurno();
        m.pasarTurno();
        // solo las celdas alrededor del centro tienen moho
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (i >= 1 && i <= 3 && j >= 1 && j <= 3) {
                    assertTrue(m.obtenerCelda(i,j).esMismoTipo(new CeldaConMoho(centro)));
                } else {
                    assertFalse(m.obtenerCelda(i,j).esMismoTipo(new CeldaConMoho(centro)));
                }

            }
        }
    }
}
