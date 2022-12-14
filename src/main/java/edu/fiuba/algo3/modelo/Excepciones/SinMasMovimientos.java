package edu.fiuba.algo3.modelo.Excepciones;

import edu.fiuba.algo3.App;

public class SinMasMovimientos extends RuntimeException{
    public SinMasMovimientos(){
        super();
        App.lanzarWarning("No tienes mas movimientos. Podés hacer hasta tres por turno.");
    }
}
