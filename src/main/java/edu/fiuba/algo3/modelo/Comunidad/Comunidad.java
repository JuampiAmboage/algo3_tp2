package edu.fiuba.algo3.modelo.Comunidad;

import edu.fiuba.algo3.modelo.Excepciones.PoblacionMaximaAlcanzada;
import edu.fiuba.algo3.modelo.Excepciones.UnidadInexistente;
import edu.fiuba.algo3.modelo.Partida.Jugador;
import edu.fiuba.algo3.modelo.Razas.Unidad;

import java.util.ArrayList;

public abstract class Comunidad {
    private Jugador jugadorPropietario;

    protected ArrayList<Unidad> unidades;
    protected Almacenamiento almacenamiento;
    protected  int cantidadPoblacionHabilitada;
    protected  int cantidadPoblacionActual;

    public Comunidad(){
        almacenamiento = new Almacenamiento();
        unidades = new ArrayList<Unidad>();
        cantidadPoblacionHabilitada = 1;
        cantidadPoblacionActual = 0;
    }

    public void agregarJugadorPropietario(Jugador jugador){
        this.jugadorPropietario = jugador;
    }
    public void agregarUnidad(Unidad unidadNueva){
        if(cantidadPoblacionActual+1 <= cantidadPoblacionHabilitada) {
            unidadNueva.suficientesRecursosParaConstruirme(almacenamiento);
            unidadNueva.aplicarPesoEnSuministro();
            unidadNueva.iniciarConstruccion();
            unidades.add(unidadNueva);
        }
        else throw new PoblacionMaximaAlcanzada();
    }
    public void quitarUnidad(Unidad unidadSaliente){
        if(unidades.contains(unidadSaliente)) {
            unidades.remove(unidadSaliente);
        }
        else
            throw new UnidadInexistente();
    }

    public void revisarPoblacion(){
        if(unidades.isEmpty())
            jugadorPropietario.notificarFinDePartida();
    }

    public void aniadirGasVespeno(int cantidadGasEntrante){
        almacenamiento.almacenarGasVespeno(cantidadGasEntrante);
    }
    public void aniadirMineral(int cantidadMineralEntrante){
        almacenamiento.almacenarMinerales(cantidadMineralEntrante);
    }
    public void aniadirCapacidadSuministro(int cantidadSuministroExpansible){
        if(cantidadPoblacionHabilitada+cantidadSuministroExpansible <= 200)
            cantidadPoblacionHabilitada += cantidadSuministroExpansible;
        else
            cantidadPoblacionHabilitada = 200;
    }

    public void restarCapacidadSuministro(int cantidadSuministroARetirar){
        if(cantidadPoblacionHabilitada-cantidadSuministroARetirar >= 0)
            cantidadPoblacionHabilitada -= cantidadSuministroARetirar;
        else
            cantidadPoblacionHabilitada = 0;
    }

    public void aniadirPesoEnSuministro(int pesoNuevaUnidad){
        this.cantidadPoblacionActual += pesoNuevaUnidad;
    }
    public void restarPesoEnSuministro(int pesoUnidadSaliente){
        this.cantidadPoblacionActual -= pesoUnidadSaliente;
    }
    public void pasarTurno(){
        if(!unidades.isEmpty())
            unidades.forEach(unidad -> unidad.pasarTurno());
    }
    public boolean existeUnidad(Unidad unidadBuscada) {
        for (Unidad unidad : unidades) {
            if (unidad.getClass().equals(unidadBuscada.getClass())) {
                unidad.esUsable();
                return true;
            }
        }
        return false;
    }

    public abstract void inicializarBase();
    public int obtenerSuministro(){return cantidadPoblacionHabilitada;}

    public int[] obtenerAlmacenamiento() {
        return this.almacenamiento.obtenerAlmacenamiento();
    }

}
