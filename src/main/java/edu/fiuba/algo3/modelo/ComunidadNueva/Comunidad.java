package edu.fiuba.algo3.modelo.ComunidadNueva;

import edu.fiuba.algo3.modelo.Almacenamiento.Almacenamiento;
import edu.fiuba.algo3.modelo.Edificios.Edificio;
import edu.fiuba.algo3.modelo.Edificios.EdificioEnConstruccion;
import edu.fiuba.algo3.modelo.Raza;
import edu.fiuba.algo3.modelo.Razas.Larva;
import edu.fiuba.algo3.modelo.Razas.Zangano;
import edu.fiuba.algo3.modelo.Unidades.Tropa;

import java.util.ArrayList;

public class Comunidad {
    protected ArrayList<Edificio> edificiosConstruidos;

    protected ArrayList<EdificioEnConstruccion> edificiosEnConstruccion;
    protected ArrayList<Raza> unidades;
    Almacenamiento almacenamiento;

    public Comunidad(){
        almacenamiento = new Almacenamiento();
        unidades = new ArrayList<Raza>();
        edificiosEnConstruccion = new ArrayList<EdificioEnConstruccion>();
        edificiosConstruidos = new ArrayList<Edificio>();
    }

    public void construirEdificio(Edificio nuevoEdificio){
        administrarRecursos(nuevoEdificio.obtenerCostoGas(),nuevoEdificio.obtenerCostoMinerales());
        EdificioEnConstruccion construccion = new EdificioEnConstruccion(nuevoEdificio,this);
        edificiosEnConstruccion.add(construccion);
    }

    public void finalizarConstruccionEdificio(Edificio edificioTerminado, EdificioEnConstruccion exConstruccion){
        edificiosConstruidos.add(edificioTerminado);
        edificiosEnConstruccion.remove(exConstruccion);
    }

    public void agregarUnidad(Raza unidadNueva){
        administrarRecursos(unidadNueva.obtenerCostoGas(),unidadNueva.obtenerCostoMinerales());
        unidades.add(unidadNueva);
    }

    public void quitarTropa(Raza unidadSaliente){
        unidades.remove(unidadSaliente);
    }
    public void administrarRecursos(int costoGasUnidadAGenerar, int costoMineralUnidadAGenerar){
        if(costoGasUnidadAGenerar <= almacenamiento.obtenerCantidadGasAlmacenado() &&
        costoMineralUnidadAGenerar <= almacenamiento.obtenerCantidadMineralAlmacenado()){
            almacenamiento.retirarGasVespeno(costoGasUnidadAGenerar);
            almacenamiento.retirarMinerales(costoMineralUnidadAGenerar);
        }
        else{
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
