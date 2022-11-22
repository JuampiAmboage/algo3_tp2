package edu.fiuba.algo3.modelo.Edificios;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Raza;

public abstract class Edificio extends Raza implements Construible{
    public Edificio() {}
    public abstract void pasarTurno();
}
