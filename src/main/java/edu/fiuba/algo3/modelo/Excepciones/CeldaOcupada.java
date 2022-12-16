package edu.fiuba.algo3.modelo.Excepciones;

import edu.fiuba.algo3.App;

public class CeldaOcupada extends RuntimeException {
    private boolean mostrar = false;
    public CeldaOcupada() {
        super();
    }

    public void lanzarVentana() {
        App.lanzarWarning("Esta celda esta ocupada");
    }

    public void cambiarEstado() {
        this.mostrar = true;
    }
}
