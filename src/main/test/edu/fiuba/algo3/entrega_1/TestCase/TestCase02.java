package edu.fiuba.algo3.entrega_1.TestCase;

import edu.fiuba.algo3.modelo.Celdas.CeldaConMoho;
import edu.fiuba.algo3.modelo.ComunidadNueva.ComunidadZerg;
import edu.fiuba.algo3.modelo.Edificios.EdificioEnConstruccion;
import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import edu.fiuba.algo3.modelo.Edificios.Criadero;
import edu.fiuba.algo3.modelo.Celdas.Celda;

public class TestCase02 {

    @Test
    public void unCriaderoQueTarda4TurnosEnConstruirseLanzaUnErrorCuandoSeLoQuiereUsar() {
        Criadero criadero = new Criadero();
        EdificioEnConstruccion edificioEnConstruccion = new EdificioEnConstruccion(criadero, ComunidadZerg.obtenerInstanciaDeClase());
        Executable task = criadero::engendrar;

        assertThrows(RuntimeException.class, task);
    }

    @Test
    public void unCriaderoDebeEsperar4TurnosParaPoderUsarse() {
        Criadero c = new Criadero();
        Celda celda = new Celda();
        celda.cambiarTipo(new CeldaConMoho(celda));

        c.construirSobre(celda);


        c.pasarTurno();
        c.pasarTurno();
        c.pasarTurno();
        c.pasarTurno();

        Executable task = c::engendrar;

        assertDoesNotThrow(task);
    }

}
