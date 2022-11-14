package edu.fiuba.algo3.modelo.Edificios;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Raza.Larva;

import java.util.ArrayList;

public class Criadero extends Edificio {

    private int cantidadMaxDeLarvas = 3;
    ArrayList<Larva> larvas;
    public Criadero(){
        this.larvas = new ArrayList<Larva>(3);
        for (int i = 0; i < 3; i++) {
            agregarLarvas();
        }
    }

    @Override
    public void construir_en(Celda celda) {/*algo aca*/}

    @Override
    public void pasarTurno(){
        if (cantidadDeLarvas() < 3) {
            agregarLarvas();
        }
    }

    public int cantidadDeLarvas(){
        return this.larvas.size();
    }

    public void engendrar() {
        this.larvas.remove(0);
    }

    private void agregarLarvas() {
        //if (cantidadDeLarvas() < 3) {
        this.larvas.add(new Larva());
       //}
        // else lanzar excepcion
    }

}
