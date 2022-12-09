package edu.fiuba.algo3.modelo.Partida;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Comunidad.Comunidad;
import edu.fiuba.algo3.modelo.Edificios.Edificio;
import edu.fiuba.algo3.modelo.Razas.Unidad;

public class Jugador {
    private String nombre;
    Comunidad comunidad;

    public Jugador(String nombre, Comunidad comunidad) {
        this.nombre = nombre;
        this.comunidad = comunidad;
        this.comunidad.inicializarBase();
    }

    public void construir(Edificio edificioAConstruir, Celda celda){
       // comunidad.construirEdificio(celda,edificioAConstruir);
    }
}
