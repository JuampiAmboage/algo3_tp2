package edu.fiuba.algo3.modelo.Comunidad;

import edu.fiuba.algo3.modelo.Racita;
import edu.fiuba.algo3.modelo.Raza.*;
import edu.fiuba.algo3.modelo.Almacenamiento.Almacenamiento;
import edu.fiuba.algo3.modelo.Edificios.*;
import java.util.ArrayList;

public class Comunidad {
    private ArrayList<Racita> pueblo;
    private Almacenamiento almacenamiento;

    private ArrayList<Edificio> edificios;

    public Comunidad(Racita[] raza) {

        Racita[] lista_inicial = new Racita[0];
        this.almacenamiento = new Almacenamiento();

        for (Racita elemento :raza) {
            this.pueblo.add(elemento);
        }
    }

    public void almacenar_minerales(int cantidad) {
        this.almacenamiento.almacenar_minerales(cantidad);
    }
    public void almacenar_gas_vespeno(int cantidad) {
        this.almacenamiento.almacenar_gas_vespeno(cantidad);
    }

    public void agregar_edificio(Edificio edificio) {
        this.edificios.add(edificio);
    }
}
