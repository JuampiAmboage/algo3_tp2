package edu.fiuba.algo3.entrega_1.TestCase;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Celdas.CeldaConMoho;
import edu.fiuba.algo3.modelo.Comunidad.ComunidadZerg;
import edu.fiuba.algo3.modelo.Edificios.Acceso;
import edu.fiuba.algo3.modelo.Edificios.Extractor;
import edu.fiuba.algo3.modelo.Edificios.Guarida;
import edu.fiuba.algo3.modelo.Excepciones.RecursosInsuficientes;
import edu.fiuba.algo3.modelo.Razas.Tropas.Zangano;
import edu.fiuba.algo3.modelo.Recursos.Volcan;
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
        Extractor extractor = new Extractor(new Volcan());
        celda.ocuparPorTierra(new Zangano());
        assertDoesNotThrow(()->ComunidadZerg.obtenerInstanciaDeClase().agregarUnidad(extractor));
    }

    @Test
    public void sinRecursosNoPuedoConstruirUnaGuarida(){
        Celda celda = new Celda(0,0);
        Guarida guarida = new Guarida();
        celda.ocuparPorTierra(new Zangano());
        celda.cambiarTipo(new CeldaConMoho(celda));
        assertThrows(RecursosInsuficientes.class,()->ComunidadZerg.obtenerInstanciaDeClase().agregarUnidad(guarida));
    }

    @Test
    public void conElMineralDefaultEnAlmacenamientoPuedoConstruirUnAcceso(){
        Celda celda = new Celda(0,0);
        celda.cambiarTipo(new CeldaConMoho(celda));
        Acceso acceso = new Acceso();
        assertDoesNotThrow(()->ComunidadZerg.obtenerInstanciaDeClase().agregarUnidad(acceso));
    }
}