package edu.fiuba.algo3.entrega_1.TestCase;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Celdas.CeldaConMoho;
import edu.fiuba.algo3.modelo.Celdas.CeldaEnergizada;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;


public class TestCase14 {
    @Test
    public void unaCeldaCubiertaPorMohoNoPuedeEnergizarse() {
        Celda celda = new Celda();
        CeldaConMoho celdaConMoho = new CeldaConMoho(celda);
        CeldaEnergizada celdaEnergizada = new CeldaEnergizada(celda);

        celda.cambiarTipo(celdaConMoho);
        celda.cambiarTipo(celdaEnergizada);

        assertFalse(celda.esMismoTipo(celdaEnergizada));
    }

    @Test
    public void unaCeldaEnergizadaPuedeInfectarseConMoho(){
        Celda celda = new Celda();
        CeldaEnergizada celdaEnergizada = new CeldaEnergizada(celda);
        CeldaConMoho celdaConMoho = new CeldaConMoho(celda);

        celda.cambiarTipo(celdaEnergizada);
        celda.cambiarTipo(celdaConMoho);

        assert(celda.esMismoTipo(celdaConMoho));
    }
}
