package edu.fiuba.algo3.modelo.Comunidad;

import edu.fiuba.algo3.modelo.Razas.Unidad;
import java.util.ArrayList;

public class Comunidad {
    protected ArrayList<Unidad> unidades;
    Almacenamiento almacenamiento;

    public Comunidad(){
        almacenamiento = new Almacenamiento();
        unidades = new ArrayList<Unidad>();
    }
    public void agregarUnidad(Unidad unidadNueva){
        unidadNueva.suficientesRecursosParaConstruirme(almacenamiento);
        unidades.add(unidadNueva);
    }
    public void quitarUnidad(Unidad unidadSaliente){
        unidades.remove(unidadSaliente);
    }
    public void aniadirGasVespeno(int cantidadGasEntrante){
        almacenamiento.almacenarGasVespeno(cantidadGasEntrante);
    }
    public void aniadirMineral(int cantidadMineralEntrante){
        almacenamiento.almacenarMinerales(cantidadMineralEntrante);
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
