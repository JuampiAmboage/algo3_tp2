package edu.fiuba.algo3.modelo;

import java.util.List;

public class Genero {

    @Override
    public boolean equals(Object obj) {


        return this.getClass().equals(obj.getClass());
    }

    public int cantidadMismoSexo(List<Genero> generos) {
        int result = 0;

        for (Genero g : generos) {
            if (g.equals(this)) {
                result++;
            }
        }
        return result;
    }

    public void validarCantidadMismoSexo(int cantDeGeneroIgualAMi, int poblacionTotal, Genero generoNuevo) {

        if (poblacionTotal == 0) {
            return;
        }
        double proporcionEsperada = Math.ceil(.33);
        double proporcionActual = cantDeGeneroIgualAMi + 1 / poblacionTotal;


        if (proporcionActual > Math.ceil(proporcionEsperada)) {
            throw new CupoSexoInvalido();
        }

    }
}
