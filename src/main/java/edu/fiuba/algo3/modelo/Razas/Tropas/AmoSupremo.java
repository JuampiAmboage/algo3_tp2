package edu.fiuba.algo3.modelo.Razas.Tropas;

import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Salud.Vida;

public class AmoSupremo extends Tropa {
    public AmoSupremo(){
        ataque = new AtacarAire();
        superficie = "tierra";
        costoEnMinerales = 50;
        costoEnGas = 0;
        tiempoConstruccion = 5;
        danioTerrestre = 0;
        danioAereo = 0;
        vida = new Vida(200);
    }

    public void instanciacionInicial(Posicion posicionALocalizar){
        posicion = posicionALocalizar;
    }
    @Override
    public void pasarTurno() {
        vida.pasarTurno();
    }
}
