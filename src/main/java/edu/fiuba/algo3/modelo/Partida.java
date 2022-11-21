package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Mapa;

public class Partida {
    private Mapa mapa;
    private Turno turno;
    private Jugador primerJugador;
    private Jugador segundoJugador;

    public Partida(int dimensionMapa) {
        this.mapa = new Mapa();
        this.mapa.instanciarMapa(dimensionMapa);
        this.turno = new Turno();
    }

    public void agregarJugador(String nombreJugador, String color,Racita[] razas){
        if(primerJugador != null)
            primerJugador = new Jugador(nombreJugador,razas);
        else
            segundoJugador = new Jugador(nombreJugador,razas);
    }




}
