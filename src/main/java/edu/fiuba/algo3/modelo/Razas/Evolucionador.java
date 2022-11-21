package edu.fiuba.algo3.modelo.Razas;

import edu.fiuba.algo3.modelo.ComunidadNueva.Comunidad;
import edu.fiuba.algo3.modelo.ComunidadNueva.ComunidadZerg;
import edu.fiuba.algo3.modelo.Edificios.Edificio;
import edu.fiuba.algo3.modelo.Unidades.Tropa;

public class Evolucionador {
    private ComunidadZerg comunidad;

    public Evolucionador(){
        comunidad = ComunidadZerg.obtenerInstanciaDeClase();
    }
    public void evolucionarLarvaATropa(Tropa tropaEvolucionada){
       comunidad.agregarTropa(tropaEvolucionada);
    }

    public void evolucionarLarvaAZangano(){
        comunidad.agregarZangano();
    }
    public void evolucionarTropa(Tropa tropaEvolucionable, Tropa tropaEvolucionada){
        comunidad.mutarTropa(tropaEvolucionable,tropaEvolucionable);
    }
    public void evolucionarZangano(Edificio edificioEvolucionado){
        comunidad.construirEdificio(edificioEvolucionado);
    }

}