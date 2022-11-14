package edu.fiuba.algo3.modelo.Edificios;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Raza.Larva;
import edu.fiuba.algo3.modelo.vida.Regenerable;
import java.util.ArrayList;
import java.lang.RuntimeException;

public class Criadero extends Edificio {
    Regenerable regenerable;
    private int vidaMaxima = 500;

    private int cantidadMaxDeLarvas = 3;
    private int tiempoDeConstruccion = 3;

    ArrayList<Larva> larvas;

    public Criadero(){
        this.larvas = new ArrayList<Larva>(cantidadMaxDeLarvas);
        for (int i = 0; i < 3; i++) {
            agregarLarvas();
        }
        regenerable = new Regenerable(this.vidaMaxima);
    }

    @Override
    public void construir_en(Celda celda) {
        //verificacion de que se puede construir en esa celda
        this.turnosPasadosParaConstruccion = 0;
    }

    @Override
    public void pasarTurno(){
        if (cantidadDeLarvas() < 3) {
            agregarLarvas();
        }

        if (this.turnosPasadosParaConstruccion != this.tiempoDeConstruccion) {

            this.turnosPasadosParaConstruccion++;

        } else {

            this.turnosPasadosParaConstruccion = -1;
            this.estaConstruido = true;

        }
        this.regenerable.regenerar(20);

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

    public void daniarEdificio(int puntosAtaque){
        regenerable.recibirAtaque(puntosAtaque);
    }

    public void regenerar(int porcentaje){
        regenerable.regenerar(porcentaje);
    }

}
