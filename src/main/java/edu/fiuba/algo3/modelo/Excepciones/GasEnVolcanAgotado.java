package edu.fiuba.algo3.modelo.Excepciones;

import edu.fiuba.algo3.App;

public class GasEnVolcanAgotado extends RuntimeException {
    public GasEnVolcanAgotado() {
        super();
        App.lanzarWarning("El gas de este volcan esta agotado");
    }
}
