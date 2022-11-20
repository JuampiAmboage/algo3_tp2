package edu.fiuba.algo3.modelo.Edificios;

import edu.fiuba.algo3.modelo.Almacenamiento.Almacenamiento;
import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Racita;
import edu.fiuba.algo3.modelo.vida.Salud;

public abstract class Edificio extends Racita {
    protected int tiempoDeConstruccion;

    protected Salud vida;
    public Edificio() {}
    public Edificio(int tiempoDeConstruccion) {
        this.tiempoDeConstruccion = tiempoDeConstruccion;
    }
    public String nombre;
    protected int turnosPasadosParaConstruccion = -1;
    protected boolean estaConstruido = false;

    public abstract void construirEn(Celda celda);
    public abstract void pasarTurno();
    public void controlEstadoConstruccion(){
        if (this.turnosPasadosParaConstruccion != this.tiempoDeConstruccion) {

            this.turnosPasadosParaConstruccion++;

        } else {
            this.estaConstruido = true;
        }
    }
    public abstract boolean estaOperativo();

    public int obtenerTiempoConstruccion(){ return tiempoDeConstruccion;}
}
