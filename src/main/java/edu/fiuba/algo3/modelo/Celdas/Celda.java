package edu.fiuba.algo3.modelo.Celdas;

import edu.fiuba.algo3.modelo.Edificios.Edificio;

import java.util.ArrayList;

public interface Celda {
    public void ocupar(Edificio nuevoEdificio);
    public void desocupar();
    public void pasarTurno();
    public boolean esCelda();
    public void setAdyacentes(ArrayList<Celda> adyacentes);
}
