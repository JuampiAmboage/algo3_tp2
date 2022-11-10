package edu.fiuba.algo3.modelo.vida;

public class Vida {

    Regenerable vida;
    public Vida(int vidaMaxima) {
      vida = new Regenerable(vidaMaxima);
    }

    public boolean estaSinVida() {
        return this.vida.getVidaActual() <= 0;
    }
    public void pasarTurno(){
        if (estaSinVida()) return;
        this.vida.regenerar(10);
    }
    public void recibirAtaque(int ataque) {
        if (estaSinVida()) return;
        this.vida.recibirAtaque(ataque);
    }

    public int getVidaActual(){
        return vida.getVidaActual();
    }
}