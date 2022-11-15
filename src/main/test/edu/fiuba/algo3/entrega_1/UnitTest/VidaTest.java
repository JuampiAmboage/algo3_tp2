package edu.fiuba.algo3.entrega_1.UnitTest;

import edu.fiuba.algo3.modelo.vida.Vida;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VidaTest {

    @Test
    public void laVidaSeCreaCorrectamenteConUnaCantidadInicial() {
        int vidaEsperada = 500;
        Vida v = new Vida(vidaEsperada);
        assertEquals(vidaEsperada, v.getVidaActual());
    }

    @Test
    public void laVidaRecibeUnAtaqueYDisminuyeSuValor() {
        int vidaTotal = 500;
        int ataque = 50;
        Vida v = new Vida(vidaTotal);
        v.recibirAtaque(ataque);
        assertEquals(vidaTotal - ataque, v.getVidaActual());
    }

    @Test
    public void laVidaRecibeUnAtaqueYAlPasarTurnoSeRegeneraElPorcentajeEstablecido() {
        int vidaTotal = 500;
        int ataque = 200;
        int regeneracion = 50;
        Vida v = new Vida(vidaTotal);
        v.recibirAtaque(ataque);
        v.pasarTurno();
        assertEquals(vidaTotal - ataque + regeneracion, v.getVidaActual());
    }

    @Test
    public void laVidaRecibeUnAtaqueYAlPasarTurnoDosVecesSeRegeneraDosVeces() {
        int vidaTotal = 500;
        int ataque = 200;
        int regeneracion = 50;
        Vida v = new Vida(vidaTotal);
        v.recibirAtaque(ataque);
        v.pasarTurno();
        v.pasarTurno();
        assertEquals(vidaTotal - ataque + regeneracion + regeneracion, v.getVidaActual());
    }

    @Test
    public void laVidaNoSeRegeneraSiNoEsDañadaYPasaTurno() {
        int vidaTotal = 500;
        Vida v = new Vida(vidaTotal);
        v.pasarTurno();
        assertEquals(vidaTotal, v.getVidaActual());
    }

    @Test
    public void laVidaAlLlegarACeroNoSeRegeneraSiPasaTurno() {
        int vidaTotal = 500;
        Vida v = new Vida(vidaTotal);
        v.recibirAtaque(vidaTotal);
        v.pasarTurno();
        assertEquals(0, v.getVidaActual());
    }

    @Test
    public void alRecibirUnAtaqueMayorALaVidaNoTengoVidaNegativa() {
        int vidaTotal = 500;
        int ataqueDevastador = vidaTotal * 5;
        Vida v = new Vida(vidaTotal);
        v.recibirAtaque(ataqueDevastador);
        assertEquals(0, v.getVidaActual());
    }

    @Test
    public void laVidaRecibeUnAtaqueLuegoSeRegeneraYLuegoRecibeOtroAtaqueCorrectamente() {
        int vidaTotal = 500;
        int ataque = 200;
        int regeneracion = 50;
        Vida v = new Vida(vidaTotal);
        v.recibirAtaque(ataque);
        v.pasarTurno();
        v.recibirAtaque(ataque);
        assertEquals(vidaTotal-ataque+regeneracion-ataque, v.getVidaActual());
    }
}
