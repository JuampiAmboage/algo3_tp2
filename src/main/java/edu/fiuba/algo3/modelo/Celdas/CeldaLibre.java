package edu.fiuba.algo3.modelo.Celdas;

import edu.fiuba.algo3.modelo.Edificios.Construible;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class CeldaLibre extends TipoCelda {

    private final String[] opcionSprite = new String[3];

    public CeldaLibre() {
        super();
    }
    public CeldaLibre(Celda celda) {
        super(celda);
        this.opcionSprite[0] = "celdaLibre00.png";
        this.opcionSprite[1] = "celdaLibre01.png";
        this.opcionSprite[2] = "celdaLibre02.png";
    }

    @Override
    public void setCelda(Celda celda) {
        this.celda = celda;
    }
    @Override
    public void pasarTurno() {}
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
        int maximo = 3;
        Random random = new Random();

        int eleccionRandom = random.nextInt(maximo);

        return (this.sprite + this.opcionSprite[eleccionRandom]);
    }
}
