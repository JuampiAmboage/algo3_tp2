package edu.fiuba.algo3.entrega_1.TestCase;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Recursos.NodoMineral;
import edu.fiuba.algo3.modelo.Recursos.Volcan;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestCase15 {

    @Test
    public void siUnVolcanSeQuedaSinGasNoSePuedeSeguirRecolectando(){
        Celda celda = new Celda();
        Volcan volcan = new Volcan();
        celda.agregarRecurso(volcan); //volcan arranca con 5000 de gas
        celda.extraer(2500);
        celda.extraer(2500);
        assertThrows(RuntimeException.class, ()-> celda.extraer(2500));
    }

    @Test
    public void siUnNodoMineralSeQuedaSinMineralNoSePuedeSeguirRecolectando(){
        Celda celda = new Celda();
        NodoMineral nodoMineral = new NodoMineral(); //nodo mineral empieza con 2000 de mineral
        celda.agregarRecurso(nodoMineral);
        celda.extraer(1500);
        assertThrows(RuntimeException.class, ()-> celda.extraer(1500));
    }

    @Test
    public void puedoExtraerGasDeUnVolcanHastaQueSuGasSeaCero(){
        Celda celda = new Celda();
        Volcan volcan = new Volcan();
        celda.agregarRecurso(volcan); //volcan arranca con 5000 de gas
        for(int i =0;i <4; i++){
            celda.extraer(1000); //saco 4k
        }
        assertEquals(1000,celda.extraer(1000)); //queda en 0
        assertThrows(RuntimeException.class, ()-> celda.extraer(1));
    }

    @Test
    public void puedoExtraerMineralDeUnNodoHastaQueSuMineralSeaCero(){
        Celda celda = new Celda();
        NodoMineral nodoMineral = new NodoMineral();
        celda.agregarRecurso(nodoMineral); //nodo mineral arranca con 2000
        for(int i =0;i <3; i++){
            celda.extraer(500); //saco 1500
        }
        assertEquals(500,celda.extraer(500)); //queda en 0
        assertThrows(RuntimeException.class, ()-> celda.extraer(1));
    }

}
