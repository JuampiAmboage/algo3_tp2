package edu.fiuba.algo3.modelo.Excepciones;

import edu.fiuba.algo3.App;

public class ExtractorVacio extends RuntimeException{
    public ExtractorVacio(){
        super();
        App.lanzarWarning("El extractor esta vacío");

    }
}
