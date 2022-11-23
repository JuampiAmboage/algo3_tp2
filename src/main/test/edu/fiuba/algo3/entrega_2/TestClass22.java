package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.Comunidad.ComunidadZerg;
import edu.fiuba.algo3.modelo.Razas.Zangano;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestClass22 {
    @Test
    public void siUnConstruyoUnCriaderoGeneroUnZanganoQueTardaLoQueCorrespondeEnConstruirse(){
        Zangano zangano = new Zangano();
        ComunidadZerg.obtenerInstanciaDeClase().agregarUnidad(zangano);
        assertThrows(RuntimeException.class,()->ComunidadZerg.obtenerInstanciaDeClase().buscarUnidad(zangano));
    }

    @Test
    public void si(){
        Zangano zangano = new Zangano();
        ComunidadZerg comunidadZerg = ComunidadZerg.obtenerInstanciaDeClase();
        comunidadZerg.agregarUnidad(zangano);
        comunidadZerg.pasarTurno();
        assertDoesNotThrow(()->comunidadZerg.buscarUnidad(zangano));
    }

}
