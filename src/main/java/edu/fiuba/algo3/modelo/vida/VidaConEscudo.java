package edu.fiuba.algo3.modelo.vida;

public class VidaConEscudo {

    private final int vidaMaxima;
    private int vidaActual;
    Regenerable escudo;


    public VidaConEscudo(int vidaMaxima, int escudoMaximo) {
        this.vidaMaxima = vidaMaxima;
        this.vidaActual = this.vidaMaxima;
        this.escudo = new Regenerable(escudoMaximo);
    }

    public boolean tieneVida() {
        return this.vidaActual > 0;
    }

    public void pasarTurno() {
        if (!tieneVida()) return;
        // regenerar la vida
        escudo.regenerar(10);
    }

    public void recibirAtaque(int ataque) {
        if (!this.tieneVida()) return;
        int ataqueRestante = this.escudo.recibirAtaque(ataque);
        if (ataqueRestante > 0) {
            this.vidaActual -= ataqueRestante;
        }
        if (this.vidaActual < 0) {
            this.vidaActual = 0;
        }
    }
}
