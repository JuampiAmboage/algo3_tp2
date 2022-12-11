package edu.fiuba.algo3.modelo.Recursos;

import edu.fiuba.algo3.modelo.Edificios.Asimilador;
import edu.fiuba.algo3.modelo.Edificios.Construible;
import edu.fiuba.algo3.modelo.Edificios.Edificio;
import edu.fiuba.algo3.modelo.Edificios.Extractor;
import edu.fiuba.algo3.modelo.Excepciones.GasEnVolcanAgotado;

public class Volcan extends Recurso {
    public Volcan() {
        super();
        this.cantidad = 5000;
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
}

