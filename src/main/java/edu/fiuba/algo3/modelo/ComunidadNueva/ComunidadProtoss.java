package edu.fiuba.algo3.modelo.ComunidadNueva;

import edu.fiuba.algo3.modelo.Razas.Larva;
import edu.fiuba.algo3.modelo.Razas.Zangano;

import java.util.ArrayList;

public class ComunidadProtoss extends Comunidad{

    private static ComunidadProtoss comunidadProtoss;
    private ComunidadProtoss() {
        super();
    }

    public static ComunidadProtoss obtenerInstanciaDeClase(){
        if(comunidadProtoss == null)
            comunidadProtoss = new ComunidadProtoss();
        return comunidadProtoss;
    }
}
