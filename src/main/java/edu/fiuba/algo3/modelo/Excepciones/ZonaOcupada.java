package edu.fiuba.algo3.modelo.Excepciones;

import edu.fiuba.algo3.App;

public class ZonaOcupada extends RuntimeException{
    public ZonaOcupada(){
        super();
        App.lanzarWarning("El área alrededor de este edificio está ocupada. Movilice alguna unidad");

    }
}
