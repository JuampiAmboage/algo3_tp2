package edu.fiuba.algo3.modelo.Edificios;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.vida.Vida;
import edu.fiuba.algo3.modelo.vida.VidaConEscudo;

public class Espiral extends Edificio {
    public Espiral(){
        tiempoDeConstruccion = 10;
        vida = new Vida(1300);
    }

    public void construir_en(Celda celda) {
        if (Guarida.existeAlMenosUnaInstancia()){
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
