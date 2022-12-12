package edu.fiuba.algo3.modelo.Turno;

import edu.fiuba.algo3.modelo.Partida.Jugador;

public abstract class CondicionTurno {
    protected Jugador jugador;
    public abstract void cambioDeTurno();

    public abstract boolean estoyJugando();

    public CondicionTurno(Jugador jugador){ this.jugador = jugador;}

}
