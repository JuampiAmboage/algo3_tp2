package edu.fiuba.algo3.modelo.Celdas;

import edu.fiuba.algo3.modelo.Edificios.Edificio;
import edu.fiuba.algo3.modelo.Excepciones.PosicionesDiferentes;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Razas.Unidad;
import edu.fiuba.algo3.modelo.Recursos.NoRecurso;
import edu.fiuba.algo3.modelo.Recursos.Recurso;
import edu.fiuba.algo3.modelo.Excepciones.CeldaOcupada;
import edu.fiuba.algo3.modelo.Razas.Tropas.Tropa;


public class Celda {
    protected Unidad ocupante;
    protected Tropa ocupanteAereo;
    protected TipoCelda tipo;
    protected Recurso recurso;
    protected Posicion posicion;
    static public boolean esCelda(Object objeto) {
        return objeto instanceof Celda;
    }

    public Celda(int posicionX, int posicionY){
        this.recurso = new NoRecurso();
        this.tipo = new CeldaLibre(this);
        this.posicion = new Posicion(posicionX,posicionY);
    }
    public Celda(Recurso unRecurso, TipoCelda unTipo, Posicion unaPosicion) {
        this.recurso = unRecurso;
        unTipo.setCelda(this);
        this.tipo = unTipo;
        this.posicion = unaPosicion;
    }
    public Celda(){
        this.recurso = new NoRecurso();
        this.tipo = new CeldaLibre(this);
        this.posicion = new Posicion(0,0);
    }

    public Celda compararPosiciones(Posicion posicion) throws PosicionesDiferentes {
        posicion.compararPosiciones(posicion);
        return this;
    }
    public void ocupar(Unidad ocupante){
        if(!estaOcupada()) {
            this.ocupante = ocupante;
        }
        else{
            throw new CeldaOcupada();
        }
    }

    public void ocuparPorAire(Tropa ocupanteAereoNuevo){
        if(this.ocupanteAereo == null && ocupanteAereoNuevo.obtenerSuperficie().equals("aire"))
            this.ocupanteAereo = ocupanteAereoNuevo;
        else{
            throw new IllegalArgumentException();
        }
    }
    public Unidad desocupar(){
        Unidad u = this.ocupante;
        this.ocupante = null;
        return u;
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
        t.cambiarTipoDe(this);
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
    public void quiereConstruir(Edificio unEdificio) {
        this.recurso.quiereConstruir(unEdificio);
        this.tipo.quiereConstruir(unEdificio);
        ocupar(unEdificio);
    }

    public Unidad obtenerOcupante(){
        return ocupante;
    }
}
