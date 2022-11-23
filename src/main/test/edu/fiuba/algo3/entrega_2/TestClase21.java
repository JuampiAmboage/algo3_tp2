package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.Razas.Evolucionador;
import edu.fiuba.algo3.modelo.Razas.Tropas.Guardian;
import edu.fiuba.algo3.modelo.Razas.Tropas.Mutalisco;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class TestClase21 {

    @Test
    public void unMutaliscoNoPuedeEvolucionarAGuardianSinRecursos(){
        Evolucionador evolucionador = new Evolucionador();

        assertThrows(RuntimeException.class,()->evolucionador.evolucionarUnidad(new Guardian(),new Mutalisco()));
    }
}