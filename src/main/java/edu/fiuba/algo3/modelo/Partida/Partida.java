package edu.fiuba.algo3.modelo.Partida;

import edu.fiuba.algo3.modelo.Comunidad.Comunidad;
import edu.fiuba.algo3.modelo.Edificios.Edificio;
public class Partida {

    private Mapa mapa;
    private Turno turno;
    private Jugador primerJugador;
    private Jugador segundoJugador;
    public Partida(String[] nombreJugadores, Comunidad[] comunidades) {
        this.mapa = Mapa.getInstance();
        this.mapa.instanciarMapa();
        this.turno = new Turno();
        agregarJugadores(nombreJugadores, comunidades);
    }

    private void agregarJugadores(String[] nombreJugadores, Comunidad[] comunidades){
        this.primerJugador = new Jugador(nombreJugadores[0], comunidades[0]);
        this.segundoJugador = new Jugador(nombreJugadores[1], comunidades[1]);
        this.primerJugador.iniciarTurno();
    }

    public void finDeTurno(){
        primerJugador.cambioCondicionTurno();
        segundoJugador.cambioCondicionTurno();
    }

    public Jugador quienJuega(){
        if(primerJugador.esSuTurno())
            return primerJugador;
        else
            return segundoJugador;
    }




}
