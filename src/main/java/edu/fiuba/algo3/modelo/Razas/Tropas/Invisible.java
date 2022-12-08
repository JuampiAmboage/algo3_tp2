package edu.fiuba.algo3.modelo.Razas.Tropas;

import edu.fiuba.algo3.modelo.Excepciones.TropaNoVisible;
import edu.fiuba.algo3.modelo.Razas.Unidad;

public class Invisible extends Visibilidad{
    public Invisible(Unidad tropaContenedora){super(tropaContenedora);}
    public void recibirDanioConsiderandoVisibilidad(int puntosAtaque){
        throw new TropaNoVisible();
    }

}
