package edu.fiuba.algo3.modelo.Salud;

import edu.fiuba.algo3.modelo.Comunidad.Comunidad;

public abstract class Salud {
    protected Regenerable regenerable;
    protected Comunidad comunidad;
    public abstract boolean estaSinVida();

    public void pasarTurno() {
        regenerable.regenerar(10);
    }
    public abstract void recibirAtaque(int ataque);
    public abstract int getVidaActual();
    public abstract int getEscudoActual();

}
