package edu.fiuba.algo3.modelo.Razas.Tropas;

import edu.fiuba.algo3.modelo.Comunidad.ComunidadProtoss;
import edu.fiuba.algo3.modelo.Comunidad.ComunidadZerg;
import edu.fiuba.algo3.modelo.Edificios.Acceso;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Rango.RangoAtaque;
import edu.fiuba.algo3.modelo.Salud.VidaConEscudo;

public class Dragon extends Tropa implements TropaTerrestre{

    public Dragon() {
        ataque = new AtacarTierraYAire();
        costoEnMinerales = 125;
        costoEnGas = 50;
        tiempoConstruccion = 6;
        danioTerrestre = 20;
        danioAereo = 20;
        suministro = 3;
        edificioNecesario = new Acceso();
        comunidad = ComunidadProtoss.obtenerInstanciaDeClase();
        vida = new VidaConEscudo(100,80);
        ComunidadProtoss.obtenerInstanciaDeClase().aniadirSuministro(suministro);

    }
    public void realizarAccionesTurno(){}


    public void instanciacionInicial(Posicion posicionAColocar){
        posicion = posicionAColocar;
        rangoAtaque = new RangoAtaque(4,posicion);
    }

    @Override
    public void pasarTurno() {
        vida.pasarTurno();
    }

    public int obtenerEscudo(){return vida.getEscudoActual();}
}
