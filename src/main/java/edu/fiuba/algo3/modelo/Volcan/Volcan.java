package edu.fiuba.algo3.modelo.Volcan;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Raza.Raza;

public class Volcan implements Celda {
    private Raza ocupante;

    public void ocupar(Raza criadero) {
        ocupante = criadero;
    }

    @Override
    public void ocupar() {

    }

    @Override
    public void desocupar() {

    }

    @Override
    public void pasarTurno() {

    }
}
