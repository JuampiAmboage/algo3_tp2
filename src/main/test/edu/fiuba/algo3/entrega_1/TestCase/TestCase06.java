package edu.fiuba.algo3.entrega_1.TestCase;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Celdas.CeldaConMoho;
import edu.fiuba.algo3.modelo.Partida.Mapa;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestCase06 {

    // Caso de uso #6: Verificar el crecimiento del moho acorde a lo estipulado.
    @Test
    public void cuandoInfectoUnaCeldaConMohoYPasanDosTurnosLasCeldasAdyacentesSeInfectaron() {
        Mapa mapa = Mapa.getInstance();
        mapa.instanciarMapa();
        Celda centro = mapa.obtenerCelda(new Posicion(1,1));
        centro.cambiarTipo(new CeldaConMoho(centro));

        Mapa.getInstance().pasarTurno();
        Mapa.getInstance().pasarTurno();

        Celda izquierda = mapa.obtenerCelda(new Posicion(0,1));
        Celda arriba = mapa.obtenerCelda(new Posicion(1,0));
        Celda derecha = mapa.obtenerCelda(new Posicion(2,1));
        Celda abajo = mapa.obtenerCelda(new Posicion(1,2));
        assertTrue(izquierda.esMismoTipo(new CeldaConMoho(izquierda)));
        assertTrue(arriba.esMismoTipo(new CeldaConMoho(arriba)));
        assertTrue(derecha.esMismoTipo(new CeldaConMoho(derecha)));
        assertTrue(abajo.esMismoTipo(new CeldaConMoho(abajo)));

    }

    @Test
    public void unMapaDe5x5EsTotalmenteInfectadoAlPasar25Turnos() {
        Mapa mapa = Mapa.getInstance();
        mapa.instanciarMapa();
        Celda centro = mapa.obtenerCelda(new Posicion(2,2));
        centro.cambiarTipo(new CeldaConMoho(centro));
        for(int i=0;i<25;i++){
                mapa.pasarTurno();
        }
        // todas las celdas del mapa deberían tener moho
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                assertTrue(mapa.obtenerCelda(new Posicion(i,j)).esMismoTipo(new CeldaConMoho(centro)));
            }
        }
    }

}
