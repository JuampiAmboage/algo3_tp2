package edu.fiuba.algo3.modelo;

public class Partida {
    private Mapa mapa;
    private Turno turno;
    private Jugador jugador_uno;
    private Jugador jugador_dos;

    public Partida(int tamanio_del_mapa, String[] nombre_de_los_jugadores) {
        this.mapa = new Mapa(tamanio_del_mapa);
        this.turno = new Turno();

        //this.jugador_uno = new Jugador(nombre_de_los_jugadores[0]);
        //this.jugador_dos = new Jugador(nombre_de_los_jugadores[1]);
    }
}
