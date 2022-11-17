package edu.fiuba.algo3.modelo.Recursos;

import edu.fiuba.algo3.modelo.Edificios.Construible;

public class NoRecurso extends Recurso {
    public NoRecurso(){
        super();
        this.cantidad = 0;
    }

    @Override
    public int extraer(int cantidad) {
        // todo error SIEMPRE
        return 0;
    }
    @Override
    public void quiereConstruir(Construible construible) {
        construible.construirSobreRecurso(this);
    }
}
