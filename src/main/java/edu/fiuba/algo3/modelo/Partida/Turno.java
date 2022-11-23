package edu.fiuba.algo3.modelo.Partida;

public class Turno {
    private int contadorDeTurnos;
    private Jugador jugador;

    public Turno(){
        this.contadorDeTurnos = 0;
    }


    public void pasar_turno(){
        this.contadorDeTurnos++;
    }
}
