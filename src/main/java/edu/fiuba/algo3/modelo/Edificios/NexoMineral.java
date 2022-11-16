package edu.fiuba.algo3.modelo.Edificios;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.vida.VidaConEscudo;

public class NexoMineral extends Edificio{

    public NexoMineral(){
        tiempoDeConstruccion = 4;
        vida = new VidaConEscudo(250,250);
    }
    @Override
    public void construir_en(Celda celda) {
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
    public int obtenerEscudo(){ return vida.getEscudoActual();}
}
