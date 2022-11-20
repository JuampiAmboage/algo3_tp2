package edu.fiuba.algo3.modelo.ComunidadNueva;

import edu.fiuba.algo3.modelo.Almacenamiento.Almacenamiento;
import edu.fiuba.algo3.modelo.Edificios.Edificio;
import edu.fiuba.algo3.modelo.Edificios.EdificioEnConstruccion;
import edu.fiuba.algo3.modelo.Razas.Larva;
import edu.fiuba.algo3.modelo.Razas.Zangano;
import edu.fiuba.algo3.modelo.Unidades.Tropa;

import java.util.ArrayList;

public class Comunidad {
    private static Comunidad comunidad;

    protected ArrayList<Edificio> edificiosConstruidos;

    protected ArrayList<EdificioEnConstruccion> edificiosEnConstruccion;
    protected ArrayList<Tropa> tropas;
    Almacenamiento almacenamiento;

    private ArrayList<Larva> larvas;
    private ArrayList<Zangano> zanganos;

    public static Comunidad getInstance(){
        if(comunidad == null)
            comunidad = new Comunidad();
        return comunidad;
    }
    protected Comunidad(){
        tropas = new ArrayList<Tropa>();
        edificiosEnConstruccion = new ArrayList<EdificioEnConstruccion>();
        edificiosConstruidos = new ArrayList<Edificio>();
    }

    public void construirEdificio(Edificio nuevoEdificio){
        administrarRecursos(nuevoEdificio.obtenerCostoGas(),nuevoEdificio.obtenerCostoMinerales());
        EdificioEnConstruccion construccion = new EdificioEnConstruccion(nuevoEdificio);
        edificiosEnConstruccion.add(construccion);
    }

    public void finalizarConstruccionEdificio(Edificio edificioTerminado, EdificioEnConstruccion exConstruccion){
        edificiosConstruidos.add(edificioTerminado);
        edificiosEnConstruccion.remove(exConstruccion);
    }

    public void agregarTropa(Tropa nuevaTropa){
        administrarRecursos(nuevaTropa.obtenerCostoGas(),nuevaTropa.obtenerCostoMinerales());
        tropas.add(nuevaTropa);
    }

    public void quitarTropa(Tropa tropaAQuitar){
        tropas.remove(tropaAQuitar);
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

    public void añadirGasVespeno(int cantidadGasEntrante){
        almacenamiento.almacenarGasVespeno(cantidadGasEntrante);
    }

    public void añadirMineral(int cantidadMineralEntrante){
        almacenamiento.almacenarMinerales(cantidadMineralEntrante);
    }
}
