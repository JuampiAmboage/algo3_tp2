package edu.fiuba.algo3.entrega_1.Volcan;

import edu.fiuba.algo3.entrega_1.Raza.Raza;

public class Volcan implements Celda{
    private Raza ocupante;

    public void ocupar(Raza criadero) {
        ocupante = criadero;
    }
}
