package edu.fiuba.algo3.modelo.Razas.Tropas;

import edu.fiuba.algo3.modelo.Comunidad.ComunidadProtoss;
import edu.fiuba.algo3.modelo.Comunidad.ComunidadZerg;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Salud.Vida;

public class AmoSupremo extends Tropa implements TropaAerea {
    public AmoSupremo(){
        ataque = new AtacarAire();
        vida = new Vida(200);
        ComunidadZerg.obtenerInstanciaDeClase().aniadirSuministro(suministro);
        ComunidadProtoss.obtenerInstanciaDeClase().agregarTropaDetectoraAZealotsInvisibles(this);
        superficie = "tierra";
        costoEnMinerales = 50;
        costoEnGas = 0;
        tiempoConstruccion = 5;
        danioTerrestre = 0;
        danioAereo = 0;
        suministro = 5;
    }

    public void instanciacionInicial(Posicion posicionALocalizar){
        posicion = posicionALocalizar;
    }
    public void realizarAccionesTurno(){}

    @Override
    public void pasarTurno() {
        vida.pasarTurno();
    }
}
