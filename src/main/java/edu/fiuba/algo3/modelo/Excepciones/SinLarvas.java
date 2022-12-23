package edu.fiuba.algo3.modelo.Excepciones;

import edu.fiuba.algo3.App;

public class SinLarvas extends RuntimeException {
    public SinLarvas(){
        super();
        App.lanzarWarning("Sin larvas");

    }

}
