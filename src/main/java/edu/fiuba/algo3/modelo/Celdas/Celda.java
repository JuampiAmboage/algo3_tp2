package edu.fiuba.algo3.modelo.Celdas;

import edu.fiuba.algo3.modelo.Edificios.Edificio;
import edu.fiuba.algo3.modelo.Opciones.OpcionElegible;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Razas.Tropas.TropaAerea;
import edu.fiuba.algo3.modelo.Razas.Tropas.TropaAereaInexistente;
import edu.fiuba.algo3.modelo.Razas.Unidad;
import edu.fiuba.algo3.modelo.Razas.UnidadInexistente;
import edu.fiuba.algo3.modelo.Recursos.NoRecurso;
import edu.fiuba.algo3.modelo.Recursos.Recurso;
import edu.fiuba.algo3.modelo.Excepciones.CeldaOcupada;

import java.util.ArrayList;


public class Celda {
    protected Unidad ocupanteTerrestre;
    protected TropaAerea ocupanteAereo;
    protected TipoCelda tipo;
    protected Recurso recurso;
    protected Posicion posicion;

    protected boolean spriteCeldaNoEnviado = false;

    static public boolean esCelda(Object objeto) {
        return objeto instanceof Celda;
    }

    public Celda(int posicionX, int posicionY){
        this.recurso = new NoRecurso();
        this.ocupanteTerrestre = new UnidadInexistente();
        this.ocupanteAereo = new TropaAereaInexistente();
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
       this.ocupanteTerrestre = ocupante;
    }

    public void ocuparPorAire(TropaAerea ocupanteAereoNuevo){
        this.ocupanteAereo = ocupanteAereoNuevo;
    }


    public void desocuparPorTierra(){
        this.ocupanteTerrestre = new UnidadInexistente();
    }

    public void desocuparPorAire(){
        this.ocupanteAereo = new TropaAereaInexistente();
    }

    public void estaOcupadaPorTierra() {
        if (this.ocupanteTerrestre.existe())
            throw new CeldaOcupada();
    }
    public void estaOcupadaPorAire() {
        if (this.ocupanteAereo.existe())
            throw new CeldaOcupada();
    }

    public void pasarTurno(){
        if (this.ocupanteTerrestre.existe())
            this.ocupanteTerrestre.pasarTurno();
        if(this.ocupanteAereo.existe())
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
        recurso.posicionarRecurso(this.posicion);
    }
    public int extraer(int cantidad) {
        return this.recurso.extraer(cantidad);
    }
    public void quiereConstruir(Edificio unEdificio) {
        this.recurso.quiereConstruir(unEdificio);
        this.tipo.quiereConstruir(unEdificio);
    }

    public Unidad obtenerOcupanteTerrestre(){
        return ocupanteTerrestre;
    }

    public TropaAerea obtenerOcupanteAereo(){return ocupanteAereo; }

    public void instanciarUnidad(Unidad unidad){
        unidad.instanciacionesIniciales(posicion);
    }
    public ArrayList<OpcionElegible> gestionarOpcionesParaJugador() {

        ArrayList<OpcionElegible> listaDeOpciones = new ArrayList<OpcionElegible>();

        if (this.tipo != null) {
            ArrayList<OpcionElegible> opcionesDeTipo = this.tipo.obtenerOpciones();
            if (opcionesDeTipo != null ) { listaDeOpciones.addAll(opcionesDeTipo); }
        }

        if (this.ocupanteTerrestre.existe()) {
            ArrayList<OpcionElegible> opcionesDeOcupanteTerrestre = this.ocupanteTerrestre.obtenerOpciones();
            if (opcionesDeOcupanteTerrestre != null) { listaDeOpciones.addAll(opcionesDeOcupanteTerrestre); }
        }

        if (this.ocupanteAereo.existe()) {
            ArrayList<OpcionElegible> opcionesDeOcupanteAereo = this.ocupanteAereo.obtenerOpciones();
            if (opcionesDeOcupanteAereo != null) { listaDeOpciones.addAll(opcionesDeOcupanteAereo); }
        }

        if (this.recurso != null && this.tipo != null) {
            ArrayList<OpcionElegible> opcionesDeRecurso = this.recurso.obtenerOpciones();
            if (opcionesDeRecurso != null) { listaDeOpciones.addAll(opcionesDeRecurso); }
        }

        return listaDeOpciones;

    }

    public boolean celdaConRecurso(){
        return !(recurso instanceof NoRecurso);
    }

    public Recurso obtenerRecurso(){ return recurso;}
    // Sprites:
    public String obtenerSpriteOcupanteTerrestre(){
        if (this.ocupanteTerrestre.existe()) { return this.ocupanteTerrestre.obtenerSprite(); }
        return null;
    }

    public String obtenerSpriteOcupanteAereo() {
        if (this.ocupanteAereo.existe()) { return this.ocupanteAereo.obtenerSprite(); }
        return null;
    }

    public String obtenerSpriteTipo() {
        return this.tipo.obtenerSprite();
    }

    public String obtenerSpriteRecurso() {
        if (this.recurso != null) { return this.recurso.obtenerSprite(); }
        return null;
    }
}
