package edu.fiuba.algo3.modelo;

import java.util.List;

public class ValidadorCantidad implements Validador {
    private int cupoMaximo;
    private List<Alumno> alumnos;

    public ValidadorCantidad(int cupoMaximo, List<Alumno> alumnos) {

        this.cupoMaximo = cupoMaximo;
        this.alumnos = alumnos;
    }

    @Override
    public void validar() {
        if (this.alumnos.size() + 1 > cupoMaximo) {
            throw new CupoMaximoAlcanzado();
        }
    }
}
