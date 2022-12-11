package edu.fiuba.algo3.modelo.Razas;

import edu.fiuba.algo3.modelo.Comunidad.Almacenamiento;
import edu.fiuba.algo3.modelo.Comunidad.Comunidad;
import edu.fiuba.algo3.modelo.Excepciones.RecursosInsuficientes;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Razas.Tropas.Invisible;
import edu.fiuba.algo3.modelo.Razas.Tropas.Visibilidad;
import edu.fiuba.algo3.modelo.Razas.Tropas.Visible;
import edu.fiuba.algo3.modelo.Salud.Salud;

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
    protected String sprite;
    public void pasarTurno(){
        estado.pasarTurno();
    }
    public abstract void realizarAccionesTurno();

    public void instanciacionesIniciales(Posicion posicionALocalizar){ this.posicion =posicionALocalizar;
        this.aplicarPesoEnSuministro();
    }
    public void iniciarConstruccion(){
        this.estado = new UnidadEnConstruccion(this);
    }
    public void cambiarEstado(EstadoConstruccion nuevoEstado){
        this.estado = nuevoEstado;
    }
    public void localizarEnMapa(int coordenadaX, int coordenadaY){
        posicion = new Posicion(coordenadaX,coordenadaY);
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

    public void daniar(int puntosAtaque){
        visibilidad.recibirDanioConsiderandoVisibilidad(puntosAtaque);
    }

    public void daniarIgnorandoVisibilidad(int puntosAtaque){
        visibilidad.recibirDanioIgnorandoVisibilidad(puntosAtaque);
    }
    public void disminuirVida(int puntosAtaque){
        vida.recibirAtaque(puntosAtaque);
        if(vida.estaSinVida()) {
            comunidad.restarPesoEnSuministro(suministro);
            comunidad.quitarUnidad(this);
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

    public void cargarSrite(String ruta){}
}
