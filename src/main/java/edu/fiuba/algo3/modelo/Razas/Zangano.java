package edu.fiuba.algo3.modelo.Razas;

import edu.fiuba.algo3.modelo.Edificios.Extractor;
import edu.fiuba.algo3.modelo.Salud.Vida;

public class Zangano extends Unidad {
    Extractor extractorDondeTrabaja;

    public Zangano(){
        costoEnGas = 0;
        costoEnMinerales = 25;
        tiempoConstruccion = 1;
        vida = new Vida(25);

    }
    @Override
    public void pasarTurno(){vida.pasarTurno();}

    public void realizarAccionesTurno(){}
    public void asignarTrabajo(Extractor extractorQueContrata){
        extractorDondeTrabaja = extractorQueContrata;
    }

    public void revisarEstadoLaboral(){
        if(extractorDondeTrabaja != null) {
            throw new RuntimeException();
            //throw new ZanganoLaburando, no lo podes eliminar
        }
    }
}
