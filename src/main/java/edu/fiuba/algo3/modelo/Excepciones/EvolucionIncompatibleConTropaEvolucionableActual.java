package edu.fiuba.algo3.modelo.Excepciones;

import edu.fiuba.algo3.App;

public class EvolucionIncompatibleConTropaEvolucionableActual extends IllegalArgumentException{
    public EvolucionIncompatibleConTropaEvolucionableActual() {
        super();
        App.lanzarWarning("Esta evolucion es incompatible");
    }

}
