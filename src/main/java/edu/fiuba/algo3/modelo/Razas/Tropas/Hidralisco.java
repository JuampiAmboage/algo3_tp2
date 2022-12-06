package edu.fiuba.algo3.modelo.Razas.Tropas;

import edu.fiuba.algo3.modelo.Comunidad.ComunidadZerg;
import edu.fiuba.algo3.modelo.Salud.Vida;

public class Hidralisco extends Tropa implements TropaTerrestre{
    public Hidralisco(){
        ataque = new AtacarTierraYAire();
        superficie = "tierra";
        costoEnMinerales = 75;
        costoEnGas = 25;
        tiempoConstruccion = 4;
        danioTerrestre = 10;
        danioAereo = 10;
        suministro = 2;
        vida = new Vida(80);
        ComunidadZerg.obtenerInstanciaDeClase().aniadirSuministro(suministro);
    }
    public void realizarAccionesTurno(){}

    @Override
    public void pasarTurno() {
        vida.pasarTurno();
    }
}
