package edu.fiuba.algo3.modelo.Edificios;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.vida.Vida;

public class Guarida extends Edificio{
    static int conteoInstancias = 0;
    public static boolean existeAlMenosUnaInstancia(){
        return conteoInstancias > 0;
    }
    public Guarida(){
        tiempoDeConstruccion = 12;
        vida = new Vida(1250);
        conteoInstancias++;
    }

    public void construirEn(Celda celda) {
        celda.ocupar(this);
    }

    public void pasarTurno(){
        if(!estaConstruido)
            controlEstadoConstruccion();
        else{
            vida.pasarTurno();
        }
    }
}
