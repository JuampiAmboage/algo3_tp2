package edu.fiuba.algo3.modelo.Comunidad;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Edificios.Criadero;
import edu.fiuba.algo3.modelo.Edificios.Edificio;
import edu.fiuba.algo3.modelo.Razas.Unidad;
import edu.fiuba.algo3.modelo.Razas.UnidadEnConstruccion;
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

    public Criadero obtenerCriadero() {
        for (Unidad unidad : unidades) {
            if (unidad.getClass().equals(Criadero.class))
                return (Criadero) unidad;
        }
        throw new RuntimeException();
    }
    public void crearUnidadZerg(String tipoUnidad){
        this.obtenerCriadero().engendrar(tipoUnidad);
    }


    /*public void construirEdificio(Celda celda, Edificio nuevoEdificio){
        if(celda.obtenerOcupante() instanceof Zangano) {
            //administrarRecursos(nuevoEdificio.obtenerCostoGas(), nuevoEdificio.obtenerCostoMinerales());
            UnidadEnConstruccion construccion = new UnidadEnConstruccion(nuevoEdificio, this);
            unidades.add(construccion);
            quitarUnidad(celda.obtenerOcupante());
        }
        else{
            throw new RuntimeException();
        }
    }*/
}
