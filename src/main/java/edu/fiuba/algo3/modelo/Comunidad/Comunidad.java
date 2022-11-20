package edu.fiuba.algo3.modelo.Comunidad;

import edu.fiuba.algo3.modelo.Racita;
import edu.fiuba.algo3.modelo.Raza.*;
import edu.fiuba.algo3.modelo.Almacenamiento.Almacenamiento;
import edu.fiuba.algo3.modelo.Edificios.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Comunidad {
    private ArrayList<Racita> pueblo;
    private ArrayList<Edificio> edificios;
    private Almacenamiento almacenamiento;

    public Comunidad(){ //este constructor solo lo creé para correr tests, desp se arregla bien
        almacenamiento = new Almacenamiento();
    }
    public Comunidad(Racita[] raza) {
        Racita[] lista_inicial = new Racita[0];
        this.almacenamiento = new Almacenamiento();

        this.pueblo = new ArrayList<Racita>(0);
        this.pueblo.addAll(Arrays.asList(raza));
    }

    public void almacenarMinerales(int cantidad) {
        this.almacenamiento.almacenarMinerales(cantidad);
    }
    public void almacenarGasVespeno(int cantidad) {
        this.almacenamiento.almacenarGasVespeno(cantidad);
    }

    public void restarRecursos(int restaMinerales, int restaGas){
        almacenamiento.retirarMinerales(restaMinerales);
        almacenamiento.retirarGasVespeno(restaGas);
    }

    public boolean recursosSuficientes(int cantidadMineralRequerido, int cantidadGasRequerido){
        return (cantidadMineralRequerido <= almacenamiento.obtenerCantidadGasAlmacenado() && cantidadGasRequerido <= almacenamiento.obtenerCantidadGasAlmacenado());
    }

    public void agregarEdificio(Edificio edificio){
        if (recursosSuficientes(edificio.obtenerCostoMinerales(),edificio.obtenerCostoGas())) {
            this.edificios.add(edificio);
            this.almacenamiento.retirarGasVespeno(edificio.obtenerCostoGas());
            this.almacenamiento.retirarMinerales(edificio.obtenerCostoMinerales());
        }
        else{
            throw new RuntimeException("No tenes recursos suficientes.");
        }
    }
    public void generarUnidad(Racita unidadAGenerar){
        if (recursosSuficientes(unidadAGenerar.obtenerCostoMinerales(),unidadAGenerar.obtenerCostoGas())) {
            this.pueblo.add(unidadAGenerar);
            this.almacenamiento.retirarGasVespeno(unidadAGenerar.obtenerCostoGas());
            this.almacenamiento.retirarMinerales(unidadAGenerar.obtenerCostoMinerales());
        }
        else{
            throw new RuntimeException("No tenes recursos suficientes");
        }
    }


}
