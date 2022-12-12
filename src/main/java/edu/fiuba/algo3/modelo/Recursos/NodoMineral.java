package edu.fiuba.algo3.modelo.Recursos;

import edu.fiuba.algo3.modelo.Edificios.Construible;
import edu.fiuba.algo3.modelo.Excepciones.MineralEnNodoAgotado;

import java.util.ArrayList;

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
            throw new MineralEnNodoAgotado();
        }
    }
    @Override
    public void quiereConstruir(Construible construible) {
        construible.construirSobreRecurso(this);
    }

    public ArrayList<String> obtenerOpciones() { return null; }
}
