package edu.fiuba.algo3.entrega_2;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Comunidad.ComunidadZerg;
import edu.fiuba.algo3.modelo.Edificios.Criadero;
import edu.fiuba.algo3.modelo.Edificios.Pilon;
import edu.fiuba.algo3.modelo.Excepciones.CeldaOcupada;
import edu.fiuba.algo3.modelo.Partida.Mapa;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import org.junit.jupiter.api.Test;

import java.util.Map;

public class TestClass24 {

    @Test
    public void losJugadorEmpiezanConSusBasesEnExtremosOpuestos(){
        Criadero criadero = new Criadero();
        Pilon pilon = new Pilon();
        Mapa mapa = Mapa.getInstance();
        Celda celdaAuxiliar = null;

        mapa.instanciarMapa();
        mapa.generarBase(criadero);
        mapa.generarBase(pilon);

        for(int i=0;i<10;i++){
            try{
                celdaAuxiliar = mapa.obtenerCelda(new Posicion(0,i));
                celdaAuxiliar.estaOcupadaPorTierra();
            }
            catch (CeldaOcupada celdaOcupada){
                assert(celdaAuxiliar.obtenerOcupanteTerrestre().equals(criadero));
            }
        }
        for(int i=0;i<10;i++){
            try{
                celdaAuxiliar = mapa.obtenerCelda(new Posicion(9,i));
                celdaAuxiliar.estaOcupadaPorTierra();
            }
            catch (CeldaOcupada celdaOcupada){
                assert(celdaAuxiliar.obtenerOcupanteTerrestre().equals(pilon));
            }
        }
    }
}
