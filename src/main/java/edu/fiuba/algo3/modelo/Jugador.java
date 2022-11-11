package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Comunidad.Comunidad;

public class Jugador {
    private String nombre, color;
    Comunidad comunidad;

    public Jugador(String nombre, Comunidad comunidad, String raza){
        this.nombre = nombre;
        this.comunidad = new Comunidad(raza);
    }
}
