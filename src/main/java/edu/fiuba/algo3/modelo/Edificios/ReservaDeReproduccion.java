package edu.fiuba.algo3.modelo.Edificios;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.vida.Vida;

public class ReservaDeReproduccion extends Edificio{

    public ReservaDeReproduccion(){
        tiempoDeConstruccion = 12;
        vida = new Vida(1000);
    }
    @Override
    public void construirEn(Celda celda) {
        celda.ocupar(this);
    }
    @Override
    public void pasarTurno(){
        if(!estaConstruido)
            controlEstadoConstruccion();
        else{
            vida.pasarTurno();
        }
    }
}
