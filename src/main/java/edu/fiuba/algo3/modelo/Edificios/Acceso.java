package edu.fiuba.algo3.modelo.Edificios;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.vida.VidaConEscudo;

public class Acceso extends Edificio{
    static int conteoInstancias = 0;
    public static boolean existeAlMenosUnaInstancia(){
        return conteoInstancias > 0;
    }
    public Acceso(){
        tiempoDeConstruccion = 8;
        vida = new VidaConEscudo(500,500);
        conteoInstancias++;
    }

    public void construir_en(Celda celda) {
    }

    public void pasarTurno(){
        if(!estaConstruido)
            controlEstadoConstruccion();
        else{
            vida.pasarTurno();
        }
    }
}
