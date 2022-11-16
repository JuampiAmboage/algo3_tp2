package edu.fiuba.algo3.modelo.Edificios;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.vida.VidaConEscudo;

import java.util.concurrent.atomic.AtomicInteger;

public class PuertaEstelar extends Edificio{

    public PuertaEstelar(){
        tiempoDeConstruccion = 10;
        vida = new VidaConEscudo(600,600);
    }

    public void construirEn(Celda celda) {
        if (Acceso.existeAlMenosUnaInstancia()){
            celda.ocupar(this);
        }
        else{
            throw new RuntimeException("Requiere un acceso para ser construido.");
        }
    }

    public void pasarTurno(){
        if(!estaConstruido)
            controlEstadoConstruccion();
        else{
            vida.pasarTurno();
        }
    }
}
