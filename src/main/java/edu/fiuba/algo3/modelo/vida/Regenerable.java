package edu.fiuba.algo3.modelo.vida;

public class Regenerable {
    private final int vidaMaxima;
    private int vidaActual;

    public Regenerable(int vidaMaxima) {
        this.vidaMaxima = vidaMaxima;
        this.vidaActual = this.vidaMaxima;
    }

    public boolean tieneVida() {
        return this.vidaActual > 0;
    }

    public void regenerar(int porcentaje) {
        if (!tieneVida()) return;
        int cantidad = vidaMaxima * porcentaje / 100;
        int valorFaltante = this.vidaMaxima - this.vidaActual;
        if (cantidad > valorFaltante) {
            cantidad = valorFaltante;
        }
        this.vidaActual += cantidad;
    }

    public int recibirAtaque(int ataque) {
        if (!tieneVida()) return ataque;
        int ataqueRestante = ataque - this.vidaActual;
        this.vidaActual -= ataque;
        if (vidaActual < 0) {
            this.vidaActual = 0;
        }

        if (ataqueRestante < 0) {
            ataqueRestante = 0;
        }
        return ataqueRestante;
    }
}
