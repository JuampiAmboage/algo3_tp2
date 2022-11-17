package edu.fiuba.algo3.entrega_1.TestCase;

import edu.fiuba.algo3.modelo.Almacenamiento.Almacenamiento;
import edu.fiuba.algo3.modelo.Comunidad.Comunidad;
import edu.fiuba.algo3.modelo.Edificios.Asimilador;
import edu.fiuba.algo3.modelo.Excepciones.SinRecursosSuficientes;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class TestCase08 {
/*
    // Caso de uso #8: Verificar que sino se tienen los recursos no se pueden construir los edificios (Para cada edificio para cada raza).
*/
    @Test
    public void sinRecursosNoPuedeConstruirseUnAsimilador(){
        Comunidad comunidad = new Comunidad();
        Asimilador asimilador = new Asimilador();
        assertThrows(SinRecursosSuficientes.class, () -> comunidad.agregarEdificio(asimilador));
    }
}
