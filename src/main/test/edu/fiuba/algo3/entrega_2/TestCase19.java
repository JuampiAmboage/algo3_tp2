package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.Excepciones.TropaSinAtaqueAereo;
import edu.fiuba.algo3.modelo.Partida.Mapa;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Razas.Tropas.Mutalisco;
import edu.fiuba.algo3.modelo.Razas.Tropas.Scout;
import edu.fiuba.algo3.modelo.Razas.Tropas.Zerling;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;



public class TestCase19 {
    @Test
    public void siUnaUnidadTerrestreSinAtaqueAereoAtacaAUnaUnidadAereaLanzaError() {
        Zerling zerling = new Zerling();
        Mutalisco mutalisco = new Mutalisco();
        assertThrows(TropaSinAtaqueAereo.class, () -> zerling.atacarAire(mutalisco));
    }
    @Test
    public void siUnaUnidadConAtaqueAereoAtacaAUnaUnidadAereaElAtaqueEsEfectivo(){
        Mapa mapa = Mapa.getInstance();
        mapa.instanciarMapa(6,6);
        Mutalisco mutalisco = new Mutalisco(); //el mutalisco empieza con 80 de vida
        Scout scout = new Scout(); //cuando el scout ataca a una unidad aerea hace 14 de daño
        mutalisco.instanciacionesIniciales(new Posicion(3,4));
        scout.instanciacionesIniciales(new Posicion(3,3));
        mapa.obtenerCelda(new Posicion(3,4)).ocuparPorTierra(scout);
        mapa.obtenerCelda(new Posicion(3,3)).ocuparPorAire(mutalisco);
        scout.atacarAire(mutalisco);
        assertEquals(66,mutalisco.obtenerVida());
    }
    @Test
    public void siUnaUnidadConAtaqueTerrestreAtacaAOtraTerrestreElAtaqueEsEfectivo(){
        Mapa mapa = Mapa.getInstance();
        mapa.instanciarMapa(9,9);
        Zerling zerling =  new Zerling(); //el zerling empieza con 35 de vida
        Scout scout = new Scout(); //cuando el scout ataca a una unidad terrestre hace 8 de daño
        zerling.instanciacionesIniciales(new Posicion(5,5));
        scout.instanciacionesIniciales(new Posicion(5,7));
        mapa.obtenerCelda(new Posicion(5,5)).ocuparPorTierra(zerling);
        mapa.obtenerCelda(new Posicion(5,7)).ocuparPorAire(scout);
        scout.atacarTierra(zerling);
        assertEquals(27,zerling.obtenerVida());
    }
}
