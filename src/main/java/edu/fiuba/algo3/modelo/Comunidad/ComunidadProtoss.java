package edu.fiuba.algo3.modelo.Comunidad;

import edu.fiuba.algo3.modelo.Razas.Tropas.Tropa;
import edu.fiuba.algo3.modelo.Razas.Tropas.Zealot;
import edu.fiuba.algo3.modelo.Razas.Unidad;

public class ComunidadProtoss extends Comunidad{

    private static ComunidadProtoss comunidadProtoss;
    private ComunidadProtoss() {
        super();
    }

    public static ComunidadProtoss obtenerInstanciaDeClase(){
        if(comunidadProtoss == null)
            comunidadProtoss = new ComunidadProtoss();
        return comunidadProtoss;
    }

    public void crearUnidad(String unidadACrear){
        this.agregarUnidad(GeneradorUnidadesProtoss.crearUnidadProtoo(unidadACrear));
    }

    public void agregarTropaDetectoraAZealotsInvisibles(Tropa tropaDetectora){
        for (Unidad unidad : unidades) {
            if (unidad.getClass().equals(Zealot.class))
                ((Zealot) unidad).agregarTropaDetectora(tropaDetectora);
        }
}
