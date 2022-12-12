package edu.fiuba.algo3.modelo.Recursos;

import edu.fiuba.algo3.modelo.Edificios.Asimilador;
import edu.fiuba.algo3.modelo.Edificios.Construible;
import edu.fiuba.algo3.modelo.Edificios.Edificio;
import edu.fiuba.algo3.modelo.Edificios.Extractor;
import edu.fiuba.algo3.modelo.Excepciones.GasEnVolcanAgotado;

import java.util.ArrayList;

public class Volcan extends Recurso {
    public Volcan() {
        super();
        this.cantidad = 5000;
        this.rutaSprite = this.rutaSprite + "volcan.png";
        this.opciones.add()
    }

    @Override
    public int extraer(int c) {
        if (c <= this.cantidad) {
            this.cantidad -= c;
            return c;
        } else {
            throw new GasEnVolcanAgotado();
        }
    }
    @Override
    public void quiereConstruir(Construible construible) {
        construible.construirSobreRecurso(this);
    }

    @Override
    public ArrayList<String> obtenerOpciones() { return null; }

    @Override
    public String obtenerSprite() { return this.rutaSprite; }
}

