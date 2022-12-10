package edu.fiuba.algo3.modelo.Celdas;

import edu.fiuba.algo3.modelo.Edificios.Edificio;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Razas.Tropas.TropaAerea;
import edu.fiuba.algo3.modelo.Razas.Unidad;
import edu.fiuba.algo3.modelo.Recursos.NoRecurso;
import edu.fiuba.algo3.modelo.Recursos.Recurso;
import edu.fiuba.algo3.modelo.Excepciones.CeldaOcupada;


public class Celda {
    protected Unidad ocupanteTerrestre;
    protected TropaAerea ocupanteAereo;
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

    public boolean esMismaPosicion(Posicion posicion){
        return this.posicion.esMismaPosicion(posicion);
    }
    public void ocuparPorTierra(Unidad ocupante){
        if(!estaOcupadaPorTierra()) {
            this.ocupanteTerrestre = ocupante;
        }
        else{
            throw new CeldaOcupada();
        }
    }

    public void ocuparPorAire(TropaAerea ocupanteAereoNuevo){
        this.ocupanteAereo = ocupanteAereoNuevo;
    }
    public Unidad desocupar(){
        Unidad u = this.ocupanteTerrestre;
        this.ocupanteTerrestre = null;
        return u;
    }
    public boolean estaOcupadaPorTierra() {
        return this.ocupanteTerrestre != null;
    }
    public boolean estaOcupadaPorAire() {
        return this.ocupanteAereo != null;
    }

    public void pasarTurno(){
        if (this.estaOcupadaPorTierra())
            this.ocupanteTerrestre.pasarTurno();
        if(this.estaOcupadaPorAire())
            this.ocupanteAereo.pasarTurno();
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
        ocuparPorTierra(unEdificio);
    }

    public Unidad obtenerOcupante(){
        return ocupanteTerrestre;
    }
}
