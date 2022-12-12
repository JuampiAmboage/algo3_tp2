package edu.fiuba.algo3.modelo.Visibilidad;

import edu.fiuba.algo3.modelo.Excepciones.TropaNoVisible;
import edu.fiuba.algo3.modelo.Razas.Unidad;
import edu.fiuba.algo3.modelo.Visibilidad.Visibilidad;

public class Invisible extends Visibilidad {
    public Invisible(Unidad tropaContenedora){super(tropaContenedora);}
    public void recibirDanioConsiderandoVisibilidad(int puntosAtaque){
        throw new TropaNoVisible();
    }

}
