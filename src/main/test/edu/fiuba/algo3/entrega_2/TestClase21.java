package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.Excepciones.RecursosInsuficientes;
import edu.fiuba.algo3.modelo.Razas.Tropas.Devorador;
import edu.fiuba.algo3.modelo.Razas.Tropas.Guardian;
import edu.fiuba.algo3.modelo.Razas.Tropas.Mutalisco;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class TestClase21 {

    @Test
    public void unMutaliscoNoPuedeEvolucionarAGuardianSinRecursos(){
        Mutalisco mutalisco = new Mutalisco();
        Guardian guardian = new Guardian();
        mutalisco.construccionInstantanea();
        assertThrows(RecursosInsuficientes.class,()->mutalisco.mutar(guardian));
    }

    @Test
    public void unMutaliscoNoPuedeEvolucionarADevoradorSinRecursos(){
        Mutalisco mutalisco = new Mutalisco();
        Devorador devorador = new Devorador();
        mutalisco.construccionInstantanea();
        assertThrows(RecursosInsuficientes.class,()->mutalisco.mutar(devorador));
    }
}
