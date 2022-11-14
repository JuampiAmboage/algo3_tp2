package edu.fiuba.algo3.modelo.Edificios;

import edu.fiuba.algo3.modelo.Celdas.Celda;

public class Pilon extends Edificio {
    @Override
    public void construir_en(Celda celda) {
        System.out.println("Soy pilon, me constuyo en: " + celda);
    }

}
