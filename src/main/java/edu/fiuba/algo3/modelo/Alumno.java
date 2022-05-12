package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

public class Alumno {
    private Id padron;
    private Genero genero;

    public Alumno(String padron) {

        this.padron = new Padron(padron);
        this.genero = new Femenino();
    }

    public Alumno(String padron, Genero genero) {

        this.padron = new Padron(padron);
        this.genero = genero;
    }

    public Alumno(Padron padron, Genero genero) {
        this.padron = padron;
        this.genero = genero;
    }

    public boolean es(Alumno otro) {

        return this.padron.equals(otro.padron);
    }

    public void validarCantidadMismoSexo(List<Alumno> alumnos) {
        int cantConMiMismoGenero = this.cantidadMismoGeneroQueYo(alumnos);

        this.genero.validarCantidadMismoSexo(
                cantConMiMismoGenero,
                alumnos.size(),
                this.genero);
    }

    private int cantidadMismoGeneroQueYo(List<Alumno> alumnos) {
        List<Genero> generos = new ArrayList<>();

        for (Alumno a : alumnos) {

            if (this.genero.equals(a.genero)) {
                generos.add(a.genero);
            }
        }

        return genero.cantidadMismoSexo(generos);

    }
}
