package edu.fiuba.algo3.modelo.Edificios;

import edu.fiuba.algo3.modelo.Celdas.Celda;

public class Asimilador extends Edificio {


    @Override
    public String construir_en(Celda celda) {
        String string = "Soy asimilador, me constuyo en: " + celda;
        return string;
    }
}
