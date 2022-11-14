package edu.fiuba.algo3.modelo.Edificios;

import edu.fiuba.algo3.modelo.Celdas.Celda;

public class Extractor extends Edificio {
    @Override
    public String construir_en(Celda celda) {

        String string = "Soy Extarctor, me constuyo en: " + celda;
        return string;
    }
}
