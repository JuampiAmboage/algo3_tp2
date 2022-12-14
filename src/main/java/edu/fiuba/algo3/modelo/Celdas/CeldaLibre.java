package edu.fiuba.algo3.modelo.Celdas;

import edu.fiuba.algo3.modelo.Edificios.Construible;

import edu.fiuba.algo3.modelo.Opciones.OpcionElegible;

import java.util.ArrayList;

public class CeldaLibre extends TipoCelda {

    private final String[] opcionSprite = new String[3];

    public CeldaLibre() {
        super();
    }
    public CeldaLibre(Celda celda) {
        super(celda);
        this.opcionSprite[0] = "celdaLibre00.png";
    }

    @Override
    public void setCelda(Celda celda) {
        this.celda = celda;
    }
    @Override
    public void pasarTurno() {}

    /*@Override
    public void mostrarDescripcion(){
        System.out.println("-Celda vacía-");
    }*/
    @Override
    public boolean esMismoTipo(Object objeto) {
        return objeto instanceof CeldaLibre;
    }

    @Override
    protected void cambiarTipoA(CeldaLibre nuevoTipo) {
        this.celda.tipo = nuevoTipo;
    }
    @Override
    protected void cambiarTipoA(CeldaEnergizada nuevoTipo) {
        this.celda.tipo = nuevoTipo;
    }
    @Override
    protected void cambiarTipoA(CeldaConMoho nuevoTipo) {
        this.celda.tipo = nuevoTipo;
    }
    @Override
    public void cambiarTipoDe(Celda c) {
        CeldaLibre tipo = new CeldaLibre(c);
        c.tipo.cambiarTipoA(tipo);
    }
    @Override
    public void quiereConstruir(Construible construible) {
        construible.construirSobreTipo(this);
    }

    @Override
    public String obtenerSprite() {
        return (this.sprite + this.opcionSprite[0]);
    }

    @Override
    public ArrayList<OpcionElegible> obtenerOpciones() { return null; }

    @Override
    public String obtenerDescripcion() {
        String descripcion = "";
        return descripcion;
    }
}
