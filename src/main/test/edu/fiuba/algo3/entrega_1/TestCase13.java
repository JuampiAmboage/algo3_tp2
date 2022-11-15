package edu.fiuba.algo3.entrega_1;
import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Celdas.CeldaConMoho;
import edu.fiuba.algo3.modelo.Edificios.Criadero;
import org.junit.jupiter.api.Test;

public class TestCase13 {

    @Test
    public void caso13() {
        //Se destruye un criadero e igual se puede seguir construyendo sobre el moho que dejó
        Criadero criadero = new Criadero();
        Criadero otroCriadero = new Criadero();
        Celda celda = new Celda();
        CeldaConMoho celdaConMoho = new CeldaConMoho(celda);
        celda.cambiarTipo(celdaConMoho);
        celda.ocupar(criadero);
        celda.desocupar();
        celda.ocupar(otroCriadero);
    }
}
