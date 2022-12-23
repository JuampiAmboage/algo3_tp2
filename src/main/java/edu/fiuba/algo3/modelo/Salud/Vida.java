package edu.fiuba.algo3.modelo.Salud;

public class Vida extends Salud{
    public Vida(int vidaMaxima) {
        this.regenerable = new Regenerable(vidaMaxima);
    }

    public boolean estaSinVida() {
        return this.regenerable.estaSinVida();
    }
    public void pasarTurno(){
        if (estaSinVida()) return;
        this.regenerable.regenerar(10);
    }
    public void recibirAtaque(int ataque) {
        this.regenerable.recibirAtaque(ataque);
    }

    public int getVidaActual(){
        return regenerable.getVidaActual();
    }

    public int getEscudoActual(){
        return 0;
    }
}