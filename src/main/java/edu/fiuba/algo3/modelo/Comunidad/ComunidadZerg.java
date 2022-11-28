package edu.fiuba.algo3.modelo.Comunidad;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Edificios.Criadero;
import edu.fiuba.algo3.modelo.Edificios.Edificio;
import edu.fiuba.algo3.modelo.Edificios.UnidadEnConstruccion;
import edu.fiuba.algo3.modelo.Edificios.Extractor;
import edu.fiuba.algo3.modelo.Razas.Larva;
import edu.fiuba.algo3.modelo.Razas.Zangano;


public class ComunidadZerg extends Comunidad {
    private static ComunidadZerg comunidadZerg;

    private ComunidadZerg() {
        super();
    }

    public static ComunidadZerg obtenerInstanciaDeClase(){
        if(comunidadZerg == null)
            comunidadZerg = new ComunidadZerg();
        return comunidadZerg;
    }

    public void construirEdificio(Celda celda, Edificio nuevoEdificio){
        if(celda.obtenerOcupante() instanceof Zangano) {
            //administrarRecursos(nuevoEdificio.obtenerCostoGas(), nuevoEdificio.obtenerCostoMinerales());
            UnidadEnConstruccion construccion = new UnidadEnConstruccion(nuevoEdificio, this);
            unidadesEnConstruccion.add(construccion);
            quitarUnidad(celda.obtenerOcupante());
        }
        else{
            throw new RuntimeException();
        }
    }
}
