package edu.fiuba.algo3.modelo.Razas;

import edu.fiuba.algo3.modelo.Razas.Tropas.Scout;
import edu.fiuba.algo3.modelo.Razas.Tropas.Tropa;

public class Larva extends Unidad {

    public void Larva() { this.sprite = ""; }
    @Override
    public void pasarTurno(){costoEnGas = 0; costoEnMinerales = 0;}
    public void realizarAccionesTurno(){}
}
