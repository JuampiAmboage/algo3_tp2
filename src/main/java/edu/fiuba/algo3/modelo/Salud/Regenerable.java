package edu.fiuba.algo3.modelo.Salud;

public class Regenerable {
    private final int vidaMaxima;
    private int vidaActual;

    public Regenerable(int vidaMaxima) {
        this.vidaMaxima = vidaMaxima;
        this.vidaActual = this.vidaMaxima;
    }

    public void regenerar(int porcentaje) {
        int cantidad = vidaMaxima * porcentaje / 100;
        int valorFaltante = this.vidaMaxima - this.vidaActual;
        if (cantidad > valorFaltante) {
            cantidad = valorFaltante;
        }
        this.vidaActual += cantidad;
    }

    public boolean estaSinVida() {
        return this.vidaActual <= 0;
    }

    public int recibirAtaque(int ataque) {
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

    public int getVidaActual() {
        return this.vidaActual;
    }
}
