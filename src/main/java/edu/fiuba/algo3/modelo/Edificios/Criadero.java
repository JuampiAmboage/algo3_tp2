package edu.fiuba.algo3.modelo.Edificios;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Celdas.CeldaConMoho;
import edu.fiuba.algo3.modelo.Celdas.CeldaEnergizada;
import edu.fiuba.algo3.modelo.Celdas.CeldaLibre;
import edu.fiuba.algo3.modelo.Excepciones.ConstruccionProhibida;
import edu.fiuba.algo3.modelo.Raza.Larva;
import edu.fiuba.algo3.modelo.Recursos.NoRecurso;
import edu.fiuba.algo3.modelo.Recursos.NodoMineral;
import edu.fiuba.algo3.modelo.Recursos.Volcan;
import edu.fiuba.algo3.modelo.vida.Salud;
import edu.fiuba.algo3.modelo.vida.Vida;
import java.util.ArrayList;
import java.lang.RuntimeException;

public class Criadero extends Edificio implements Construible {
    private int cantidadMaxDeLarvas = 3;
    private int tiempoDeConstruccion = 3;
    private final Salud vida = new Vida(500);
    ArrayList<Larva> larvas;

    public Criadero(){
        this.larvas = new ArrayList<Larva>(cantidadMaxDeLarvas);
        for (int i = 0; i < 3; i++) {
            agregarLarvas();
        }
        this.tiempoDeConstruccion = 4;
    }

    public Criadero(int tiempoDeConstruccion) {
        this.larvas = new ArrayList<Larva>(cantidadMaxDeLarvas);
        for (int i = 0; i < 3; i++) {
            agregarLarvas();
        }
        this.tiempoDeConstruccion = tiempoDeConstruccion;
    }


    @Override
    public void construirEn(Celda celda) {
        //verificacion de que se puede construir en esa celda
        this.turnosPasadosParaConstruccion = 0;
    }


    public boolean estaOperativo() {
        return this.tiempoDeConstruccion <= 0;
    }
    public void pasarTurno(){
        if(!this.estaOperativo())
            this.tiempoDeConstruccion--;
        else{
            vida.pasarTurno();
        }
    }

    public int cantidadDeLarvas(){
        return this.larvas.size();
    }

    public void engendrar() {
        if (this.estaOperativo()) {
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

    @Override
    public void construirSobreRecurso(NoRecurso tipoRecurso) {}
    @Override
    public void construirSobreRecurso(NodoMineral tipoRecurso) {
        throw new ConstruccionProhibida();
    }
    @Override
    public void construirSobreRecurso(Volcan tipoRecurso) {
        throw new ConstruccionProhibida();
    }
    @Override
    public void construirSobreTipo(CeldaConMoho tipo) {}
    @Override
    public void construirSobreTipo(CeldaEnergizada tipo) {
        throw new ConstruccionProhibida();
    }
    @Override
    public void construirSobreTipo(CeldaLibre tipo) {
        throw new ConstruccionProhibida();
    }
    @Override
    public void construirSobre(Celda celda) throws ConstruccionProhibida{
        celda.quiereConstruir(this);
    }
}
