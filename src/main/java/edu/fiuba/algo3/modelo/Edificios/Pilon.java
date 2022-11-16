package edu.fiuba.algo3.modelo.Edificios;

import edu.fiuba.algo3.modelo.Celdas.*;
import edu.fiuba.algo3.modelo.vida.VidaConEscudo;

public class Pilon extends Edificio {

    public Pilon(){
        this.nombre = "pilon";
        tiempoDeConstruccion = 5;
        vida = new VidaConEscudo(300,300);
    }
    @Override
    public void construirEn(Celda celda) {

    }
    @Override
    public void pasarTurno(){
        if(!estaConstruido)
            controlEstadoConstruccion();
        vida.pasarTurno();
    }
    public int obtenerEscudo(){ return vida.getEscudoActual();}

}
