package edu.fiuba.algo3.modelo.Comunidad;

import edu.fiuba.algo3.modelo.Raza.*;
import edu.fiuba.algo3.modelo.Almacenamiento.Almacenamiento;
import edu.fiuba.algo3.modelo.Edificios.*;
import java.util.ArrayList;

public class Comunidad {
    private ArrayList<Raza> pueblo;
    private Almacenamiento almacenamiento;

    private ArrayList<Edificio> edificios;

    public Comunidad(String raza) {

        Raza[] lista_inicial = new Raza[0];
        this.almacenamiento = new Almacenamiento();

        if (raza.equals("protoss")) {
            for (int i = 0; i < 3; i++) {
                this.pueblo.add(new Protoss());
            }
        } else {
            for (int i = 0; i < 3; i++) {
                this.pueblo.add(new Larva());
            }
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
