package edu.fiuba.algo3.entrega_1.TestCase;

import com.tngtech.archunit.lang.ArchRule;
import edu.fiuba.algo3.modelo.Celdas.*;
import edu.fiuba.algo3.modelo.Comunidad.Comunidad;
import edu.fiuba.algo3.modelo.Edificios.*;
import edu.fiuba.algo3.modelo.Excepciones.ConstruccionProhibida;
import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.Opciones_de_raza;

import edu.fiuba.algo3.modelo.Posicion.Posicion;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;


public class TestCase05 {

    @Test
    public void siConstruyoUnPilonPuedoConstruirEnUnaCeldaEnergizada() {
        Mapa mapa = Mapa.getInstance();
        Pilon pilon = new Pilon();

        mapa.instanciarMapa(7, 7);
        mapa.obtenerCelda(4, 4).ocupar(pilon);
        pilon.localizarEnMapa(4, 4);
        pilon.instanciacionInicial(new Posicion(4,4));
        Celda celda = mapa.obtenerCelda(4, 5);
        assertTrue(celda.esMismoTipo(new CeldaEnergizada()));
    }

    @Test
    public void noPuedoConstruirUnCriaderoEnUnaCeldaIncorrecta() {
        Criadero criadero = new Criadero();
        Celda celda = new Celda();
        assertThrows(ConstruccionProhibida.class, () -> celda.quiereConstruir(criadero));
    }

    @Test
    public void noPuedoConstruirUnAsimiladorEnUnaCeldaIncorrecta() {
        Asimilador asimilador = new Asimilador();
        Celda celda = new Celda();
        assertThrows(ConstruccionProhibida.class, () -> celda.quiereConstruir(asimilador));
    }
}