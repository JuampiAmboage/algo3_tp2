package edu.fiuba.algo3.entrega_1.TestCase;

import edu.fiuba.algo3.modelo.Edificios.Asimilador;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestCase12 {
    /*Verificar que al dañar una construcción protoss quitandole todo el escudo y parte de la
vida la misma recupera SOLO su escudo por turnos hasta volver a tener el 100% del
mismo.*/

    @Test void alSacarleTodoElEscudoAUnAsimiladorYSeguirDaniandoloPierdeVida(){
        Asimilador asimilador = new Asimilador(); //empieza con 450 de vida y 450 de escudo

        asimilador.daniarEdificio(450); //aca pierde todo el escudo
        asimilador.daniarEdificio(50); //afecto a la vida

        assertEquals(0,asimilador.obtenerEscudo());
        assertEquals(400,asimilador.obtenerVida());
    }

    @Test
    public void alSacarleTodoElEscudoYParteDeLaVidaAUnAsimiladorSoloRecuperaEscudo(){
        Asimilador asimilador = new Asimilador(); //empieza con 450 de vida y 450 de escudo

        asimilador.daniarEdificio(450); //aca pierde todo el escudo
        asimilador.daniarEdificio(200); //afecto a la vida

        for(int i=0;i<10;i++)
            asimilador.pasarTurno(); //pasan unos cuantos turnos

        assertEquals(450,asimilador.obtenerEscudo()); //escudo se recupera
        assertEquals(250,asimilador.obtenerVida()); //la vida sigue igual
    }
}
