package edu.fiuba.algo3.modelo.Excepciones;

import edu.fiuba.algo3.App;

public class SinMasAtaques extends RuntimeException{
    public SinMasAtaques(){
        super();
        App.lanzarWarning("Esta tropa ya realizó todos los ataques permitidos para este turno");

    }
}
