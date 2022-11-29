package edu.fiuba.algo3.modelo.Edificios;

public class EdificioConstruido implements EstadoConstruccion {
    private final Edificio edificio;
    public EdificioConstruido(Edificio unEdificio) {
        this.edificio = unEdificio;
    }

    @Override
    public void pasarTurno() {
        this.edificio.accionarTurno();
    }
    @Override
    public void esUsable() {}
}
