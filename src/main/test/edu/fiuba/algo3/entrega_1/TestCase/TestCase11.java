package edu.fiuba.algo3.entrega_1.TestCase;

import edu.fiuba.algo3.modelo.Edificios.Pilon;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestCase11 {
    @Test
    public void alDaniarUnPilonYPasarUnTurnoRecuperaSuEscudo(){
        Pilon pilon = new Pilon(); //un pilon tiene 300 de vida y 300 de escudo
        pilon.daniarEdificio(30);
        pilon.pasarTurno(); //recupera 10% de su vida maxima por turno, es decir 30

        assertEquals(300,pilon.obtenerEscudo());
    }
    @Test
    public void alDaniarUnPilonCasiHastaPerderTodoElEscudoYLuegoPasarTurnosVaRecuperandoSuEscudo(){
        Pilon pilon = new Pilon(); //un pilon tiene 300 de vida y 300 de escudo
        pilon.daniarEdificio(270);
        for(int i=0; i<5;i++)
            pilon.pasarTurno();
        assertEquals(180,pilon.obtenerEscudo());
    }
}
