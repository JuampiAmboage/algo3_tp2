package edu.fiuba.algo3.entrega_1.TestCase;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Celdas.CeldaConMoho;
import edu.fiuba.algo3.modelo.Celdas.CeldaEnergizada;
import edu.fiuba.algo3.modelo.Edificios.Acceso;
import edu.fiuba.algo3.modelo.Edificios.Espiral;
import edu.fiuba.algo3.modelo.Edificios.Guarida;
import edu.fiuba.algo3.modelo.Edificios.PuertaEstelar;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class TestCase17 {

    @Test
    public void siNoHayAlMenosUnAccesoUnaPuertaEstelarNoPuedeConstruirse(){
        Celda celda = new Celda(0,0);
        CeldaEnergizada energizada = new CeldaEnergizada(celda); //para poder construir una estructura Protoss
        PuertaEstelar puertaEstelar = new PuertaEstelar();

        celda.cambiarTipo(energizada);
        assertThrows(RuntimeException.class, () -> puertaEstelar.construirEn(celda));
    }

    @Test
    public void siExisteUnAccesoPuedeConstruirseUnaPuertaEstelar(){
        Celda celda = new Celda(0,0);
        CeldaEnergizada energizada = new CeldaEnergizada(celda);
        Acceso acceso = new Acceso();
        PuertaEstelar puertaEstelar = new PuertaEstelar();

        celda.cambiarTipo(energizada);

        assertDoesNotThrow(()->puertaEstelar.construirEn(celda));

    }

    @Test
    public void siNoHayAlMenosUnaGuaridaUnEspiralNoPuedeConstruirse(){
        Celda celda = new Celda(0,0);
        CeldaConMoho celdaConMoho = new CeldaConMoho(celda); //para poder construir una estructura Zerg
        Espiral espiral = new Espiral();

        celda.cambiarTipo(celdaConMoho);
        assertThrows(RuntimeException.class, () -> espiral.construirEn(celda));
    }

    @Test
    public void siExisteUnaGuaridaPuedeConstruirseUnEspiral(){
        Celda celda = new Celda(0,0);
        CeldaConMoho celdaConMoho = new CeldaConMoho(celda);
        Guarida guarida = new Guarida();
        Espiral espiral = new Espiral();

        celda.cambiarTipo(celdaConMoho);

        assertDoesNotThrow(()->espiral.construirEn(celda));
    }
}
