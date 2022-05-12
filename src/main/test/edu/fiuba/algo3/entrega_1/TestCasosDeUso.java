package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.*;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestCasosDeUso {

    public static final int CUPO_MAXIMO = 1;

    @Test
    public void unaMateriaDebeTenerCupoMaximo() {
        Materia m = new Materia(CUPO_MAXIMO);

        // ?
        // m.anotarse("Joaquin");
        m.empadronarse(new Alumno("0"));

        assertThrows(CupoMaximoAlcanzado.class, () -> {
            m.empadronarse(new Alumno("1"));
        });
    }

    @Test
    public void unaMateriaDebeTenerCupoMaximoDistinguiendoElPadron() {
        Materia m = new Materia(CUPO_MAXIMO);

        // ?
        // m.anotarse("Joaquin");
        m.empadronarse(new Alumno("1"));

        assertDoesNotThrow(() -> {
            m.empadronarse(new Alumno("1"));
        });

        assertThrows(CupoMaximoAlcanzado.class, () -> {
            m.empadronarse(new Alumno("2"));
        });
    }

    @Test
    public void unaMateriaDebeTenerCupoMaximoDistinguiendoElPadronDeIntercambio() {
        Materia m = new Materia(CUPO_MAXIMO);

        // ?
        // m.anotarse("Joaquin");
        m.empadronarse(new Alumno("b1"));

        assertDoesNotThrow(() -> {
            m.empadronarse(new Alumno("B1"));
        });
    }

    @Test
    public void unaMateriaDebeTenerUnNumeroEquivalenteDeAlumnesPorGeneroFemenino() {
        Materia m = new Materia(2);

        // ?
        // m.anotarse("Joaquin");
        m.empadronarse(new Alumno("b1", new Femenino()));

        assertThrows(CupoSexoInvalido.class, () -> {
            m.empadronarse(new Alumno("a1", new Femenino()));
        });
    }

    @Test
    public void unaMateriaDebeTenerUnNumeroEquivalenteDeAlumnesPorGeneroMasculino() {
        Materia m = new Materia(2);

        // ?
        // m.anotarse("Joaquin");
        m.empadronarse(new Alumno(new Padron("b1"), new Masculino()));

        assertThrows(CupoSexoInvalido.class, () -> {
            m.empadronarse(new Alumno("a1", new Masculino()));
        });
    }

    @Test
    public void unaMateriaDebeTenerUnNumeroEquivalenteDeAlumnesPorGeneroFemeninoMasculino() {
        Materia m = new Materia(2);

        // ?
        // m.anotarse("Joaquin");
        m.empadronarse(new Alumno(new Padron("b1"), new Masculino()));

        assertDoesNotThrow(() -> {
            m.empadronarse(new Alumno("a1", new Femenino()));
        });
    }

    @Test
    public void unaMateriaDebeTenerUnNumeroEquivalenteDeAlumnesPorGeneroFemeninoMasculinoFemenino() {
        Materia m = new Materia(3);

        // ?
        // m.anotarse("Joaquin");
        m.empadronarse(new Alumno(new Padron("b1"), new Masculino()));

        assertDoesNotThrow(() -> {
            m.empadronarse(new Alumno("a1", new Femenino()));
        });

        assertDoesNotThrow(() -> {
            m.empadronarse(new Alumno("c1", new Masculino()));
        });
    }

    @Test
    public void unaMateriaDebeTenerUnNumeroEquivalenteDeAlumnesPorGeneroFemeninoMasculinoFemeninoOtroMasculino() {
        Materia m = new Materia(10);

        // ?
        // m.anotarse("Joaquin");
        m.empadronarse(new Alumno(new Padron("m1"), new Masculino()));

        assertDoesNotThrow(() -> {
            m.empadronarse(new Alumno("f1", new Femenino()));
        });

        assertDoesNotThrow(() -> {
            m.empadronarse(new Alumno("m2", new Masculino()));
        });

        assertDoesNotThrow(() -> {
            m.empadronarse(new Alumno("o1", new Otro()));
        });

        assertThrows(CupoSexoInvalido.class, () -> {
            m.empadronarse(new Alumno("m3", new Masculino()));
        });

    }
}

