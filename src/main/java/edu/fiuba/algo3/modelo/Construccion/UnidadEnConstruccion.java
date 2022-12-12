package edu.fiuba.algo3.modelo.Construccion;

import edu.fiuba.algo3.modelo.Construccion.EstadoConstruccion;
import edu.fiuba.algo3.modelo.Construccion.UnidadConstruida;
import edu.fiuba.algo3.modelo.Excepciones.UnidadNoTerminada;
import edu.fiuba.algo3.modelo.Razas.Unidad;

public class UnidadEnConstruccion implements EstadoConstruccion {
    private final Unidad futuraUnidad;
    private int tiempoDeConstruccion;

    public UnidadEnConstruccion(Unidad unidadACrear) {
        this.futuraUnidad = unidadACrear;
        tiempoDeConstruccion = futuraUnidad.obtenerTiempoConstruccion();
        analizarTiempoDeConstruccion();
    }

    private void analizarTiempoDeConstruccion() {
        if (this.tiempoDeConstruccion == 0) {
            this.futuraUnidad.cambiarEstado(new UnidadConstruida(this.futuraUnidad));
        }
    }
    @Override
    public void pasarTurno() {
        this.tiempoDeConstruccion--;
        this.analizarTiempoDeConstruccion();
    }

    @Override
    public void esUsable() {
        throw new UnidadNoTerminada();
    }
}