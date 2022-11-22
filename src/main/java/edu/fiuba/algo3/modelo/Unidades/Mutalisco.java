package edu.fiuba.algo3.modelo.Unidades;

import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Rango.RangoAtaque;
import edu.fiuba.algo3.modelo.Razas.Evolucionador;
import edu.fiuba.algo3.modelo.vida.Vida;

public class Mutalisco extends Tropa {
    Evolucionador evolucionador;
    public Mutalisco(){
        ataque = new AtacarTierraYAire();
        superficie = "aire";
        costoEnMinerales = 75;
        costoEnGas = 25;
        tiempoConstruccion = 4;
        danioTerrestre = 9;
        danioAereo = 9;
        vida = new Vida(80);
    }

    public void instanciacionesIniciales(Posicion posicionALocalizar){
        posicion = posicionALocalizar;
        evolucionador = new Evolucionador();
        rangoAtaque = new RangoAtaque(3,posicion);
    }
    public void evolucionarAGuardian(){
        evolucionador.evolucionarUnidad(this,new Guardian());
    }
    public void evolucionarADevorador(){
        evolucionador.evolucionarUnidad(this,new Devorador());
    }
    @Override
    public void pasarTurno() {
        vida.pasarTurno();
    }
}
