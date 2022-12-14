package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Comunidad.Comunidad;
import edu.fiuba.algo3.modelo.Comunidad.ComunidadProtoss;
import edu.fiuba.algo3.modelo.Comunidad.ComunidadZerg;
import edu.fiuba.algo3.modelo.Edificios.Criadero;
import edu.fiuba.algo3.modelo.Edificios.Pilon;
import edu.fiuba.algo3.modelo.Partida.Mapa;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Razas.Tropas.AmoSupremo;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestCase31 {
    @Test
    public void siDestruyoUnPilonDisminuyeLaCapacidadDeSuministro(){
        Mapa mapa = Mapa.getInstance();
        Comunidad comunidad = ComunidadProtoss.obtenerInstanciaDeClase();
        Pilon pilon = new Pilon();
        mapa.instanciarMapa();
        Celda celda = mapa.obtenerCelda(new Posicion(2,2));

        pilon.instanciacionesIniciales(new Posicion(2,2)); //añade 5 de capacidad
        celda.ocuparPorTierra(pilon);

        comunidad.agregarUnidad(pilon);
        pilon.disminuirVida(600);
        assertEquals(1,comunidad.obtenerSuministro());
    }

    @Test
    public void siDestruyoUnCriaderoDisminuyeLaCapacidadDeSuministro(){
        Criadero criadero = new Criadero();
        Comunidad comunidad = ComunidadZerg.obtenerInstanciaDeClase();
        comunidad.agregarUnidad(criadero);
        criadero.aniadirSuministro();
        criadero.disminuirVida(500);
        assertEquals(1,comunidad.obtenerSuministro());
    }

    @Test
    public void siDestruyoUnAmoSupremoDisminuyeLaCapacidadDeSuministro(){
        AmoSupremo amoSupremo = new AmoSupremo();
        Comunidad comunidad = ComunidadZerg.obtenerInstanciaDeClase();
        comunidad.aniadirMineral(50);
        comunidad.agregarUnidad(amoSupremo);
        amoSupremo.aniadirSuministro();
        amoSupremo.disminuirVida(200);
        assertEquals(1,comunidad.obtenerSuministro());
    }
}
