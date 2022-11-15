package edu.fiuba.algo3.modelo.Edificios;

import edu.fiuba.algo3.modelo.Celdas.*;
import edu.fiuba.algo3.modelo.vida.VidaConEscudo;

public class Pilon extends Edificio {
    VidaConEscudo vida;

    public Pilon(){
        this.nombre = "pilon";
        tiempoDeConstruccion = 5;
        vida = new VidaConEscudo(300,300);
    }
    @Override
    public void construir_en(Celda celda) {

    }
    @Override
    public void pasarTurno(){
        if(!estaConstruido)
            controlEstadoConstruccion();
        vida.pasarTurno();
    }

    public void daniarEdificio(int puntosAtaque){
        vida.recibirAtaque(puntosAtaque);
    }

    public int obtenerVida(){return vida.getVidaActual();}

    public int obtenerEscudo(){ return vida.getEscudoActual();}

}
