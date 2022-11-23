package edu.fiuba.algo3.modelo.Salud;

public class VidaConEscudo extends Salud {

    private final int vidaMaxima;
    private int vidaActual;

    public VidaConEscudo(int vidaMaxima, int escudoMaximo) {
        this.vidaMaxima = vidaMaxima;
        this.vidaActual = this.vidaMaxima;
        this.regenerable = new Regenerable(escudoMaximo);
    }

    public boolean estaSinVida() {
        return this.vidaActual <= 0;
    }

    public void pasarTurno() {
        if (estaSinVida()) return;
        // regenerar la vida
        regenerable.regenerar(10);
    }

    public void recibirAtaque(int ataque) {
        if (this.estaSinVida()) return;
        int ataqueRestante = this.regenerable.recibirAtaque(ataque);
        if (ataqueRestante > 0) {
            this.vidaActual -= ataqueRestante;
        }
        if (this.vidaActual < 0) {
            this.vidaActual = 0;
        }
    }

    public int getVidaActual() {
        return this.vidaActual;
    }

    public int getEscudoActual() {
        return regenerable.getVidaActual();
    }
}
