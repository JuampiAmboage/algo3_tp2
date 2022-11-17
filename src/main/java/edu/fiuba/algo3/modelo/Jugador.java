package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Comunidad.Comunidad;
import edu.fiuba.algo3.modelo.Edificios.Edificio;

public class Jugador {
    private String nombre, color;
    Comunidad comunidad;

    public Jugador(String nombre, Racita[] raza) {
        this.nombre = nombre;
        this.comunidad = new Comunidad(raza);
    }

    public void construir(Edificio edificioAConstruir, Celda celda){
        comunidad.agregarEdificio(edificioAConstruir);
        edificioAConstruir.construirEn(celda);
    }
}
