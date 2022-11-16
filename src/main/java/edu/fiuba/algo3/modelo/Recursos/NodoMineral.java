package edu.fiuba.algo3.modelo.Recursos;

import edu.fiuba.algo3.modelo.Edificios.Construible;

public class NodoMineral extends Recurso {
    public NodoMineral() {
        super();
        this.cantidad = 2000;
    }
    @Override
    public int extraer(int c) {
        if (c <= this.cantidad) {
            this.cantidad -= c;
            return c;
        } else {
            throw new RuntimeException("No quedan minerales suficientes en este nodo para cumplir con la extracción.");
        }
    }
    @Override
    public void quiereConstruir(Construible construible) {
        construible.construirSobreRecurso(this);
    }
}
