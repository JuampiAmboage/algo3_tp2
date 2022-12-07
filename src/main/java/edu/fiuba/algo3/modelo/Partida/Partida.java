package edu.fiuba.algo3.modelo.Partida;

import edu.fiuba.algo3.modelo.Edificios.Edificio;
public class Partida {
    private Mapa mapa;
    private Turno turno;
    private Jugador primerJugador;
    private Jugador segundoJugador;

    private int dimensionFilasMapa;
    private int dimensionColumnasMapa;

    public Partida() {
        this.mapa = Mapa.getInstance();
        this.mapa.instanciarMapa(this.dimensionFilasMapa, this.dimensionFilasMapa);
        this.turno = new Turno();
    }

    public void agregarJugadores(String[] nombreJugador, Edificio[] edificios){
        primerJugador = new Jugador(nombreJugador[0], edificios[0]);
        segundoJugador = new Jugador(nombreJugador[1], edificios[1]);
    }




}
