package edu.fiuba.algo3.modelo.Excepciones;

import edu.fiuba.algo3.App;

public class CeldaConRecurso extends RuntimeException{
    public CeldaConRecurso(){
        super();
        App.lanzarWarning("Esta celda tiene un recurso");
    }
}
