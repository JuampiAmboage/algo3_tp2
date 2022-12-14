package edu.fiuba.algo3.modelo.Excepciones;

import edu.fiuba.algo3.App;

public class TropaSinAtaqueAereo extends RuntimeException{
    public TropaSinAtaqueAereo() {
        super();
        App.lanzarWarning("Esta tropa no tiene ataque aereo");
    }

}
