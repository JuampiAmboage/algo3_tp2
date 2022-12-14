package edu.fiuba.algo3.entrega_1.UnitTest;

import edu.fiuba.algo3.modelo.Comunidad.ComunidadZerg;
import edu.fiuba.algo3.modelo.Edificios.Criadero;
import edu.fiuba.algo3.modelo.Edificios.ReservaDeReproduccion;
import edu.fiuba.algo3.modelo.Razas.Tropas.Zangano;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class TestComunidad {
    @Test
    public void siQuieroBuscarUnObjetoZanganoLoEncuentra(){
        ComunidadZerg comunidadZerg = ComunidadZerg.obtenerInstanciaDeClase();
        Zangano zangano = new Zangano();
        Zangano zanganoDeBusqueda = new Zangano();
        comunidadZerg.agregarUnidad(zangano);
        for(int i=0;i<10;i++)
            comunidadZerg.pasarTurno();
        assertTrue(comunidadZerg.existeUnidad(zanganoDeBusqueda));
    }

    @Test
    public void siQuieroBuscarUnEdificioLoEncuentra(){
        ComunidadZerg comunidadZerg = ComunidadZerg.obtenerInstanciaDeClase();
        Criadero criadero = new Criadero();
        Criadero criaderoDeBusqueda = new Criadero();
        criadero.construccionInstantanea();
        criaderoDeBusqueda.construccionInstantanea();
        comunidadZerg.aniadirGasVespeno(300);
        comunidadZerg.aniadirMineral(400);
        comunidadZerg.agregarUnidad(criadero);
        assertTrue(()->comunidadZerg.existeUnidad(criaderoDeBusqueda));
    }
    @Test
    public void siBuscoUnEdificioQueJamasFueCreadoNoLoEncuentra(){
        ComunidadZerg unaComunidadZerg = ComunidadZerg.obtenerInstanciaDeClase();
        ReservaDeReproduccion reservaDeReproduccion = new ReservaDeReproduccion();
        Criadero criaderoDeBusqueda = new Criadero();
        criaderoDeBusqueda.construccionInstantanea();
        unaComunidadZerg.aniadirGasVespeno(300);
        unaComunidadZerg.aniadirMineral(400);
        unaComunidadZerg.agregarUnidad(reservaDeReproduccion);
        assertFalse(unaComunidadZerg.existeUnidad(criaderoDeBusqueda));
    }
}
