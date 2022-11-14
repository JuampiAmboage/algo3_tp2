package edu.fiuba.algo3.modelo.Almacenamiento;

import edu.fiuba.algo3.modelo.Recursos.Recurso;

import java.util.ArrayList;

public class Almacenamiento {

    private int gas_vespeno;
    private int mineral;

    public Almacenamiento(){
        this.gas_vespeno = 0;
        this.mineral = 0;
    }

    public void almacenar_gas_vespeno(int cantidad) {
        this.gas_vespeno += cantidad;
    }

    public void almacenar_minerales(int cantidad) {
        this.mineral += cantidad;
    }

        /*restar gas y mineral, también podría hacerse en un mismo método y pasarle un boolean que determine
    si es suma o resta. Pj: public void manipularGas(cantidadGas,true (sumar)/false (restar))*/

}
