package edu.fiuba.algo3.modelo.Razas;

import edu.fiuba.algo3.modelo.Raza;
import edu.fiuba.algo3.modelo.vida.Vida;

public class Zangano extends Raza {


    public Zangano(){
        costoEnGas = 0;
        costoEnMinerales = 25;
        vida = new Vida(25);

    }
    @Override
    public void pasarTurno(){vida.pasarTurno();}

}
