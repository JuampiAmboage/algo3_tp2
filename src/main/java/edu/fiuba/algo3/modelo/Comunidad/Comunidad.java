package edu.fiuba.algo3.modelo.Comunidad;

import edu.fiuba.algo3.modelo.Racita;
import edu.fiuba.algo3.modelo.Raza.*;
import edu.fiuba.algo3.modelo.Almacenamiento.Almacenamiento;
import edu.fiuba.algo3.modelo.Edificios.*;
import java.util.ArrayList;
import java.util.Arrays;

public class Comunidad {
    private ArrayList<Racita> pueblo;
    private Almacenamiento almacenamiento;

    private ArrayList<Edificio> edificios;

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
        return almacenamiento.recursosSuficientes(cantidadMineralRequerido,cantidadGasRequerido);
    }
    public void agregar_edificio(Edificio edificio) {
        this.edificios.add(edificio);
    }
}
