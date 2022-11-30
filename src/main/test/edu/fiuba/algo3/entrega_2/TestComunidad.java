package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.Comunidad.ComunidadZerg;
import edu.fiuba.algo3.modelo.Razas.Zangano;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;


public class TestComunidad {
    @Test
    public void hola(){
        ComunidadZerg comunidadZerg = ComunidadZerg.obtenerInstanciaDeClase();
        Zangano zangano = new Zangano();
        Zangano otroZangano = new Zangano();
        comunidadZerg.agregarUnidad(zangano);
        for(int i=0;i<10;i++)
            comunidadZerg.pasarTurno();
        assertDoesNotThrow(()->comunidadZerg.buscarUnidad(otroZangano));
    }
}
