package edu.fiuba.algo3.modelo.Edificios;

import edu.fiuba.algo3.modelo.Celdas.Celda;

public class Asimilador extends Edificio {

    public Asimilador(){
        this.nombre = "asimilador";
    }

    @Override
    public void construir_en(Celda celda) {

    }
    @Override
    public void pasarTurno(){

    }

    public String nombre(){
        return this.nombre;
    }
}
