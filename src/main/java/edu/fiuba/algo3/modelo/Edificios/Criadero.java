package edu.fiuba.algo3.modelo.Edificios;

import edu.fiuba.algo3.modelo.Celdas.Celda;

public class Criadero extends Edificio {
    @Override
    public String construir_en(Celda celda) {
        String string = "Soy Criadero, me constuyo en: " + celda;
        return string;
    }

}
