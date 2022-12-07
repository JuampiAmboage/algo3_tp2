package edu.fiuba.algo3.modelo.Razas;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Comunidad.ComunidadZerg;
import edu.fiuba.algo3.modelo.Edificios.Edificio;

public class Evolucionador {
    private ComunidadZerg comunidad;

    public Evolucionador(){
        comunidad = ComunidadZerg.obtenerInstanciaDeClase();
    }

    public void evolucionarUnidad(Unidad tropaEvolucionable, Unidad tropaEvolucionada){
        comunidad.agregarUnidad(tropaEvolucionada);
        comunidad.quitarUnidad(tropaEvolucionable);
    }
    public void evolucionarZangano(Celda celda, Edificio edificioEvolucionado, Zangano zangano){
        comunidad.agregarUnidad(edificioEvolucionado);
        comunidad.quitarUnidad(zangano);
    }

}