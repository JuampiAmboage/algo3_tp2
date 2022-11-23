package edu.fiuba.algo3.modelo.Salud;

public class Vida extends Salud{
    public Vida(int vidaMaxima) {
      regenerable = new Regenerable(vidaMaxima);
    }

    public boolean estaSinVida() {
        return this.regenerable.getVidaActual() <= 0;
    }
    public void pasarTurno(){
        if (estaSinVida()) return;
        this.regenerable.regenerar(10);
    }
    public void recibirAtaque(int ataque) {
        if (estaSinVida()) return;
        this.regenerable.recibirAtaque(ataque);
    }

    public int getVidaActual(){
        return regenerable.getVidaActual();
    }

    public int getEscudoActual(){
        return 0;
    }
}