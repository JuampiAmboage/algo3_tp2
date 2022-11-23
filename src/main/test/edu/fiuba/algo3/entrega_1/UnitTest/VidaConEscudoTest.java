package edu.fiuba.algo3.entrega_1.UnitTest;

import edu.fiuba.algo3.modelo.Salud.VidaConEscudo;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VidaConEscudoTest {
    @Test
    public void unaVidaConEscudoSeCreaCorrectamente() {
        int vidaMaxima = 500;
        int escudoMaximo = 200;
        VidaConEscudo v = new VidaConEscudo(vidaMaxima, escudoMaximo);

        assertEquals(vidaMaxima, v.getVidaActual());
        assertEquals(escudoMaximo, v.getEscudoActual());
    }

    @Test
    public void unaVidaConEscudoRecibeUnAtaqueDebilYSoloAfectaAlEscudo() {
        int vidaMaxima = 500;
        int escudoMaximo = 200;
        int ataqueDebil = 100;
        VidaConEscudo v = new VidaConEscudo(vidaMaxima, escudoMaximo);
        v.recibirAtaque(ataqueDebil);
        assertEquals(vidaMaxima, v.getVidaActual());
        assertEquals(escudoMaximo - ataqueDebil, v.getEscudoActual());
    }

    @Test
    public void unaVidaConEscudoRecibeUnAtaqueFuerteYAfectaALaVida() {
        int vidaMaxima = 500;
        int escudoMaximo = 200;
        int ataqueFuerte = 300;
        int ataqueRestante = ataqueFuerte - escudoMaximo;
        VidaConEscudo v = new VidaConEscudo(vidaMaxima, escudoMaximo);
        v.recibirAtaque(ataqueFuerte);
        assertEquals(vidaMaxima - ataqueRestante, v.getVidaActual());
        assertEquals(0, v.getEscudoActual());
    }

    @Test
    public void unaVidaConEscudoNoRegeneraEscudoAlPasarTurnoSiNoRecibeUnAtaque() {
        int vidaMaxima = 500;
        int escudoMaximo = 200;
        VidaConEscudo v = new VidaConEscudo(vidaMaxima, escudoMaximo);
        v.pasarTurno();
        assertEquals(vidaMaxima, v.getVidaActual());
        assertEquals(escudoMaximo, v.getEscudoActual());
    }

    @Test
    public void unaVidaConEscudoRegeneraELPorcentajeDeEscudoCorrectoAlRecibirUnAtaqueYPasarTurno() {
        int vidaMaxima = 500;
        int escudoMaximo = 200;
        int regenEscudo = 20; // 10% del escudo total
        int ataque = 100;
        VidaConEscudo v = new VidaConEscudo(vidaMaxima, escudoMaximo);

        v.recibirAtaque(ataque);
        v.pasarTurno();

        assertEquals(vidaMaxima, v.getVidaActual());
        assertEquals(escudoMaximo - ataque + regenEscudo, v.getEscudoActual());
    }

    @Test
    public void unaVcERecibeUnAtaqueFuerteYAlPasarTurnoSoloSeRegeneraElEscudo() {
        int vidaMaxima = 500;
        int escudoMaximo = 200;
        int regenEscudo = 20; // 10% del escudo total
        int ataqueFuerte = 300;
        int ataqueRestante = ataqueFuerte - escudoMaximo;
        VidaConEscudo v = new VidaConEscudo(vidaMaxima, escudoMaximo);

        v.recibirAtaque(ataqueFuerte);
        v.pasarTurno();

        assertEquals(vidaMaxima - ataqueRestante, v.getVidaActual());
        assertEquals(regenEscudo, v.getEscudoActual());
    }

    @Test
    public void unaVcEQueFueAtacadaRecuperaTodoElEscudoPerdidoPasandoLosTurnosAdecuados() {
        int vidaMaxima = 500;
        int escudoMaximo = 200;
        int ataqueFuerte = 300;
        VidaConEscudo v = new VidaConEscudo(vidaMaxima, escudoMaximo);

        v.recibirAtaque(ataqueFuerte);
        for(int i = 0; i < 10; i++) {
            v.pasarTurno();
        }

        assertEquals(escudoMaximo, v.getEscudoActual());
    }

    @Test
    public void unaVcERecibeUnAtaqueFulminanteYNoSeRecuperaAlPasarLosTurnos() {
        int vidaMaxima = 500;
        int escudoMaximo = 200;
        int ataqueFulminante = 700;
        VidaConEscudo v = new VidaConEscudo(vidaMaxima, escudoMaximo);

        v.recibirAtaque(ataqueFulminante);
        for(int i = 0; i < 10; i++) {
            v.pasarTurno();
        }

        assertEquals(0, v.getVidaActual());
        assertEquals(0, v.getEscudoActual());
    }
}
