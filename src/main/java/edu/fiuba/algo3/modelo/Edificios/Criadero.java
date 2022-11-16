package edu.fiuba.algo3.modelo.Edificios;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Raza.Larva;
import edu.fiuba.algo3.modelo.vida.Vida;
import java.util.ArrayList;
import java.lang.RuntimeException;

public class Criadero extends Edificio {
    private int vidaMaxima = 500;

    private int cantidadMaxDeLarvas = 3;
    private int tiempoDeConstruccion = 3;

    ArrayList<Larva> larvas;

    public Criadero(){
        this.larvas = new ArrayList<Larva>(cantidadMaxDeLarvas);
        for (int i = 0; i < 3; i++) {
            agregarLarvas();
        }
        vida = new Vida(this.vidaMaxima);
        tiempoDeConstruccion = 4;
    }

    @Override
    public void construirEn(Celda celda) {
        //verificacion de que se puede construir en esa celda
        this.turnosPasadosParaConstruccion = 0;
    }

    public void pasarTurno(){
        if(!estaConstruido){
            controlEstadoConstruccion();
        }
        if (cantidadDeLarvas() < 3) {
            agregarLarvas();
        }

        this.vida.pasarTurno();

    }

    public int cantidadDeLarvas(){
        return this.larvas.size();
    }

    public void engendrar() {
        if (this.estaConstruido) {
            this.larvas.remove(0);
        }else{
            throw (new RuntimeException());
        }
    }

    private void agregarLarvas() {
        if (cantidadDeLarvas() < 3) {
        this.larvas.add(new Larva());
       }else{
            throw (new RuntimeException());
        }
    }
}
