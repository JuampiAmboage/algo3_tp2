package edu.fiuba.algo3.entrega_1.TestCase;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Edificios.Asimilador;
import edu.fiuba.algo3.modelo.Edificios.Extractor;
import edu.fiuba.algo3.modelo.Edificios.NexoMineral;
import edu.fiuba.algo3.modelo.Razas.Zangano;
import edu.fiuba.algo3.modelo.Recursos.NodoMineral;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCase07 {


    @Test
    public void siInstancioUnRecolectorConTresZanganosGeneroLaCantidadDeGasCorrecta(){
        Extractor extractor = new Extractor();
        for(int i=0;i<3;i++)
            extractor.agregarTrabajador(new Zangano());

        assertEquals(30, extractor.extraerGas());

    }

    //Recoleccion de minerales (Nexo mineral)
    @Test
    public void siInstancioUnAsimiladorYExtraigoCincoVecesTengoLaCantidadDeGasCorrecta() {
        Asimilador asimilador = new Asimilador();
        int cantidadExtraida = 0;
        for(int i=0;i<5;i++)
            cantidadExtraida += asimilador.extraerGas(); //extra 20 por vez

        assertEquals(100, cantidadExtraida);
    }

}
