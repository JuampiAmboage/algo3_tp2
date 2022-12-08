package edu.fiuba.algo3.modelo.Razas.Tropas;

import edu.fiuba.algo3.modelo.Comunidad.ComunidadZerg;
import edu.fiuba.algo3.modelo.Salud.Vida;

public class Guardian extends TropaAerea{
    public Guardian(){
        super();
        ataque = new AtacarTierra();
        costoEnMinerales = 50;
        costoEnGas = 100;
        tiempoConstruccion = 4;
        danioTerrestre = 25;
        danioAereo = 0;
        vida = new Vida(100);
        comunidad = ComunidadZerg.obtenerInstanciaDeClase();
    }
    public void realizarAccionesTurno(){}


    @Override
    public void pasarTurno() {
        vida.pasarTurno();
    }
}
