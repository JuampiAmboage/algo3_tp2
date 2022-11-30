package edu.fiuba.algo3.modelo.Razas;

import edu.fiuba.algo3.modelo.Comunidad.Almacenamiento;
import edu.fiuba.algo3.modelo.Excepciones.RecursosInsuficientes;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Salud.Salud;

public abstract class Unidad {
    protected Salud vida;
    protected Posicion posicion;
    protected EstadoConstruccion estado;
    protected int costoEnMinerales;
    protected int costoEnGas;
    protected int tiempoConstruccion;
    public abstract void pasarTurno();
    public abstract void realizarAccionesTurno();

    public void cambiarEstado(EstadoConstruccion nuevoEstado){
        this.estado = nuevoEstado;
    }
    public void daniar(int puntosAtaque){
        vida.recibirAtaque(puntosAtaque);
    }

    public void localizarEnMapa(int coordenadaX, int coordenadaY){
        posicion = new Posicion(coordenadaX,coordenadaY);
    }
    public int obtenerVida(){return vida.getVidaActual();}

    public int obtenerCostoMinerales(){return costoEnMinerales;}

    public int obtenerCostoGas(){return costoEnGas;}

    public int obtenerTiempoConstruccion(){return tiempoConstruccion;}
    public Posicion obtenerPosicion(){
        return posicion;
    }

    public void suficientesRecursosParaConstruirme(Almacenamiento almacenamiento) throws RecursosInsuficientes{
        if(almacenamiento.suficientesRecursos(costoEnGas,costoEnMinerales)){
            almacenamiento.retirarGasVespeno(costoEnGas);
            almacenamiento.retirarMinerales(costoEnMinerales);
        }
        else throw new RecursosInsuficientes();
    }

}
