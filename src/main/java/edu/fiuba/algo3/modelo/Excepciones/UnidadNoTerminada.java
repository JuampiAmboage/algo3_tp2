package edu.fiuba.algo3.modelo.Excepciones;

import edu.fiuba.algo3.App;

public class UnidadNoTerminada extends RuntimeException {
    public UnidadNoTerminada() {
        super();
        App.lanzarWarning("Esta unidad no esta terminada");
    }
}
