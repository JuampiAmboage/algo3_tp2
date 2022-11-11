package edu.fiuba.algo3.modelo;

public class Turno {
    private int contador_de_turnos;

    public Turno(){
        this.contador_de_turnos = 0;
    }

    public void pasar_turno(){
        this.contador_de_turnos++;
    }
}
