package edu.fiuba.algo3.modelo.Edificios;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.ComunidadNueva.ComunidadZerg;
import edu.fiuba.algo3.modelo.Razas.Evolucionador;
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
        vida.pasarTurno();
    }
    public void generarZerling(){
        evolucionador.evolucionarLarvaATropa(new Zerling());
    }
}

