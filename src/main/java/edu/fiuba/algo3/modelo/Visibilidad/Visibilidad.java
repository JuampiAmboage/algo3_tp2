package edu.fiuba.algo3.modelo.Visibilidad;

import edu.fiuba.algo3.modelo.Razas.Unidad;

public abstract class Visibilidad {
    Unidad unidad;
    public Visibilidad(Unidad tropaContenedora){
        unidad = tropaContenedora;
    };
    public abstract void recibirDanioConsiderandoVisibilidad(int puntosAtaque);

    public void recibirDanioIgnorandoVisibilidad(int puntosAtaque){
        unidad.disminuirVida(puntosAtaque);
    }
}
