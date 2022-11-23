package edu.fiuba.algo3.entrega_1.TestCase;

import edu.fiuba.algo3.modelo.Celdas.CeldaEnergizada;
import edu.fiuba.algo3.modelo.Celdas.CeldaLibre;
import edu.fiuba.algo3.modelo.Edificios.Pilon;
import Mapa;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TestCase09 {

    @Test
    public void unAccesoSigueOperativoSiLeDestruyenUnPilonQueLoEnergizaPeroEstaEnElRangoDeOtro(){
        Mapa mapa = Mapa.getInstance();
        mapa.instanciarMapa(8,8);
        Pilon unPilon = new Pilon();
        Pilon otroPilon = new Pilon();
        unPilon.instanciacionInicial(new Posicion(3,3));
        otroPilon.instanciacionInicial(new Posicion(3,4));
        mapa.obtenerCelda(3,3).ocupar(unPilon);
        mapa.obtenerCelda(3,4).ocupar(otroPilon);
        unPilon.desernegizar();
        assertTrue(mapa.obtenerCelda(3,5).esMismoTipo(new CeldaEnergizada()));
    }

    @Test
    public void unaCeldaNoEstaMasEnergizadaSiSeDestruyeUnPilon(){
        Mapa mapa = Mapa.getInstance();
        mapa.instanciarMapa(8,8);
        Pilon unPilon = new Pilon();
        unPilon.instanciacionInicial(new Posicion(3,3));
        mapa.obtenerCelda(3,3).ocupar(unPilon);
        unPilon.desernegizar();
        assertTrue(mapa.obtenerCelda(3,5).esMismoTipo(new CeldaLibre()));

    }
}
