package edu.fiuba.algo3.entrega_1.TestCase;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Celdas.CeldaConMoho;
import edu.fiuba.algo3.modelo.Celdas.CeldaEnergizada;
import edu.fiuba.algo3.modelo.Comunidad.ComunidadProtoss;
import edu.fiuba.algo3.modelo.Comunidad.ComunidadZerg;
import edu.fiuba.algo3.modelo.Edificios.Acceso;
import edu.fiuba.algo3.modelo.Edificios.Espiral;
import edu.fiuba.algo3.modelo.Edificios.Guarida;
import edu.fiuba.algo3.modelo.Edificios.PuertoEstelar;
import edu.fiuba.algo3.modelo.Excepciones.EdificioHabilitadorNoCreado;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class TestCase17 {

    @Test
    public void siNoHayAlMenosUnAccesoUnaPuertaEstelarNoPuedeConstruirse(){
        Celda celda = new Celda(0,0);
        CeldaEnergizada energizada = new CeldaEnergizada(celda); //para poder construir una estructura Protoss
        PuertoEstelar puertaEstelar = new PuertoEstelar();

        celda.cambiarTipo(energizada);
        assertThrows(EdificioHabilitadorNoCreado.class, () -> celda.quiereConstruir(puertaEstelar));
    }

    @Test
    public void siExisteUnAccesoPuedeConstruirseUnaPuertaEstelar(){
        Celda celda = new Celda(0,0);
        CeldaEnergizada energizada = new CeldaEnergizada(celda);
        Acceso acceso = new Acceso();
        PuertoEstelar puertaEstelar = new PuertoEstelar();

        celda.cambiarTipo(energizada);
        ComunidadProtoss.obtenerInstanciaDeClase().agregarUnidad(acceso);
        acceso.construccionInstantanea();

        assertDoesNotThrow(()->celda.quiereConstruir(puertaEstelar));

    }

    @Test
    public void siNoHayAlMenosUnaGuaridaUnEspiralNoPuedeConstruirse(){
        Celda celda = new Celda(0,0);
        CeldaConMoho celdaConMoho = new CeldaConMoho(celda); //para poder construir una estructura Zerg
        Espiral espiral = new Espiral();

        celda.cambiarTipo(celdaConMoho);
        assertThrows(EdificioHabilitadorNoCreado.class, () -> celda.quiereConstruir(espiral));
    }

    @Test
    public void siExisteUnaGuaridaPuedeConstruirseUnEspiral(){
        Celda celda = new Celda(0,0);
        ComunidadZerg.obtenerInstanciaDeClase().aniadirGasVespeno(100);
        CeldaConMoho celdaConMoho = new CeldaConMoho(celda);
        Guarida guarida = new Guarida();
        Espiral espiral = new Espiral();

        celda.cambiarTipo(celdaConMoho);
        ComunidadZerg.obtenerInstanciaDeClase().agregarUnidad(guarida);
        guarida.construccionInstantanea();

        assertDoesNotThrow(()->celda.quiereConstruir(espiral));
    }
}
