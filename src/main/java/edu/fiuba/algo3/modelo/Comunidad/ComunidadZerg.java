package edu.fiuba.algo3.modelo.Comunidad;

import edu.fiuba.algo3.modelo.Edificios.Criadero;
import edu.fiuba.algo3.modelo.Edificios.Edificio;
import edu.fiuba.algo3.modelo.Razas.Tropas.Mutalisco;
import edu.fiuba.algo3.modelo.Razas.Tropas.Tropa;
import edu.fiuba.algo3.modelo.Razas.Unidad;
import edu.fiuba.algo3.modelo.Razas.Zangano;


public class ComunidadZerg extends Comunidad {
    private static ComunidadZerg comunidadZerg;

    private ComunidadZerg() {
        super();
    }

    public static ComunidadZerg obtenerInstanciaDeClase() {
        if (comunidadZerg == null)
            comunidadZerg = new ComunidadZerg();
        return comunidadZerg;
    }

    public void crearUnidad(Criadero criaderoQueGenera, Unidad unidadAGenerar) {
        for (Unidad unidad : unidades) {
            if (unidad.equals(criaderoQueGenera)){
                unidad
                criaderoQueGenera.engendrar(unidadAGenerar);
                return;
            }
        }
    }

    public void construirEdificio(Zangano zanganoAEvolucionar, Edificio nuevoEdificio) {
        zanganoAEvolucionar.evolucionarAEdificio(nuevoEdificio);
    }

    public void mutar(Mutalisco mutaliscoAMutar, Tropa tropaPostMutacion){
        mutaliscoAMutar.mutar(tropaPostMutacion);
    }
}
