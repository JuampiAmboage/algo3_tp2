package edu.fiuba.algo3.modelo.Celdas;

import edu.fiuba.algo3.modelo.Edificios.Criadero;
import edu.fiuba.algo3.modelo.Edificios.Edificio;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Razas.Tropas.TropaAerea;
import edu.fiuba.algo3.modelo.Razas.Unidad;
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
    protected String spriteEntidadSobreCelda;

    protected boolean spriteCeldaNoEnviado = true;

    public int cantidadDeMenus = 0;
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

    public void aplicarSpriteOcupante(String spriteOcupante){
        this.spriteEntidadSobreCelda = spriteOcupante;

    }
    public void restablecerSpriteOriginal(){
        this.spriteEntidadSobreCelda = null;
    }
    public boolean esMismaPosicion(Posicion posicion){
        return this.posicion.esMismaPosicion(posicion);
    }
    public void ocuparPorTierra(Unidad ocupante){
        if(!this.estaOcupadaPorTierra()) {
            this.ocupanteTerrestre = ocupante;
        }
        else{
            throw new CeldaOcupada();
        }
    }

    public void ocuparPorAire(TropaAerea ocupanteAereoNuevo){
        if(!this.estaOcupadaPorAire()) {
            this.ocupanteAereo = ocupanteAereoNuevo;
        }else{
            throw new CeldaOcupada();
        }
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
    }

    public Unidad obtenerOcupante(){
        return ocupanteTerrestre;
    }

    public void instanciarUnidad(Unidad unidad){
        unidad.instanciacionesIniciales(posicion);
    }

    public String obtenerSprite() {
        if (this.spriteCeldaNoEnviado){
            this.spriteCeldaNoEnviado = false;
            return this.tipo.obtenerSprite();
        }

        if (this.spriteEntidadSobreCelda != null) {
            return this.tipo.obtenerSprite();
        } else {
            return this.spriteEntidadSobreCelda;
        }
    }

    public ArrayList<String> gestionarOpcionesParaJugador() {

        ArrayList<String> listaDeOpciones = new ArrayList<String>();

        if (this.tipo != null) {
            ArrayList<String> opcionesDeTipo = this.tipo.obtenerOpciones();
            if (opcionesDeTipo != null ) { listaDeOpciones.addAll(opcionesDeTipo); }
            this.cantidadDeMenus++;
        }

        if (this.ocupanteTerrestre != null) {
            ArrayList<String> opcionesDeOcupanteTerrestre = this.ocupanteTerrestre.obtenerOpciones();
            if (opcionesDeOcupanteTerrestre != null) { listaDeOpciones.addAll(opcionesDeOcupanteTerrestre); }
            this.cantidadDeMenus++;
        }

        if (this.ocupanteAereo != null) {
            ArrayList<String> opcionesDeOcupanteAereo = this.ocupanteAereo.obtenerOpciones();
            if (opcionesDeOcupanteAereo != null) { listaDeOpciones.addAll(opcionesDeOcupanteAereo); }
            this.cantidadDeMenus++;
        }

        if (this.recurso != null && this.tipo != null) {
            ArrayList<String> opcionesDeRecurso = this.recurso.obtenerOpciones();
            if (opcionesDeRecurso != null) { listaDeOpciones.addAll(opcionesDeRecurso); }
        }

        return listaDeOpciones;

    }

    public int obtenerCantidadDeMenus() {
        return this.cantidadDeMenus;
    }
}
