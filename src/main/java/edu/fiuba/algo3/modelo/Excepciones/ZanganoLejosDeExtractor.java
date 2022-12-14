package edu.fiuba.algo3.modelo.Excepciones;

import edu.fiuba.algo3.App;

public class ZanganoLejosDeExtractor extends RuntimeException{
    public ZanganoLejosDeExtractor(){
        super();
        App.lanzarWarning("Este zangano esta lejos del extractor");
    }
}
