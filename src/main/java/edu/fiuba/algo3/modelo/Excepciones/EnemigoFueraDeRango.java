package edu.fiuba.algo3.modelo.Excepciones;

import edu.fiuba.algo3.App;

public class EnemigoFueraDeRango extends RuntimeException{
    public EnemigoFueraDeRango() {
        super();
        App.lanzarWarning("El enemigo esta fuera de rango");
    }

}
