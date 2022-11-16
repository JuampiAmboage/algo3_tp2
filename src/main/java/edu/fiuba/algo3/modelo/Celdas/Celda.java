package edu.fiuba.algo3.modelo.Celdas;

import edu.fiuba.algo3.modelo.Edificios.Construible;
import edu.fiuba.algo3.modelo.Excepciones.CeldaOcupada;
import edu.fiuba.algo3.modelo.Recursos.NoRecurso;
import edu.fiuba.algo3.modelo.Recursos.Recurso;
import edu.fiuba.algo3.modelo.Racita;

import java.util.ArrayList;

public class Celda {
    protected ArrayList<Celda> celdasAdyacentes;
    protected Racita ocupante;
    protected TipoCelda tipo;
    protected Recurso recurso;

    static public boolean esCelda(Object objeto) {
        return objeto instanceof Celda;
    }

    public Celda(){
        this.recurso = new NoRecurso();
        this.tipo = new CeldaLibre(this);
    }

    public void ocupar(Racita ocupante){
        if(!estaOcupada())
            this.ocupante = ocupante;
        else{
            throw new CeldaOcupada();
        }
    }
    public Racita desocupar(){
        Racita u = this.ocupante;
        this.ocupante = null;
        return u;
    }
    public int cantidadAdyacentes() {
        return celdasAdyacentes.size();
    }
    public void setAdyacentes(ArrayList<Celda> adyacentes){
        celdasAdyacentes = adyacentes;
    }
    public boolean estaOcupada() {
        return this.ocupante != null;
    }
    public void pasarTurno(){
        if (this.estaOcupada()) {
            this.ocupante.pasarTurno();
        }
        this.tipo.pasarTurno();
    }
    public void cambiarTipo(TipoCelda t) {
        this.tipo.cambiarTipo(t);
    }
    public boolean esMismoTipo(TipoCelda t) {
        return this.tipo.esMismoTipo(t);
    }
    public void agregarRecurso(Recurso nuevoRecurso){
        recurso = nuevoRecurso;
    }
    public int extraer(int cantidad) {
        return this.recurso.extraer(cantidad);
    }
    public void quiereConstruir(Construible construible) {
        this.recurso.quiereConstruir(construible);
        this.tipo.quiereConstruir(construible);
    }
}
