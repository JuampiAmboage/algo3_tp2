package edu.fiuba.algo3.modelo.Partida;

public class EsperandoTurno extends CondicionTurno{

    public EsperandoTurno(Jugador jugador){ super(jugador);}

    public void cambioDeTurno(){
        this.jugador.iniciarTurno();
    }
    public boolean estoyJugando(){
        return false;
    }
}
