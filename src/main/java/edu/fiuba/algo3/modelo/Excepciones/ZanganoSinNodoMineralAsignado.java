package edu.fiuba.algo3.modelo.Excepciones;

import edu.fiuba.algo3.App;

public class ZanganoSinNodoMineralAsignado extends RuntimeException{
    public ZanganoSinNodoMineralAsignado(){
        super();
        App.lanzarWarning("Este Zangano no tiene un nodo mineral asignado");
    }
}
