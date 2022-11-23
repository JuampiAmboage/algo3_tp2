package edu.fiuba.algo3.entrega_1.TestCase;

import edu.fiuba.algo3.modelo.Edificios.Asimilador;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestCase12 {

    @Test void alSacarleTodoElEscudoAUnAsimiladorYSeguirDaniandoloPierdeVida(){

        Asimilador asimilador = new Asimilador(); //empieza con 450 de vida y 450 de escudo

        asimilador.daniar(450); //aca pierde todo el escudo
        asimilador.daniar(50); //afecto a la vida

        assertEquals(0,asimilador.obtenerEscudo());
        assertEquals(400,asimilador.obtenerVida());
    }

    @Test
    public void alSacarleTodoElEscudoYParteDeLaVidaAUnAsimiladorSoloRecuperaEscudo(){

        Asimilador asimilador = new Asimilador(); //empieza con 450 de vida y 450 de escudo

        asimilador.daniar(450); //aca pierde todo el escudo
        asimilador.daniar(200); //afecto a la vida

        for(int i=0;i<10;i++)
            asimilador.pasarTurno(); //pasan unos cuantos turnos

        assertEquals(450,asimilador.obtenerEscudo()); //escudo se recupera
        assertEquals(250,asimilador.obtenerVida()); //la vida sigue igual
    }
}
