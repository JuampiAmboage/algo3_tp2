package edu.fiuba.algo3.modelo.Razas.Tropas;

import edu.fiuba.algo3.modelo.Comunidad.ComunidadProtoss;
import edu.fiuba.algo3.modelo.Edificios.PuertoEstelar;
import edu.fiuba.algo3.modelo.Salud.VidaConEscudo;

public class Scout extends Tropa implements TropaAerea{
    public Scout(){
        ataque = new AtacarTierraYAire();
        costoEnMinerales = 300;
        costoEnGas = 150;
        tiempoConstruccion = 9;
        danioTerrestre = 8;
        danioAereo = 14;
        suministro = 4;
        vida = new VidaConEscudo(150,100);
        comunidad = ComunidadProtoss.obtenerInstanciaDeClase();
        comunidad.aniadirSuministro(suministro);
        edificioNecesario = new PuertoEstelar();
    }

    @Override
    public void pasarTurno() {
        vida.pasarTurno();
    }

    public void realizarAccionesTurno(){}
    public int obtenerEscudo(){return vida.getEscudoActual();}

}
