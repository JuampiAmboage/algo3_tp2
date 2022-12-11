package edu.fiuba.algo3.modelo.Partida;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Comunidad.Comunidad;
import edu.fiuba.algo3.modelo.Comunidad.ComunidadProtoss;
import edu.fiuba.algo3.modelo.Comunidad.ComunidadZerg;
import edu.fiuba.algo3.modelo.Edificios.Criadero;
import edu.fiuba.algo3.modelo.Edificios.Edificio;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Razas.Tropas.Tropa;
import edu.fiuba.algo3.modelo.Razas.Unidad;
import edu.fiuba.algo3.modelo.Razas.Zangano;

public class Jugador {
    private String nombre;
    Comunidad comunidad;

    public Jugador(String nombre, Comunidad comunidad) {
        this.nombre = nombre;
        this.comunidad = comunidad;
        this.comunidad.inicializarBase();
    }

    public void crearTropaZerg(Tropa unidadACrear, Celda celdaALocalizar, Criadero criaderoQueGenera,String png) {
        ComunidadZerg.obtenerInstanciaDeClase().crearUnidad(criaderoQueGenera,unidadACrear);
        unidadACrear.ocuparCelda(celdaALocalizar);
        unidadACrear.modificarSpriteEnCeldaContenedora(celdaALocalizar);
        celdaALocalizar.instanciarUnidad(unidadACrear);

    }
    public void construirEdificioZerg(Celda celda, Edificio edificioAConstruir, Zangano zanganoQueEvoluciona,String png){
       ComunidadZerg.obtenerInstanciaDeClase().construirEdificio(celda,zanganoQueEvoluciona,edificioAConstruir);
        edificioAConstruir.modificarSpriteEnCeldaContenedora(celda);
        celda.instanciarUnidad(edificioAConstruir);
    }

    public void crearTropaProtoss(Tropa unidadACrear, Celda celdaALocalizar, String png){
        ComunidadProtoss.obtenerInstanciaDeClase().agregarUnidad(unidadACrear);
        unidadACrear.ocuparCelda(celdaALocalizar);
        unidadACrear.modificarSpriteEnCeldaContenedora(celdaALocalizar);
        celdaALocalizar.instanciarUnidad(unidadACrear);
    }

    public void construirEdificioProtoss(Celda celda, Edificio edificioAConstruir,String png){
        ComunidadProtoss.obtenerInstanciaDeClase().construirEdificio(celda,edificioAConstruir);
        celda.instanciarUnidad(edificioAConstruir);
        edificioAConstruir.modificarSpriteEnCeldaContenedora(celda);
    }
}
