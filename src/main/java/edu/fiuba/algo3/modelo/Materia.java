package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

public class Materia {
    private int cupoMaximo;
    private List<Alumno> alumnos;

    public Materia(int cupoMaximo) {

        this.cupoMaximo = cupoMaximo;
        this.alumnos = new ArrayList<>();
    }

    public void empadronarse(Alumno alumnoNuevo) {
        if (this.estaInscripto(alumnoNuevo)) {
            return;
        }

        List<Validador> validadores = new ArrayList<>();

        validadores.add(new ValidadorCantidad(cupoMaximo, this.alumnos));
        validadores.add(new ValidadorGeneroAlumnos(alumnoNuevo, this.alumnos));

        for (Validador v : validadores) {
            v.validar();
        }

        this.alumnos.add(alumnoNuevo);
    }

    private boolean estaInscripto(Alumno otro) {
        return this.alumnos.stream()
                .anyMatch((a) -> a.es(otro));
    }
}
