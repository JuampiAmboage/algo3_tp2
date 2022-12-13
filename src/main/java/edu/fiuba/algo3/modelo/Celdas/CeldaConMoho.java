package edu.fiuba.algo3.modelo.Celdas;

import edu.fiuba.algo3.modelo.Edificios.Construible;
import edu.fiuba.algo3.modelo.Opciones.OpcionElegible;
import edu.fiuba.algo3.modelo.Rango.RangoExpansible;

import java.util.ArrayList;

public class CeldaConMoho extends TipoCelda {
    RangoExpansible rangoExpansible;

    private final String RUTA_SPRITE = "estados/moho.png";

    public CeldaConMoho() {
        super();
        rangoExpansible = new RangoExpansible(this.celda.posicion, 1);
    }
    public CeldaConMoho(Celda celda) {
        super(celda);
        rangoExpansible = new RangoExpansible(this.celda.posicion, 1);
    }

    private void expandir() {
        rangoExpansible.expandirMoho();
    }

    @Override
    public void setCelda(Celda celda) {
        this.celda = celda;
    }
    @Override
    public void pasarTurno() {
        this.expandir();
    }
    @Override
    public boolean esMismoTipo(Object objeto) {
        return objeto instanceof CeldaConMoho;
    }
    @Override
    protected void cambiarTipoA(CeldaLibre nuevoTipo) {}
    @Override
    protected void cambiarTipoA(CeldaEnergizada nuevoTipo) {}
    @Override
    protected void cambiarTipoA(CeldaConMoho nuevoTipo) {}

    @Override
    public void cambiarTipoDe(Celda c) {
        CeldaConMoho tipo = new CeldaConMoho(c);
        c.tipo.cambiarTipoA(tipo);
    }

    @Override
    public void quiereConstruir(Construible construible) {
        construible.construirSobreTipo(this);
    }

    @Override
    public String obtenerSprite() {
        return (this.sprite + this.RUTA_SPRITE);
    }

    @Override
    public ArrayList<OpcionElegible> obtenerOpciones() { return null; }
}
