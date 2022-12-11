package edu.fiuba.algo3.entrega_3;

import edu.fiuba.algo3.modelo.Comunidad.ComunidadZerg;
import edu.fiuba.algo3.modelo.Excepciones.TropaSinAtaqueATierra;
import edu.fiuba.algo3.modelo.Excepciones.UnidadInexistente;
import edu.fiuba.algo3.modelo.Partida.Mapa;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Razas.Tropas.Devorador;
import edu.fiuba.algo3.modelo.Razas.Tropas.Mutalisco;
import edu.fiuba.algo3.modelo.Razas.Tropas.Scout;
import edu.fiuba.algo3.modelo.Razas.Tropas.Zerling;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;


public class TestCase27 {

    @Test
    public void sinUnMutaliscoNoPuedoTenerUnDevorador(){
        Devorador devorador = new Devorador();
        Mutalisco mutalisco = new Mutalisco();
        ComunidadZerg comunidadZerg = ComunidadZerg.obtenerInstanciaDeClase();
        comunidadZerg.aniadirGasVespeno(150);
        comunidadZerg.aniadirMineral(150);
        comunidadZerg.aniadirCapacidadSuministro(10);
        assertThrows(UnidadInexistente.class,()->comunidadZerg.mutar(mutalisco,devorador));
        //intento mutar un mutalisco que jamas fue "creado" (no está registrado en comunidad)
    }

    @Test
    public void siHayUnMutaliscoPuedoTenerUnDevorador(){
        Devorador devorador = new Devorador();
        Mutalisco mutalisco = new Mutalisco();
        ComunidadZerg comunidadZerg = ComunidadZerg.obtenerInstanciaDeClase();
        comunidadZerg.aniadirCapacidadSuministro(10);
        comunidadZerg.aniadirGasVespeno(150); //
        comunidadZerg.aniadirMineral(50);
        comunidadZerg.agregarUnidad(mutalisco); //en este caso si registro al mutalisco
        assertDoesNotThrow(()->comunidadZerg.mutar(mutalisco,devorador));
    }
    @Test
    public void unDevoradorPuedeAtacarPorAire(){
        Mapa mapa = Mapa.getInstance();
        Devorador devorador = new Devorador();
        Scout scout = new Scout();
        mapa.instanciarMapa(4,4);

        devorador.instanciacionesIniciales(new Posicion(2,2));
        scout.instanciacionesIniciales(new Posicion(2,3));
        mapa.obtenerCelda(new Posicion(2,2)).ocuparPorAire(devorador);
        mapa.obtenerCelda(new Posicion(2,3)).ocuparPorAire(scout);

        devorador.iniciarConstruccion();
        for(int i=0;i<4;i++)
            devorador.pasarTurno();

        assertDoesNotThrow(()->devorador.atacarAire(scout));
    }


    @Test
    public void unDevoradorNoPuedeAtacarATierra(){
        Mapa mapa = Mapa.getInstance();
        Devorador devorador = new Devorador();
        Zerling zerling = new Zerling();
        mapa.instanciarMapa(4,4);

        devorador.instanciacionesIniciales(new Posicion(2,2));
        zerling.instanciacionesIniciales(new Posicion(2,3));
        mapa.obtenerCelda(new Posicion(2,2)).ocuparPorAire(devorador);
        mapa.obtenerCelda(new Posicion(2,3)).ocuparPorTierra(zerling);

        devorador.iniciarConstruccion();
        for(int i=0;i<4;i++)
            devorador.pasarTurno();

        assertThrows(TropaSinAtaqueATierra.class,()->devorador.atacarTierra(zerling));
    }
}
