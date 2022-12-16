package edu.fiuba.algo3.modelo.Excepciones;

import edu.fiuba.algo3.App;

public class CeldaOcupada extends RuntimeException {
    public CeldaOcupada() {
        super();
    }

    public void lanzarVentana() {
        App.lanzarWarning("Esta celda esta ocupada");
    }
}
