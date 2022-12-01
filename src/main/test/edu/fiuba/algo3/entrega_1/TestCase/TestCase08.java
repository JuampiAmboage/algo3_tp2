package edu.fiuba.algo3.entrega_1.TestCase;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Celdas.CeldaConMoho;
import edu.fiuba.algo3.modelo.Comunidad.ComunidadProtoss;
import edu.fiuba.algo3.modelo.Comunidad.ComunidadZerg;
import edu.fiuba.algo3.modelo.Edificios.Acceso;
import edu.fiuba.algo3.modelo.Edificios.Extractor;
import edu.fiuba.algo3.modelo.Edificios.Guarida;
import edu.fiuba.algo3.modelo.Razas.Zangano;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestCase08 {
/*
    // Caso de uso #8: Verificar que sino se tienen los recursos no se pueden construir los edificios (Para cada edificio para cada raza).
*/
    @Test
    public void conLosMineralesInicialesPuedoConstruirUnAsimilador(){
        Celda celda = new Celda(0,0);
        celda.cambiarTipo(new CeldaConMoho(celda));
        Extractor extractor = new Extractor();
        celda.ocupar(new Zangano());
        assertDoesNotThrow(()->ComunidadZerg.obtenerInstanciaDeClase().agregarUnidad(extractor));
    }

    @Test
    public void sinRecursosNoPuedoConstruirUnaGuarida(){
        Celda celda = new Celda(0,0);
        Guarida guarida = new Guarida();
        celda.ocupar(new Zangano());
        celda.cambiarTipo(new CeldaConMoho(celda));
        assertThrows(RuntimeException.class,()->ComunidadZerg.obtenerInstanciaDeClase().agregarUnidad(guarida));
    }

    @Test
    public void sinRecursosNoPuedoConstruirUnAcceso(){
        Celda celda = new Celda(0,0);
        celda.cambiarTipo(new CeldaConMoho(celda));
        Acceso acceso = new Acceso();
        assertThrows(RuntimeException.class,()->ComunidadProtoss.obtenerInstanciaDeClase().agregarUnidad(acceso));
    }
}