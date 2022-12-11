package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Razas.Tropas.Mutalisco;
import edu.fiuba.algo3.modelo.Razas.Tropas.Zerling;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestCase20 {

    @Test
    public void soloUnidadesVoladorasPuedenIrPorCeldasAereas(){
        Celda celda = new Celda(0,0);
        Mutalisco mutalisco = new Mutalisco();
        assertDoesNotThrow(()->celda.ocuparPorAire(mutalisco));
    }

}
