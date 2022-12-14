package edu.fiuba.algo3.modelo.Excepciones;

import edu.fiuba.algo3.App;

public class UnidadInexistente extends RuntimeException{
    public UnidadInexistente() {
        super();
        App.lanzarWarning("Esta unidad no existe");
    }

}
