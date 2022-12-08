package edu.fiuba.algo3.modelo.Razas.Tropas;

import edu.fiuba.algo3.modelo.Comunidad.ComunidadProtoss;
import edu.fiuba.algo3.modelo.Edificios.Acceso;
import edu.fiuba.algo3.modelo.Salud.VidaConEscudo;

public class Zealot extends TropaTerrestre {
    Invisible invisible;
    int bajasGeneradas;
    public Zealot(){
        super();
        ataque = new AtacarTierra();
        costoEnMinerales = 100;
        costoEnGas = 0;
        tiempoConstruccion = 4;
        danioTerrestre = 8;
        danioAereo = 0;
        suministro = 2;
        vida = new VidaConEscudo(100,60);
        bajasGeneradas = 0;
        edificioNecesario = new Acceso();
        comunidad = ComunidadProtoss.obtenerInstanciaDeClase();
        comunidad.aniadirSuministro(suministro);
    }

    @Override
    public void pasarTurno() {
        vida.pasarTurno();
        if(bajasGeneradas >= 3)
            this.volverInsvisible();
    }
    @Override
    public void atacarTierra(TropaTerrestre unidadAtacable){
        ataque.atacarTierra(rangoAtaque,unidadAtacable,danioTerrestre);
        if(unidadAtacable.estaSinVida())
            bajasGeneradas++;
    }
    @Override
    public void atacarAire(TropaAerea unidadAtacable){ ataque.atacarAire(rangoAtaque,unidadAtacable,danioAereo);}

    public void realizarAccionesTurno(){}
    public int obtenerEscudo(){return vida.getEscudoActual();}

}
