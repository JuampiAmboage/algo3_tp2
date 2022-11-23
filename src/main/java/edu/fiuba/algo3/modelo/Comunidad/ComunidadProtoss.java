package edu.fiuba.algo3.modelo.Comunidad;

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
