package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Celdas.CeldaConMoho;
import edu.fiuba.algo3.modelo.Comunidad.Comunidad;
import edu.fiuba.algo3.modelo.Opciones_de_raza;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestCase05 {
    //Caso de uso #5: Verificar que no se puedan construir edificios fuera del rango de un pilon o fuera del moho.

    @Test
    public void construyoUnedificioDeberiaSaltarExcepcionPorqueNoSePuedeConstruirAhi() {
        Celda celdaSinMoho = new Celda();
        CeldaConMoho celdaConMoho = new CeldaConMoho(celdaSinMoho);

        celdaConMoho.construirEdificio();

        //Assert que no salte la excepcion de que no se puede construir ahi
        assertFalse();
    }

}
