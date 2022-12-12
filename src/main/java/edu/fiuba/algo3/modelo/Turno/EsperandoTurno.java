package edu.fiuba.algo3.modelo.Turno;

import edu.fiuba.algo3.modelo.Partida.Jugador;

public class EsperandoTurno extends CondicionTurno {

    public EsperandoTurno(Jugador jugador){ super(jugador);}

    public void cambioDeTurno(){
        this.jugador.iniciarTurno();
    }
    public boolean estoyJugando(){
        return false;
    }
}
