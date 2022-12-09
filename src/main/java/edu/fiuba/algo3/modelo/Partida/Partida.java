package edu.fiuba.algo3.modelo.Partida;

import edu.fiuba.algo3.modelo.Comunidad.Comunidad;
import edu.fiuba.algo3.modelo.Edificios.Edificio;
public class Partida {

    private final int DIMENSION_FILAS_MAPA = 8;
    private final int DIMENSION_COLUMNAS_MAPA = 8;
    private Mapa mapa;
    private Turno turno;
    private Jugador primerJugador;
    private Jugador segundoJugador;

    public Partida() {
        this.mapa = Mapa.getInstance();
        this.mapa.instanciarMapa(this.DIMENSION_FILAS_MAPA, this.DIMENSION_COLUMNAS_MAPA);
        this.turno = new Turno();
    }

    public void agregarJugadores(String[] nombreJugador, Comunidad[] comunidades){
        this.primerJugador = new Jugador(nombreJugador[0], comunidades[0]);
        this.segundoJugador = new Jugador(nombreJugador[1], comunidades[1]);
    }




}
