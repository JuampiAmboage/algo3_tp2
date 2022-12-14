package edu.fiuba.algo3.modelo.Excepciones;

import edu.fiuba.algo3.App;

public class CoordenadaFueraDeRango extends RuntimeException{
    public CoordenadaFueraDeRango() {
        super();
        App.lanzarWarning("Esta cordeenada esta fuera de rango");
    }
}
