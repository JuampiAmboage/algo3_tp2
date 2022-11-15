package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Celdas.*;
import edu.fiuba.algo3.modelo.Comunidad.Comunidad;
import edu.fiuba.algo3.modelo.Edificios.*;
import edu.fiuba.algo3.modelo.Opciones_de_raza;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import static org.junit.jupiter.api.Assertions.*;


public class TestCase05 {
    //Caso de uso #5: Verificar que no se puedan construir edificios fuera del rango de un pilon o fuera del moho.

    @Test
    public void construyoUnedificioDeberiaSaltarExcepcionPorqueNoSePuedeConstruirAhi() {

        CeldaConMoho celdaConMoho = new CeldaConMoho(new Celda);

        Edificio p = new Pilon();



        Executable task = () -> {
            p.construir_en(celdaConMoho);
        };

        assertThrows(RuntimeException.class, task);
    }

}
