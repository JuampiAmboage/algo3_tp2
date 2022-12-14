package edu.fiuba.algo3.modelo.Razas;

import edu.fiuba.algo3.modelo.Comunidad.Almacenamiento;
import edu.fiuba.algo3.modelo.Comunidad.Comunidad;
import edu.fiuba.algo3.modelo.Construccion.EstadoConstruccion;
import edu.fiuba.algo3.modelo.Construccion.UnidadConstruida;
import edu.fiuba.algo3.modelo.Construccion.UnidadEnConstruccion;
import edu.fiuba.algo3.modelo.Excepciones.RecursosInsuficientes;
import edu.fiuba.algo3.modelo.Opciones.OpcionElegible;
import edu.fiuba.algo3.modelo.Partida.Mapa;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Visibilidad.Visibilidad;
import edu.fiuba.algo3.modelo.Salud.Salud;

import java.util.ArrayList;

public abstract class Unidad {
    protected Comunidad comunidad;
    protected Visibilidad visibilidad;
    protected Salud vida;
    protected Posicion posicion;
    protected EstadoConstruccion estado;
    protected int costoEnMinerales;
    protected int costoEnGas;
    protected int tiempoConstruccion;
    protected int suministro;
    protected String rutaSprite = "/sprites/";
    protected String nombreUnidad;

    protected ArrayList<OpcionElegible> opciones;

    public Unidad() {
        opciones = new ArrayList<>();
    }

    public void pasarTurno(){
        estado.pasarTurno();
    }
    public abstract void realizarAccionesTurno();
    public void construccionInstantanea() {
        this.estado = new UnidadConstruida(this);
    }
    public void instanciacionesIniciales(Posicion posicionALocalizar){ this.posicion = posicionALocalizar; }
    public void iniciarConstruccion(){
        this.estado = new UnidadEnConstruccion(this);
    }
    public void cambiarEstado(EstadoConstruccion nuevoEstado){
        this.estado = nuevoEstado;
    }
    public int obtenerVida(){return vida.getVidaActual();}

    public int obtenerCostoMinerales(){return costoEnMinerales;}

    public int obtenerCostoGas(){return costoEnGas;}


    public int obtenerTiempoConstruccion(){return tiempoConstruccion;}
    public double obtenerDistanciaA(int coordenadaX, int coordenadaY){
        return posicion.obtenerDistanciaA(coordenadaX,coordenadaY);
    }

    public void suficientesRecursosParaConstruirme(Almacenamiento almacenamiento){
        if(almacenamiento.suficientesRecursos(costoEnGas,costoEnMinerales)){
            almacenamiento.descontarRecursos(costoEnGas,costoEnMinerales);
        }
        else throw new RecursosInsuficientes();
    }

    public void deshacerCambiosEnComunidad(){
        comunidad.aniadirGasVespeno(this.costoEnGas);
        comunidad.aniadirMineral(this.costoEnMinerales);
        comunidad.quitarUnidad(this);
        comunidad.restarPesoEnSuministro(this.suministro);
    }

    public void daniar(int puntosAtaque){
        visibilidad.recibirDanioConsiderandoVisibilidad(puntosAtaque);
    }

    public void daniarIgnorandoVisibilidad(int puntosAtaque){
        visibilidad.recibirDanioIgnorandoVisibilidad(puntosAtaque);
    }

    public void desaparecerUnidadDeCelda(){
        Mapa.getInstance().obtenerCelda(posicion).desocuparPorTierra();
    }
    public void disminuirVida(int puntosAtaque){
        vida.recibirAtaque(puntosAtaque);
        if(vida.estaSinVida()) {
            comunidad.restarPesoEnSuministro(suministro);
            comunidad.quitarUnidad(this);
            this.desaparecerUnidadDeCelda();
        }
    }

    public void aplicarPesoEnSuministro(){
        comunidad.aniadirPesoEnSuministro(suministro);
    }

    public void esUsable(){
        estado.esUsable();
    }
    public boolean estaSinVida(){
        return vida.estaSinVida();
    }

    public ArrayList<OpcionElegible> obtenerOpciones() { return this.opciones; }

    public abstract String obtenerSprite();

    public boolean existe(){
        return true;
    }

    public abstract String obtenerDescripcion();

    public String obtenerNombreUnidad(){
        return this.nombreUnidad;
    }

    public boolean unidadDesconocidaEnComunidadPropia(Unidad unidadAConsultar){return this.comunidad.existeUnidad(unidadAConsultar);}
}
