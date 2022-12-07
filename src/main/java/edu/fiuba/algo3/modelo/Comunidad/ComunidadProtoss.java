package edu.fiuba.algo3.modelo.Comunidad;

import edu.fiuba.algo3.modelo.Razas.GeneradorUnidadesProtoss;

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

    public void crearUnidad(String unidadACrear){
        this.agregarUnidad(GeneradorUnidadesProtoss.crearUnidadProtoo(unidadACrear));
    }
}
