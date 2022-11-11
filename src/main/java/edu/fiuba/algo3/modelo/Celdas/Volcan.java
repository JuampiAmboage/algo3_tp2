package edu.fiuba.algo3.modelo.Celdas;

import edu.fiuba.algo3.modelo.Celdas.CeldaConRecursos;

public class Volcan extends CeldaConRecursos {

    public Volcan(int cantidadRecurso){
        super();
        cantidadRestanteRecurso = 5000;
    }
    private boolean suficienteGas() {
        return (cantidadRestanteRecurso - 10) >= 0;
    }

    public int obtenerCantidadGas() {
        return cantidadRestanteRecurso;
    }

    public void extraerRecurso() {
        if (suficienteGas())
            cantidadRestanteRecurso -= 10;
        else{ //provisorio, iría una excepción
            System.out.println("La cantidad de gas restante no es suficiente para abastecer la extracción");
        }
    }
}