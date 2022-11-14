package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Edificios.Asimilador;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class EdificioTest {

    @Test
    public void test_construir_un_asimilador(){
        Celda c = new Celda();
        String espero = "Soy asimilador, me constuyo en: " + c;

        Asimilador a = new Asimilador();

        assertEquals(espero, a.construir_en(c));

    }

}
