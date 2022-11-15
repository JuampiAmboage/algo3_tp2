package edu.fiuba.algo3.modelo.Edificios;

import edu.fiuba.algo3.modelo.Celdas.*;

public class Pilon extends Edificio {

    public Pilon(){
        this.nombre = "pilon";
        tiempoDeConstruccion = 5;
    }
    @Override
    public void construir_en(Celda celda) {

    }
    @Override
    public void pasarTurno(){
        if(!estaConstruido)
            controlEstadoConstruccion();
    }

}
