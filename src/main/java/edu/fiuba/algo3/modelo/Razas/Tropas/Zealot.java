package edu.fiuba.algo3.modelo.Razas.Tropas;

import edu.fiuba.algo3.modelo.Ataque.AtacarTierra;
import edu.fiuba.algo3.modelo.Comunidad.ComunidadProtoss;
import edu.fiuba.algo3.modelo.Edificios.Acceso;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Rango.RangoAtaque;
import edu.fiuba.algo3.modelo.Salud.VidaConEscudo;

public class Zealot extends TropaTerrestre implements VisibilidadCambiante{
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
        opciones.add("Atacar a tierra");
        opciones.add("Atacar a aire");
        opciones.add("Moverse");
    }

    @Override
    public void instanciacionesIniciales(Posicion posicionALocalizar){
        this.posicion = posicionALocalizar;
        this.rangoAtaque = new RangoAtaque(this,1,posicion);
    }

    public void realizarAccionesTurno() {
        vida.pasarTurno();
    }
    @Override
    public void atacarTierra(TropaTerrestre unidadAtacable){
        ataque.atacarTierra(rangoAtaque,unidadAtacable,danioTerrestre);
        if(unidadAtacable.estaSinVida()) {
            this.bajasGeneradas++;
            if(bajasGeneradas == 3)
                this.volverInsvisible();
        }
    }
    public void volverVisible(){ visibilidad = new Visible(this);}
    public void volverInsvisible(){
        visibilidad = new Invisible(this);
    }
    public int obtenerEscudo(){return vida.getEscudoActual();}

}
