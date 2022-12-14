package edu.fiuba.algo3.modelo.Excepciones;

import edu.fiuba.algo3.App;

public class TropaSinAtaqueATierra extends RuntimeException{
    public TropaSinAtaqueATierra() {
        super();
        App.lanzarWarning("Esta tropa no tiene ataque por tierra");
    }

}
