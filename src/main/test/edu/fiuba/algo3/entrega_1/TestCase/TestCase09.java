package edu.fiuba.algo3.entrega_1.TestCase;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Celdas.CeldaEnergizada;
import edu.fiuba.algo3.modelo.Celdas.CeldaLibre;
import edu.fiuba.algo3.modelo.Edificios.Pilon;
import edu.fiuba.algo3.modelo.Partida.Mapa;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestCase09 {

    @Test
    public void unAccesoSigueOperativoSiLeDestruyenUnPilonQueLoEnergizaPeroEstaEnElRangoDeOtro(){
        Mapa mapa = Mapa.getInstance();
        mapa.instanciarMapa();
        Pilon unPilon = new Pilon();
        Pilon otroPilon = new Pilon();
        unPilon.instanciacionesIniciales(new Posicion(3,3));
        otroPilon.instanciacionesIniciales(new Posicion(3,4));
        mapa.obtenerCelda(new Posicion(3,3)).ocuparPorTierra(unPilon);
        mapa.obtenerCelda(new Posicion(3,4)).ocuparPorTierra(otroPilon);
        unPilon.desernegizar();
        Celda celdaEnRangoDePilones = mapa.obtenerCelda(new Posicion(3,5));
        assertTrue(celdaEnRangoDePilones.esMismoTipo(new CeldaEnergizada(celdaEnRangoDePilones)));
    }

    @Test
    public void unaCeldaNoEstaMasEnergizadaSiSeDestruyeUnPilon(){
        Mapa mapa = Mapa.getInstance();
        //mapa.instanciarMapa(8,8);
        mapa.instanciarMapa();
        Pilon unPilon = new Pilon();
        unPilon.instanciacionesIniciales(new Posicion(5,5));
        mapa.obtenerCelda(new Posicion(5,5)).ocuparPorTierra(unPilon);
        unPilon.desernegizar();
        Celda celdaDesernegizada = mapa.obtenerCelda(new Posicion(5,7));
        assertTrue(celdaDesernegizada.esMismoTipo(new CeldaLibre(celdaDesernegizada)));

    }
}
