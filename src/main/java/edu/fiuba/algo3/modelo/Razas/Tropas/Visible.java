package edu.fiuba.algo3.modelo.Razas.Tropas;

import edu.fiuba.algo3.modelo.Razas.Unidad;

public class Visible extends Visibilidad{

    public Visible(Unidad tropaContenedora){
        super(tropaContenedora);
    };

    public void recibirDanioConsiderandoVisibilidad(int puntosAtaque){
        unidad.disminuirVida(puntosAtaque);
    }
}
