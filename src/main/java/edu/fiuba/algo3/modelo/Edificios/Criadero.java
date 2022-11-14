package edu.fiuba.algo3.modelo.Edificios;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Raza.Larva;
import edu.fiuba.algo3.modelo.vida.Regenerable;
import java.util.ArrayList;

public class Criadero extends Edificio {
    Regenerable regenerable;

    private int cantidadMaxDeLarvas = 3;
    ArrayList<Larva> larvas;
    public Criadero(int vida){
        this.larvas = new ArrayList<Larva>(3);
        for (int i = 0; i < 3; i++) {
            agregarLarvas();
        }
        regenerable = new Regenerable(vida);
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

    public void daniarEdificio(int puntosAtaque){
        regenerable.recibirAtaque(puntosAtaque);
    }

    public void regenerar(int porcentaje){
        regenerable.regenerar(porcentaje);
    }

}
