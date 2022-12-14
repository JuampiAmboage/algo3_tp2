package edu.fiuba.algo3.modelo.Excepciones;

import edu.fiuba.algo3.App;

public class RecursosInsuficientes extends RuntimeException {
    public RecursosInsuficientes() {
        super();
        App.lanzarWarning("Tus recursos son insuficientes");
    }
}
