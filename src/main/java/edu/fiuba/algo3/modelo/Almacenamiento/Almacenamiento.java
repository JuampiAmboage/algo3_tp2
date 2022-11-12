package edu.fiuba.algo3.modelo.Almacenamiento;

public class Almacenamiento {
    private int cantidad_de_gas;
    private int cantidad_de_mineral;

    public Almacenamiento(){
        this.cantidad_de_gas = 0;
        this.cantidad_de_mineral = 200; //cada jugador inicia con 200 de mineral
    }

    public void agregarGas(int cantidad_gas_entrante){
        this.cantidad_de_gas += cantidad_gas_entrante;
    }
    public void agregarMineral(int cantidad_mineral_entrante){
        this.cantidad_de_mineral += cantidad_mineral_entrante;
    }
    /*restar gas y mineral, también podría hacerse en un mismo método y pasarle un boolean que determine
    si es suma o resta. Pj: public void manipularGas(cantidadGas,true (sumar)/false (restar))*/
}
