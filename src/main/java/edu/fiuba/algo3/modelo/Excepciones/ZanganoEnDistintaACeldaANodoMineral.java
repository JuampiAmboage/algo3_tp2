package edu.fiuba.algo3.modelo.Excepciones;

import edu.fiuba.algo3.App;

public class ZanganoEnDistintaACeldaANodoMineral extends RuntimeException{
    public ZanganoEnDistintaACeldaANodoMineral(){
        super();
        App.lanzarWarning("No hay un nodo mineral en esta celda");
    }
}
