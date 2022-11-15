package edu.fiuba.algo3.entrega_1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCase07 {

    //Caso de uso #7: Verificar la recolección de minerales para ambas razas.
    @Test
    //Recoleccion de gas
    public void caso07_1(){
        int extraido;

        Zangano zangano = new Zangano();
        Zangano[] zanganosTrabajadores = new Zangano[3];

        Partida partida = new partida();

        //Extractor extractor = zangano.construirExtractor();

        zanganosTrabajadores[0] = zangano;

        for (int i = 0; i == 3; i++) {
            partida.pasarTurno();
            extraido = extractor.extraerGas(zanganosTrabajadores);
        }

        assertEquals(30, extraido);

    }

    //Recoleccion de minerales (Nexo mineral)
    @Test
    public void caso07_2() {
        NexoMineral nexo = new NexoMineral();
        Partida partida = new Partida();

        partida.pasarTurno();

        assertEquals(5, nexo.minar());
    }

}
