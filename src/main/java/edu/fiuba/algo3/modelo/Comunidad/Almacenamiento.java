package edu.fiuba.algo3.modelo.Comunidad;

public class Almacenamiento {

    private int gasVespeno;
    private int mineral;

    public Almacenamiento(){
        this.gasVespeno = 10_000_000;
        this.mineral = 10_000_000;
    }
    public boolean suficientesRecursos(int costoGasUnidadAGenerar, int costoMineralUnidadAGenerar) {
        return (costoGasUnidadAGenerar <= gasVespeno && costoMineralUnidadAGenerar <= mineral);
    }

    public void descontarRecursos(int cantidadGasARetirar, int cantidadMineralARetirar){
        //this.gasVespeno -= cantidadGasARetirar;
        //this.mineral -= cantidadMineralARetirar;
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

    public int[] obtenerAlmacenamiento() {
        int[] almacenamiento = new int[2];
        almacenamiento[0] = obtenerCantidadGasAlmacenado();
        almacenamiento[1] = obtenerCantidadMineralAlmacenado();
        return almacenamiento;
    }


}
