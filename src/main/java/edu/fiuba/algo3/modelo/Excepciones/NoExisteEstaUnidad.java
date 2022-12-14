package edu.fiuba.algo3.modelo.Excepciones;

import edu.fiuba.algo3.App;

public class NoExisteEstaUnidad extends RuntimeException{
    public NoExisteEstaUnidad(){
        super();
        App.lanzarWarning("Esta unidad no existe");
    }
}
