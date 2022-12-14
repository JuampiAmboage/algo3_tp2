package edu.fiuba.algo3.modelo.Excepciones;

import edu.fiuba.algo3.App;

public class TropaNoVisible extends RuntimeException{
    public TropaNoVisible() {
        super();
        App.lanzarWarning("Tropa no visible");
    }
}
