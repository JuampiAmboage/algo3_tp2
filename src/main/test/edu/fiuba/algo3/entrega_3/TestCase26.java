package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.modelo.Comunidad.ComunidadZerg;
import edu.fiuba.algo3.modelo.Excepciones.PoblacionMaximaAlcanzada;
import edu.fiuba.algo3.modelo.Razas.Tropas.Zangano;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestCase26 {
    @Test
    public void sinSuministrosNoSePuedeConstruir(){
        ComunidadZerg.obtenerInstanciaDeClase().restarCapacidadSuministro(200);
        assertThrows(PoblacionMaximaAlcanzada.class,()->ComunidadZerg.obtenerInstanciaDeClase().agregarUnidad(new Zangano()));

    }
}
