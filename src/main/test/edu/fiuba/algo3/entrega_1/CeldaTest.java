package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Celdas.CeldaConMoho;
import edu.fiuba.algo3.modelo.Celdas.CeldaLibre;
import edu.fiuba.algo3.modelo.Comunidad.Zangano;
import edu.fiuba.algo3.modelo.Mapa;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CeldaTest {
    @Test
    public void unaCeldaSeCreaDelTipoCeldaLibre() {
        Celda c = new Celda();
        assertTrue(c.esMismoTipo(new CeldaLibre(c)));
    }

    @Test
    public void unaCeldaSeCreaDesocupada() {
        Celda c = new Celda();
        assertFalse(c.estaOcupada());
    }

    /*@Test
    public void unaCeldaSePuedeOcupar() {
        Celda c = new Celda();
        c.ocupar(new Zangano());
        assertTrue(c.estaOcupada());
    }*/

    @Test
    public void unaCeldaSePuedeCambiarAlTipoCeldaConMoho() {
        Celda c = new Celda();
        c.cambiarTipo(new CeldaConMoho(c));
        assertTrue(c.esMismoTipo(new CeldaConMoho(c)));
    }

    @Test
    public void unaCeldaConMohoInfectaASusCeldasAdyacentes() {
        Mapa m = Mapa.getInstance();
        m.instanciarMapa(3);
        Celda c = m.obtenerCelda(1,1);
        c.cambiarTipo(new CeldaConMoho(c));
        c.pasarTurno(); // todo esto lo debería hacer Mapa, y bajar en cascada
        // Todas las celdas del mapa deberían tener moho
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertTrue(m.obtenerCelda(i,j).esMismoTipo(new CeldaConMoho(c)));
            }
        }
    }

    /*@Test
    public void elMohoNoSeExpandeSobreCeldasOcupadas() {
        Mapa m = Mapa.getInstance();
        m.instanciarMapa(3);
        Celda c0 = m.obtenerCelda(0,0);
        Celda c1 = m.obtenerCelda(1,1);

        c0.ocupar(new Zangano());
        c1.cambiarTipo(new CeldaConMoho(c1));
        c1.pasarTurno();

        assertFalse(c0.esMismoTipo(new CeldaConMoho(c1)));
    }*/

    @Test
    public void unaCeldaSePuedeOcuparYDesocuparCorrectamente() {
        Celda c = new Celda();
        //c.ocupar(new Zangano());
        c.desocupar();
        assertFalse(c.estaOcupada());
    }


}
