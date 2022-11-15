package edu.fiuba.algo3.modelo.Edificios;

import edu.fiuba.algo3.modelo.Almacenamiento.Almacenamiento;
import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.vida.Salud;

public abstract class Edificio {
    protected Salud vida;

    protected int costo_de_construccion;
    protected Almacenamiento amlmacenamiento;
    protected int tiempoDeConstruccion;

    public String nombre;
    protected int turnosPasadosParaConstruccion = -1;
    protected boolean estaConstruido = false;

    public abstract void construir_en(Celda celda);
    public abstract void pasarTurno();
    public void controlEstadoConstruccion(){
        if (this.turnosPasadosParaConstruccion != this.tiempoDeConstruccion) {

            this.turnosPasadosParaConstruccion++;

        } else {
            this.estaConstruido = true;
        }
    }

    public String nombre() {
        return this.nombre;
    }

    public void daniarEdificio(int puntosAtaque){
        vida.recibirAtaque(puntosAtaque);
    }

    public int obtenerVida(){return vida.getVidaActual();}
}
