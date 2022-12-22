package edu.fiuba.algo3.modelo.Excepciones;

import edu.fiuba.algo3.App;
import edu.fiuba.algo3.modelo.Posicion.Posicion;

public class CoordenadaFueraDeRango extends RuntimeException{
    public CoordenadaFueraDeRango() {
        super();
        App.lanzarWarning("Esta cordeenada esta fuera de rango");
    }
}
