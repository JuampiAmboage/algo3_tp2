package edu.fiuba.algo3.modelo.Edificios;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.vida.VidaConEscudo;

public class Asimilador extends Edificio {
    VidaConEscudo vida;
    public Asimilador(){
        this.nombre = "asimilador";
        tiempoDeConstruccion = 6;
        vida = new VidaConEscudo(450,450);
    }

    @Override
    public void construir_en(Celda celda) {

    }
    @Override
    public void pasarTurno(){
        if(!estaConstruido)
            controlEstadoConstruccion();
        //esto de abajo iria como else? (no extrae si no esta construido)
        extraerGas();
        vida.pasarTurno();
    }

    public String nombre(){
        return this.nombre;
    }

    public int extraerGas(){
        return 20;
    }

    public void daniarEdificio(int puntosAtaque){
        vida.recibirAtaque(puntosAtaque);
    }

    public int obtenerVida(){return vida.getVidaActual();}

    public int obtenerEscudo(){ return vida.getEscudoActual();}
}
