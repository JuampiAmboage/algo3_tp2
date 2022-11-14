package edu.fiuba.algo3.modelo.Recursos;

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
            // todo error
            return 0;
        }
    }

    @Override
    public boolean esIgualA(Object objeto) {
        return objeto instanceof NodoMineral;
    }
}
