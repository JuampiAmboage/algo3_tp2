package edu.fiuba.algo3.modelo.ComunidadNueva;

import edu.fiuba.algo3.modelo.Almacenamiento.Almacenamiento;
import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Edificios.Edificio;
import edu.fiuba.algo3.modelo.Edificios.EdificioEnConstruccion;
import edu.fiuba.algo3.modelo.Raza;
import edu.fiuba.algo3.modelo.Razas.Larva;
import edu.fiuba.algo3.modelo.Razas.Zangano;
import edu.fiuba.algo3.modelo.Unidades.Tropa;

import java.util.ArrayList;

public class Comunidad {
    protected ArrayList<EdificioEnConstruccion> edificiosEnConstruccion;
    protected ArrayList<Raza> unidades;
    Almacenamiento almacenamiento;

    public Comunidad(){
        almacenamiento = new Almacenamiento();
        unidades = new ArrayList<Raza>();
        edificiosEnConstruccion = new ArrayList<EdificioEnConstruccion>();
    }

    public void construirEdificio(Celda celda, Edificio nuevoEdificio){
        administrarRecursos(nuevoEdificio.obtenerCostoGas(),nuevoEdificio.obtenerCostoMinerales());
        nuevoEdificio.construirSobre(celda);
        almacenamiento.retirarGasVespeno(nuevoEdificio.obtenerCostoGas());
        almacenamiento.retirarMinerales(nuevoEdificio.obtenerCostoMinerales());
        EdificioEnConstruccion construccion = new EdificioEnConstruccion(nuevoEdificio,this);
        edificiosEnConstruccion.add(construccion);
    }

    public void finalizarConstruccionEdificio(Edificio edificioTerminado, EdificioEnConstruccion exConstruccion){
        unidades.add(edificioTerminado);
        edificiosEnConstruccion.remove(exConstruccion);
    }

    public void agregarUnidad(Raza unidadNueva){
        administrarRecursos(unidadNueva.obtenerCostoGas(),unidadNueva.obtenerCostoMinerales());
        unidades.add(unidadNueva);
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
}
