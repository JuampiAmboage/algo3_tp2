package edu.fiuba.algo3.modelo.Edificios;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Raza.Evolucionador;
import edu.fiuba.algo3.modelo.Unidades.Zerling;
import edu.fiuba.algo3.modelo.vida.Vida;

public class ReservaDeReproduccion extends Edificio{
    Evolucionador evolucionador;

    public ReservaDeReproduccion(){
        tiempoDeConstruccion = 12;
        vida = new Vida(1000);
        evolucionador = new Evolucionador();
    }
    @Override
    public void construirEn(Celda celda) {
        celda.ocupar(this);
    }
    @Override
    public void pasarTurno(){
        if(!estaConstruido)
            controlEstadoConstruccion();
        else{
            vida.pasarTurno();
        }
    }
    public void generarZerling(){
        evolucionador.evolucionarLarva(new Zerling());
    }
    public boolean estaOperativo(){return estaConstruido;}

}

