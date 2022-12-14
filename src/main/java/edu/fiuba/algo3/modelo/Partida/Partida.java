package edu.fiuba.algo3.modelo.Partida;

import edu.fiuba.algo3.App;
import edu.fiuba.algo3.modelo.Comunidad.Comunidad;
public class Partida {


    private Mapa mapa;

    private App app;
    private Jugador primerJugador;
    private Jugador segundoJugador;
    public Partida(String[] nombreJugadores, Comunidad[] comunidades) {
        this.mapa = Mapa.getInstance();
        this.mapa.instanciarMapa();
        agregarJugadores(nombreJugadores, comunidades);
        this.mapa.generarRecursos();
    }

    private void agregarJugadores(String[] nombreJugadores, Comunidad[] comunidades){
        this.primerJugador = new Jugador(nombreJugadores[0], comunidades[0]);
        this.segundoJugador = new Jugador(nombreJugadores[1], comunidades[1]);
        this.primerJugador.introducirEnPartida(this);
        this.segundoJugador.introducirEnPartida(this);
        this.primerJugador.iniciarTurno();
        this.segundoJugador.mandarAEspera();
    }

    public void finDeTurno(){
        mapa.getInstance().pasarTurno();
        primerJugador.cambioCondicionTurno();
        segundoJugador.cambioCondicionTurno();
    }

    public int quienJuega(){
        if(primerJugador.esSuTurno())
            return 1;
        else
            return 0;
    }

    public void finDePartida(){
        if(quienJuega() == 1)
            this.app.terminarPartida(primerJugador.obtenerNombre());
        else
            this.app.terminarPartida(segundoJugador.obtenerNombre());
    }

    public int[] obtenerAlmacenamiento(int jugador) {
        if (jugador != 1) {
            return this.segundoJugador.obtenerAlmacenamiento();
        }

        return this.primerJugador.obtenerAlmacenamiento();
    }

    public void establecerApp(App app) { this.app = app; }

}
