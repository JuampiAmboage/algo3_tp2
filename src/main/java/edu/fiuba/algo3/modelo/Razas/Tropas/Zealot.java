package edu.fiuba.algo3.modelo.Razas.Tropas;

import edu.fiuba.algo3.modelo.Comunidad.ComunidadProtoss;
import edu.fiuba.algo3.modelo.Comunidad.ComunidadZerg;
import edu.fiuba.algo3.modelo.Salud.VidaConEscudo;

public class Zealot extends Tropa implements TropaTerrestre {
    Invisibilidad invisible;
    int bajasGeneradas;
    public Zealot(){
        ataque = new AtacarTierra();
        superficie = "tierra";
        costoEnMinerales = 100;
        costoEnGas = 0;
        tiempoConstruccion = 4;
        danioTerrestre = 8;
        danioAereo = 0;
        suministro = 2;
        vida = new VidaConEscudo(100,60);
        bajasGeneradas = 0;
        ComunidadProtoss.obtenerInstanciaDeClase().aniadirSuministro(suministro);
    }

    @Override
    public void pasarTurno() {
        vida.pasarTurno();
        if(!esInvisible() && bajasGeneradas >= 3)
            invisible = new Invisibilidad();
    }

    public void agregarTropaDetectora(Tropa tropaDetectoraCreada){
        if(esInvisible())
            invisible.agregarTropaDetectora(tropaDetectoraCreada);
    }

    public boolean esInvisible(){return invisible != null;}
    public void realizarAccionesTurno(){}
    public int obtenerEscudo(){return vida.getEscudoActual();}

}
