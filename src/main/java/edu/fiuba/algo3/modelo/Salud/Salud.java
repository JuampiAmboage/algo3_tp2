package edu.fiuba.algo3.modelo.Salud;

public abstract class Salud {
    Regenerable regenerable;
    public abstract boolean estaSinVida();

    public void pasarTurno() {
        if (estaSinVida()) return;
        // regenerar la vida
        regenerable.regenerar(10);
    }
    public abstract void recibirAtaque(int ataque);
    public abstract int getVidaActual();
    public abstract int getEscudoActual();

}
