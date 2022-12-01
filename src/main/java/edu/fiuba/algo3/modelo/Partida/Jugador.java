package edu.fiuba.algo3.modelo.Partida;

import edu.fiuba.algo3.modelo.Comunidad.Comunidad;
import edu.fiuba.algo3.modelo.Comunidad.ComunidadZerg;
import edu.fiuba.algo3.modelo.Razas.Unidad;

public class Jugador {
    private String nombre, color;
    private Comunidad comunidad;

    public Jugador(String nombre, Unidad[] raza) {
        this.nombre = nombre;
        this.comunidad = ComunidadZerg.obtenerInstanciaDeClase();
    }

    public void crearUnidad(String unidadACrear){

    }
}
