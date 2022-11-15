package edu.fiuba.algo3.modelo.Edificios;

import edu.fiuba.algo3.modelo.Celdas.Celda;

public class Asimilador extends Edificio {

    public Asimilador(){
        this.nombre = "asimilador";
        tiempoDeConstruccion = 6;
    }

    @Override
    public void construir_en(Celda celda) {

    }
    @Override
    public void pasarTurno(){
        if(!estaConstruido)
            controlEstadoConstruccion();
        //esto de abajo iria como else? (no extrae si no esta construido)
        extraerGas();
    }

    public String nombre(){
        return this.nombre;
    }

    public int extraerGas(){
        return 20;
    }
}
