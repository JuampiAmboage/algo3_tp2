package edu.fiuba.algo3.modelo.Comunidad;

import edu.fiuba.algo3.modelo.Edificios.Edificio;
import edu.fiuba.algo3.modelo.Excepciones.PoblacionMaximaAlcanzada;
import edu.fiuba.algo3.modelo.Razas.Unidad;
import java.util.ArrayList;

public class Comunidad {
    protected ArrayList<Unidad> unidades;
    protected Almacenamiento almacenamiento;

    protected  int cantidadPoblacionHabilitada;
    protected  int cantidadPoblacionActual;

    protected ArrayList<Edificio> edificiosQuePermitenCorrelativas;
    public Comunidad(){
        almacenamiento = new Almacenamiento();
        unidades = new ArrayList<Unidad>();
        edificiosQuePermitenCorrelativas = new ArrayList<Edificio>();
        cantidadPoblacionHabilitada = 200;
        cantidadPoblacionActual = 0;
    }
    public void agregarUnidad(Unidad unidadNueva){
        if(cantidadPoblacionActual++ <= cantidadPoblacionHabilitada) {
            unidadNueva.suficientesRecursosParaConstruirme(almacenamiento);
            unidades.add(unidadNueva);
        }
        else throw new PoblacionMaximaAlcanzada();
    }
    public void quitarUnidad(Unidad unidadSaliente){
        unidades.remove(unidadSaliente);
        cantidadPoblacionActual--;
    }

    public void agregarEdificioCorrelativo(Edificio nuevoEdificio){
        edificiosQuePermitenCorrelativas.add(nuevoEdificio);
    }
    public void aniadirGasVespeno(int cantidadGasEntrante){
        almacenamiento.almacenarGasVespeno(cantidadGasEntrante);
    }
    public void aniadirMineral(int cantidadMineralEntrante){
        almacenamiento.almacenarMinerales(cantidadMineralEntrante);
    }
    public void aniadirSuministro(int cantidadSuministroExpansible){
        cantidadPoblacionHabilitada += cantidadPoblacionHabilitada;
    }
    public void pasarTurno(){
        if(!unidades.isEmpty())
            unidades.forEach(unidadEnConstruccion -> unidadEnConstruccion.pasarTurno());
    }
    public boolean existeUnidad(Unidad unidadBuscada) {
        for (Unidad unidad : unidades) {
            if (unidad.getClass().equals(unidadBuscada.getClass()))
                return true;
        }
        return false;
    }
}
