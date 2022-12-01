package edu.fiuba.algo3.modelo.Partida;

import edu.fiuba.algo3.modelo.Razas.Unidad;

public class Partida {
    private Mapa mapa;
    private Turno turno;
    private Jugador primerJugador;
    private Jugador segundoJugador;

    public Partida(int dimensionFilasMapa,int dimensionColumnasMapa) {
        this.mapa = Mapa.getInstance();
        this.mapa.instanciarMapa(dimensionFilasMapa,dimensionFilasMapa);
        this.turno = new Turno();
    }

    public void agregarJugador(String nombreJugador, String color, Unidad[] razas){
        if(primerJugador != null)
            primerJugador = new Jugador(nombreJugador,razas);
        else
            segundoJugador = new Jugador(nombreJugador,razas);
    }




}
