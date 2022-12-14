package edu.fiuba.algo3.entrega_1.TestCase;

import edu.fiuba.algo3.modelo.Edificios.Asimilador;
import edu.fiuba.algo3.modelo.Edificios.Extractor;
import edu.fiuba.algo3.modelo.Edificios.NexoMineral;
import edu.fiuba.algo3.modelo.Razas.Tropas.Zangano;
import edu.fiuba.algo3.modelo.Recursos.NodoMineral;
import edu.fiuba.algo3.modelo.Recursos.Volcan;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCase07 {


    @Test
    public void siInstancioUnRecolectorConTresZanganosGeneroLaCantidadDeGasCorrecta(){
        Volcan volcan = new Volcan();
        Extractor extractor = new Extractor(volcan);
        for(int i=0;i<3;i++)
            extractor.agregarTrabajador(new Zangano());

        assertEquals(30, extractor.extraerGas());

    }

    //Recoleccion de minerales (Nexo mineral)
    @Test
    public void siInstancioUnAsimiladorYExtraigoCincoVecesTengoLaCantidadDeGasCorrecta() {
        Volcan volcan = new Volcan();
        Asimilador asimilador = new Asimilador(volcan);
        int cantidadExtraida = 0;
        for(int i=0;i<5;i++)
            cantidadExtraida += asimilador.extraerGas(); //extra 20 por vez

        assertEquals(100, cantidadExtraida);
    }


    @Test
    public void siInstancioUnNexoMineralYExtraigoCincoVecesTengoLaCantidadDeMineralCorrecta() {
        NodoMineral nodoMineral = new NodoMineral();
        NexoMineral nexoMineral = new NexoMineral(nodoMineral);
        int cantidadExtraida = 0;
        for(int i=0;i<5;i++)
            cantidadExtraida += nexoMineral.extraerMineral(); //extrae 10 por vez

        assertEquals(50, cantidadExtraida);
    }

    @Test
    public void siInstancioUnZanganoYExtraigoTresVecesTengoLaCantidadDeMineralCorrecta() {
        NodoMineral nodoMineral = new NodoMineral();
        Zangano zangano = new Zangano();
        zangano.construccionInstantanea();
        zangano.asignarTrabajoEnNodo(nodoMineral);
        int cantidadExtraida = 0;
        for(int i=0;i<3;i++)
            cantidadExtraida += zangano.extraerMineral(); //extrae 10 por vez

        assertEquals(30, cantidadExtraida);
    }
}
