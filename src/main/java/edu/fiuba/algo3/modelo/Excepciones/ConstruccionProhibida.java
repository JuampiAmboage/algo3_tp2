package edu.fiuba.algo3.modelo.Excepciones;

import edu.fiuba.algo3.App;

public class ConstruccionProhibida extends RuntimeException {
    public ConstruccionProhibida() {
        super();
        App.lanzarWarning("Esta construccion esta prohibida");
    }
}
