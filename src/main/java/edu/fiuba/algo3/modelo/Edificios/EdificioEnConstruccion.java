package edu.fiuba.algo3.modelo.Edificios;

import edu.fiuba.algo3.modelo.Excepciones.EdificioNoTerminado;

public class EdificioEnConstruccion implements EstadoConstruccion {
    private final Edificio edificio;
    private int tiempoDeConstruccion;

    public EdificioEnConstruccion(Edificio unEdificio, int tiempoDeConstruccion) {
        this.edificio = unEdificio;
        this.tiempoDeConstruccion = tiempoDeConstruccion;
        this.analizarTiempoDeConstruccion();
    }

    private void analizarTiempoDeConstruccion() {
        if (this.tiempoDeConstruccion <= 0) {
            this.edificio.estado = new EdificioConstruido(this.edificio);
        }
    }
    @Override
    public void pasarTurno() {
        this.tiempoDeConstruccion--;
        this.analizarTiempoDeConstruccion();
    }
    @Override
    public void esUsable() {
        throw new EdificioNoTerminado();
    }
}
