package edu.fiuba.algo3.modelo.Comunidad;

import edu.fiuba.algo3.modelo.Raza.*;
import edu.fiuba.algo3.modelo.Almacenamiento.Almacenamiento;
import java.util.ArrayList;

public class Comunidad {
    private ArrayList<Raza> pueblo;
    private Almacenamiento almacenamiento;

    public Comunidad(String raza) {

        Raza[] lista_inicial = new Raza[3];

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
}