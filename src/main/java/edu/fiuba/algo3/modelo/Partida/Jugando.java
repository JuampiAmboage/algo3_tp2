package edu.fiuba.algo3.modelo.Partida;

public class Jugando extends CondicionTurno{

    public Jugando(Jugador jugador){ super(jugador);}

    public void cambioDeTurno(){
        this.jugador.terminarTurno();
    }

    public boolean estoyJugando(){
        return true;
    }
}
