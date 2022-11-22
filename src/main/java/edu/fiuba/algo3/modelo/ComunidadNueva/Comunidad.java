package edu.fiuba.algo3.modelo.ComunidadNueva;

import edu.fiuba.algo3.modelo.Almacenamiento.Almacenamiento;
import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Edificios.Edificio;
import edu.fiuba.algo3.modelo.Edificios.UnidadEnConstruccion;
import edu.fiuba.algo3.modelo.Raza;

import java.util.ArrayList;

public class Comunidad {
    protected ArrayList<UnidadEnConstruccion> unidadesEnConstruccion;
    protected ArrayList<Raza> unidades;
    Almacenamiento almacenamiento;

    public Comunidad(){
        almacenamiento = new Almacenamiento();
        unidades = new ArrayList<Raza>();
        unidadesEnConstruccion = new ArrayList<UnidadEnConstruccion>();
    }

    public void construirEdificio(Celda celda, Edificio nuevoEdificio){
        administrarRecursos(nuevoEdificio.obtenerCostoGas(),nuevoEdificio.obtenerCostoMinerales());
        nuevoEdificio.construirSobre(celda);
        almacenamiento.retirarGasVespeno(nuevoEdificio.obtenerCostoGas());
        almacenamiento.retirarMinerales(nuevoEdificio.obtenerCostoMinerales());
        unidadesEnConstruccion.add(new UnidadEnConstruccion(nuevoEdificio,this));
    }

    public void finalizarUnidadEnConstruccion(Raza unidadTerminada, UnidadEnConstruccion exConstruccion){
        unidades.add(unidadTerminada);
        unidadesEnConstruccion.remove(exConstruccion);
    }

    public void agregarUnidad(Raza unidadNueva){
        administrarRecursos(unidadNueva.obtenerCostoGas(),unidadNueva.obtenerCostoMinerales());
        unidadesEnConstruccion.add(new UnidadEnConstruccion(unidadNueva,this));
    }
    public void quitarUnidad(Raza unidadSaliente){
        unidades.remove(unidadSaliente);
    }
    public void administrarRecursos(int costoGasUnidadAGenerar, int costoMineralUnidadAGenerar){
        if(costoGasUnidadAGenerar > almacenamiento.obtenerCantidadGasAlmacenado() ||
        costoMineralUnidadAGenerar > almacenamiento.obtenerCantidadMineralAlmacenado()){
            throw new RuntimeException();
        }
    }

    public void aniadirGasVespeno(int cantidadGasEntrante){
        almacenamiento.almacenarGasVespeno(cantidadGasEntrante);
    }

    public void aniadirMineral(int cantidadMineralEntrante){
        almacenamiento.almacenarMinerales(cantidadMineralEntrante);
    }

    public void pasarTurno(){
        if(!unidades.isEmpty())
            unidadesEnConstruccion.forEach(unidadEnConstruccion -> unidadEnConstruccion.pasarTurno());
        /*for (Raza unidad: unidades)
            unidad.pasarTurno();*/
    }
    public Raza buscarUnidad(Raza unidadBuscada){
        int conteoUnidades = 0;
        if(unidades.contains(unidadBuscada)){
            while(unidades.get(conteoUnidades) != unidadBuscada)
                conteoUnidades++;
            return unidades.get(conteoUnidades);
        }
        else
            throw new RuntimeException();
    }
}
