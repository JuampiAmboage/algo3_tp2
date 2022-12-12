package edu.fiuba.algo3.modelo.Turno;

import edu.fiuba.algo3.modelo.Partida.Jugador;

public class Jugando extends CondicionTurno {

    public Jugando(Jugador jugador){ super(jugador);}

    public void cambioDeTurno(){
        this.jugador.terminarTurno();
    }

    public boolean estoyJugando(){
        return true;
    }
}
