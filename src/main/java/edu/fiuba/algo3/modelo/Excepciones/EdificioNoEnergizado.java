package edu.fiuba.algo3.modelo.Excepciones;

import edu.fiuba.algo3.App;

public class EdificioNoEnergizado extends RuntimeException{
    public EdificioNoEnergizado() {
        super();
        App.lanzarWarning("Este edificio no esta energizado");
    }
}
