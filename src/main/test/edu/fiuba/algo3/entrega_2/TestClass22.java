package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.Comunidad.ComunidadZerg;
import edu.fiuba.algo3.modelo.Razas.Zangano;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestClass22 {
    @Test
    public void siUnConstruyoUnCriaderoGeneroUnZanganoQueTardaLoQueCorrespondeEnConstruirse(){
        Zangano zangano = new Zangano();
        ComunidadZerg.obtenerInstanciaDeClase().agregarUnidad(zangano);
        assertTrue(ComunidadZerg.obtenerInstanciaDeClase().existeUnidad(zangano));
    }

    @Test
    public void si(){
        Zangano zangano = new Zangano();
        ComunidadZerg comunidadZerg = ComunidadZerg.obtenerInstanciaDeClase();
        comunidadZerg.agregarUnidad(zangano);
        comunidadZerg.pasarTurno();
        assertTrue(comunidadZerg.existeUnidad(zangano));
    }

}
