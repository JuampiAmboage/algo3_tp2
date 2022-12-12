package edu.fiuba.algo3.modelo.Celdas;

import edu.fiuba.algo3.modelo.Edificios.Construible;

public class CeldaEnergizada extends TipoCelda{
    private int energia = 0;
    private final String RUTA_SPRITE = "estado/energizada.png";

    public CeldaEnergizada(){
        super();
        this.energia++;
        opciones.add("Construir");
    }
    public CeldaEnergizada(Celda celda) {
        super(celda);
        this.energia++;
        opciones.add("Construir");
    }

    @Override
    public void setCelda(Celda celda) {
        this.celda = celda;
    }
    @Override
    public void pasarTurno() {}
    @Override
    public boolean esMismoTipo(Object objeto) {
        return objeto instanceof CeldaEnergizada;
    }
    @Override
    protected void cambiarTipoA(CeldaLibre nuevoTipo) {
        this.energia--;
        if (energia <= 0) {
            this.celda.tipo = nuevoTipo;
        }
    }
    @Override
    protected void cambiarTipoA(CeldaEnergizada nuevoTipo) {
        this.energia++;
    }
    @Override
    protected void cambiarTipoA(CeldaConMoho nuevoTipo) {
        this.celda.tipo = nuevoTipo;
    }
    @Override
    public void cambiarTipoDe(Celda c) {
        CeldaEnergizada tipo = new CeldaEnergizada(c);
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
}
