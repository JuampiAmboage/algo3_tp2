package edu.fiuba.algo3.modelo.Excepciones;

import edu.fiuba.algo3.App;

public class PoblacionMaximaAlcanzada extends RuntimeException {
    public PoblacionMaximaAlcanzada() {
            super();
        App.lanzarWarning("La poblacion maxima ya fue alcanzada");
        }
}
