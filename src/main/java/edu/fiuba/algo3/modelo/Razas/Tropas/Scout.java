package edu.fiuba.algo3.modelo.Razas.Tropas;

import edu.fiuba.algo3.modelo.Comunidad.ComunidadProtoss;
import edu.fiuba.algo3.modelo.Edificios.PuertoEstelar;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Rango.RangoAtaque;
import edu.fiuba.algo3.modelo.Salud.VidaConEscudo;

public class Scout extends TropaAerea{
    public Scout(){
        super();
        ataque = new AtacarTierraYAire();
        costoEnMinerales = 300;
        costoEnGas = 150;
        tiempoConstruccion = 9;
        danioTerrestre = 8;
        danioAereo = 14;
        suministro = 4;
        vida = new VidaConEscudo(150,100);
        comunidad = ComunidadProtoss.obtenerInstanciaDeClase();
        edificioNecesario = new PuertoEstelar();
        this.sprite = "";
    }
    public void instanciacionesIniciales(Posicion posicionALocalizar){
        posicion = posicionALocalizar;
        rangoAtaque = new RangoAtaque(this,4,posicion);
    }
    public void realizarAccionesTurno(){vida.pasarTurno();}
    public int obtenerEscudo(){return vida.getEscudoActual();}

}
