package edu.fiuba.algo3.entrega_1.TestCase;
import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Celdas.CeldaConMoho;
import edu.fiuba.algo3.modelo.Edificios.Criadero;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class TestCase13 {

    @Test
    public void siSeDistruyeUnCriaderoSePuedeSeguirConstruyendoEnElMoho() {
        Criadero criadero = new Criadero();
        Criadero otroCriadero = new Criadero();
        Celda celda = new Celda(0,0);
        CeldaConMoho celdaConMoho = new CeldaConMoho(celda);

        celda.cambiarTipo(celdaConMoho);
        celda.ocupar(criadero);
        celda.desocupar();

        assertDoesNotThrow(()->celda.ocupar(otroCriadero));
    }
}
