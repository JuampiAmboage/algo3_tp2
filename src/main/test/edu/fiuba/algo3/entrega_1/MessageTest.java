package edu.fiuba.algo3.entrega_1;

import edu.fiuba.algo3.modelo.Message;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MessageTest {
    @Test
    public void messageGreeting() {
        Message message = new Message("Hola Mundo!", "Hello world!");

        assertEquals("Hello world!", message.greet("us"));
    }

    @Test
    public void messageGreetingDefaultLanguage() {
        Message message = new Message("Hola Mundo!", "Hello world!");

        assertEquals("Hola Mundo!", message.greet());
    }

    @Test
    public void elCriaderoInicializaConTresLarvas() {
        Criadero c = new Criadero();
        assertEquals(3, c.cantidadLarvas());
    }
    @Test
    public void elCriaderoConsumeUnaLarva() {
        /*
        * Criadero se inicia con 3 larvas, se consume una para engendrar un zángano, le quedan 2 y
después de 1 turno vuelve a tener 3 larvas. Lo mismo al consumir 2 y las 3 larvas, verificar
que se regeneren acorde a los tiempos estipulados
        *
        * */

        Criadero c = new Criadero();
        c.consumir();

        assertEquals(2, c.cantidadLarvas());


    }

    @Test
    public void alPasarTurnoElCriaderoRegeneraUnaLarva() {

        Criadero c = new Criadero();
        c.consumir();
        c.pasarTurno();
        assertEquals(3, c.cantidadLarvas());

    }

    /*
    * Verificar que cada edificio / construcción tarde en construirse lo que dice que tarda y que
recién están “operativos” cuando ya se terminaron de construir.
    * */

    @Test
    public void unCriaderoEnConstruccionEstaInactivo() {
        Criadero c = new Criadero(4);

        assertDeny(c.estaActivo());

    }

    @Test
    public void unCriaderoSeCreaAlPasarLosTurnos() {
        Criadero c = new Criadero(4);

        c.pasarTurno();
        c.pasarTurno();
        c.pasarTurno();
        c.pasarTurno();


        assertEquals(true, c.estaActivo());

    }

    /*
    * Verificar que solo Asimilador y extractor se puedan construir sobre el gas.
    * */


    /*
    *
    * @Test
public void whenExceptionThrown_thenAssertionSucceeds() {
    Exception exception = assertThrows(NumberFormatException.class, () -> {
        Integer.parseInt("1a");
    });

    String expectedMessage = "For input string";
    String actualMessage = exception.getMessage();

    assertTrue(actualMessage.contains(expectedMessage));
}
    *
    * */
    @Test
    public void caso03() {
        //Separar en distintos tests!!!

        //probar que funciona
        Terreno v = new Volcan();
        v.construir(new Asimilador(6));


        Terreno v = new Volcan();
        v.construir(new Extractor(4));

        // probar excepción
        Terreno v = new Volcan();
        v.construir(new Criadero(4));
    }

    /*
    *
    * Verificar que extractor sin zánganos trabajando no genera gas.
    * Verificar que con 1 saca 10, con 2 20, con 3 30.
    * Que no puede recibir a un 4to zángano porque está lleno.
    * Verificar que el Asimilador recoge gas una vez construido según lo estipulado
    * */

    @Test
    public void caso0401() {
        Extractor e = new Extractor();
        // se crea con 0 zanganos
        // a los zanganos se les puede pasar la celda de gas
        // extractor tiene un array de zanganos
        // extractor tiene una cantidad de zanganos limite
        // recorre la lista y le manda a cada zangano a GENERAR GAS con la celda
        assertEquals(0, e.extraerGas());
    }

    //extractor.extraerGas() ==> zangano.extraerGas(celdaConGas)
}
