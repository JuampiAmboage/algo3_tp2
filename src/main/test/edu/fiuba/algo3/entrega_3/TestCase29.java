package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.modelo.Comunidad.ComunidadProtoss;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestCase29 {

    @Test
    public void siSeLlegaAlLimiteDeSuministroNoPuedoSeguirSumando() {
        ComunidadProtoss.obtenerInstanciaDeClase().aniadirCapacidadSuministro(500);
        assertEquals(200,ComunidadProtoss.obtenerInstanciaDeClase().obtenerSuministro());
    }

    @Test
    public void siLlegoACeroNoPuedoSeguirRestandoSuministro() {
        ComunidadProtoss.obtenerInstanciaDeClase().restarCapacidadSuministro(500);
        assertEquals(0,ComunidadProtoss.obtenerInstanciaDeClase().obtenerSuministro());
    }
}
