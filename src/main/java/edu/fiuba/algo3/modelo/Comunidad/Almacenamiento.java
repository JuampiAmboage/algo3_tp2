package edu.fiuba.algo3.modelo.Comunidad;

import edu.fiuba.algo3.modelo.Recursos.Recurso;

import java.util.ArrayList;

public class Almacenamiento {

    private int gasVespeno;
    private int mineral;

    public Almacenamiento(){
        this.gasVespeno = 0;
        this.mineral = 200;
    }
    public boolean suficientesRecursos(int costoGasUnidadAGenerar, int costoMineralUnidadAGenerar) {
        return (costoGasUnidadAGenerar > gasVespeno || costoMineralUnidadAGenerar > mineral);
    }
    public void almacenarGasVespeno(int cantidadEntrante) {
        this.gasVespeno += cantidadEntrante;
    }
    public void almacenarMinerales(int cantidadEntrante) {
        this.mineral += cantidadEntrante;
    }
    public void retirarGasVespeno(int cantidadARetirar){
        gasVespeno -= cantidadARetirar;
    }
    public void retirarMinerales(int cantidadARetirar){
        mineral -= cantidadARetirar;
    }
    public int obtenerCantidadGasAlmacenado(){
        return gasVespeno;
    }
    public int obtenerCantidadMineralAlmacenado(){
        return mineral;
    }


}
