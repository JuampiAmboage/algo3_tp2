package edu.fiuba.algo3.modelo.Razas;

import edu.fiuba.algo3.modelo.Comunidad.ComunidadZerg;
import edu.fiuba.algo3.modelo.Edificios.Criadero;
import edu.fiuba.algo3.modelo.Edificios.Edificio;
import edu.fiuba.algo3.modelo.Edificios.Extractor;
import edu.fiuba.algo3.modelo.Excepciones.EvolucionIncompatibleConTropaEvolucionableActual;
import edu.fiuba.algo3.modelo.Razas.Tropas.Tropa;
import edu.fiuba.algo3.modelo.Razas.Tropas.UnidadEvolucionable;
import edu.fiuba.algo3.modelo.Salud.Vida;

public class Zangano extends Tropa{
    Extractor extractorDondeTrabaja;

    public Zangano(){
        costoEnGas = 0;
        costoEnMinerales = 25;
        tiempoConstruccion = 1;
        vida = new Vida(25);
        edificioNecesario = new Criadero();
    }
    @Override
    public void pasarTurno(){vida.pasarTurno();}

    public void realizarAccionesTurno(){}
    public void asignarTrabajo(Extractor extractorQueContrata){
        extractorDondeTrabaja = extractorQueContrata;
    }

    public void evolucionarAEdificio(Edificio edificioNuevo){
        ComunidadZerg comunidadZerg = ComunidadZerg.obtenerInstanciaDeClase();
        comunidadZerg.agregarUnidad(edificioNuevo);
        comunidadZerg.quitarUnidad(this);
    }
    public void mutar(Tropa tropaPostMutacion){
        throw new EvolucionIncompatibleConTropaEvolucionableActual();
    }

    public void revisarEstadoLaboral(){
        if(extractorDondeTrabaja != null) {
            throw new RuntimeException();
            //throw new ZanganoLaburando, no lo podes eliminar
        }
    }
}
