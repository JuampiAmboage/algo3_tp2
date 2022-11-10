package edu.fiuba.algo3.modelo.vida;

public class Vida {

    Regenerable vida;
    public Vida(int vidaMaxima) {
      vida = new Regenerable(vidaMaxima);
    }

    public void pasarTurno(){
        this.vida.regenerar(10);
    }
    public void recibirAtaque(int ataque) {
        this.vida.recibirAtaque(ataque);
    }
}