package edu.fiuba.algo3.entrega_1.TestCase;
import edu.fiuba.algo3.modelo.ComunidadNueva.ComunidadZerg;
import edu.fiuba.algo3.modelo.Edificios.Guarida;
import edu.fiuba.algo3.modelo.Mapa;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import org.junit.jupiter.api.Test;
import edu.fiuba.algo3.modelo.Edificios.Criadero;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class TestCase10 {
    @Test
    public void alDaniarUnaGuaridaYPasarUnTurnoRecuperaSuVidaMaxima(){
        Guarida guarida = new Guarida(); //empieza con 500 de vida
        guarida.daniar(125);
        guarida.pasarTurno(); //en cada turno regenera 20% de su vida maxima, es decir 100
        assertEquals(1250,guarida.obtenerVida());
    }

    @Test
    public void alDaniarUnCriaderoCasiHastaElBordeYLuegoPasarTurnosVaRecuperandoSuVida(){
        Criadero criadero = new Criadero();

        criadero.daniar(450);

        for(int i=0; i<8;i++)
            criadero.pasarTurno(); //tras 4 turnos recuperando de a 100 queda en 450

        assertEquals(450,criadero.obtenerVida());
    }
}
