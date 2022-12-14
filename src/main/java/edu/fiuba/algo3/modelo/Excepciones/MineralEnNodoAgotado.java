package edu.fiuba.algo3.modelo.Excepciones;

import edu.fiuba.algo3.App;

public class MineralEnNodoAgotado extends RuntimeException{
    public MineralEnNodoAgotado(){
        super();
        App.lanzarWarning("El mineral de este nodo esta agotado");
    }
}
