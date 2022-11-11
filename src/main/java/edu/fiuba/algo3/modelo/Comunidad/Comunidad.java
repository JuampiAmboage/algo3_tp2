package edu.fiuba.algo3.modelo.Comunidad;

import edu.fiuba.algo3.modelo.Almacenamiento.Almacenamiento;
import edu.fiuba.algo3.modelo.Raza.Raza;
import edu.fiuba.algo3.modelo.Opciones_de_raza;

public class Comunidad {
    private Raza[] pueblo;
    private Almacenamiento almacenamiento;

    public Comunidad(Opciones_de_raza tipo) {
        if ( (tipo.toString() ) == "PROTOSS") {
            System.out.println("creo Protoss");
        } else {
            System.out.println("creo Zerg");
        }
    }
}
