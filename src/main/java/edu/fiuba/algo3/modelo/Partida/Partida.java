package edu.fiuba.algo3.modelo.Partida;

import edu.fiuba.algo3.modelo.Comunidad.Comunidad;
import edu.fiuba.algo3.modelo.Edificios.Edificio;
public class Partida {

    private Mapa mapa;
    private Jugador primerJugador;
    private Jugador segundoJugador;
    public Partida(String[] nombreJugadores, Comunidad[] comunidades) {
        this.mapa = Mapa.getInstance();
        this.mapa.instanciarMapa();
        agregarJugadores(nombreJugadores, comunidades);
    }

    private void agregarJugadores(String[] nombreJugadores, Comunidad[] comunidades){
        this.primerJugador = new Jugador(nombreJugadores[0], comunidades[0]);
        this.segundoJugador = new Jugador(nombreJugadores[1], comunidades[1]);
        this.primerJugador.iniciarTurno();
        this.segundoJugador.mandarAEspera();
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


    public int mostrarMenu(){
        if (quienJuega() == primerJugador)
            return 1;
        return 0;
    }

}
