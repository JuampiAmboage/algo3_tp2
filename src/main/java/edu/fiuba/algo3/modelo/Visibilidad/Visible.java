package edu.fiuba.algo3.modelo.Visibilidad;

import edu.fiuba.algo3.modelo.Razas.Unidad;
import edu.fiuba.algo3.modelo.Visibilidad.Visibilidad;

public class Visible extends Visibilidad {

    public Visible(Unidad tropaContenedora){
        super(tropaContenedora);
    };

    public void recibirDanioConsiderandoVisibilidad(int puntosAtaque){
        unidad.disminuirVida(puntosAtaque);
    }
}
