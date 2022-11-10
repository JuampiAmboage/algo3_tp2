package edu.fiuba.algo3.modelo.Criadero;

import edu.fiuba.algo3.modelo.MiembroRaza.MiembroRaza;

public class Criadero extends MiembroRaza {
    private int cantidadLarvas;
    private int turnosDeEspera;

    public Criadero(){
        this.cantidadLarvas = 3;
    }

    public Criadero(int turnos) {
        this.turnosDeEspera = turnos;
        this.cantidadLarvas = 3;
    }


    public int cantidadLarvas() {
        return this.cantidadLarvas;
    }
    public void engendrar() {
        this.cantidadLarvas -= 1;
    }
    public void pasarTurno() {
        this.cantidadLarvas += 1;
    }
}
