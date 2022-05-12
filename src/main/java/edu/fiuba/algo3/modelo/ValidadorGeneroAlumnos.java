package edu.fiuba.algo3.modelo;

import java.util.List;

public class ValidadorGeneroAlumnos implements Validador {
    private Alumno alumnoNuevo;
    private List<Alumno> alumnos;

    public ValidadorGeneroAlumnos(Alumno alumnoNuevo, List<Alumno> alumnos) {
        this.alumnoNuevo = alumnoNuevo;
        this.alumnos = alumnos;
    }

    @Override
    public void validar() {

        alumnoNuevo.validarCantidadMismoSexo(this.alumnos);
    }
}
