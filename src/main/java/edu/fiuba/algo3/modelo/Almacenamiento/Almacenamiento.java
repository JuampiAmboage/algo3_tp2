package edu.fiuba.algo3.modelo.Almacenamiento;

import edu.fiuba.algo3.modelo.Gas_vespeno.Gas_vespeno;
import edu.fiuba.algo3.modelo.Mineral.Mineral;

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
}
