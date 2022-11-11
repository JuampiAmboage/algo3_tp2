package edu.fiuba.algo3.modelo.Comunidad;

import edu.fiuba.algo3.modelo.Raza.*;
import edu.fiuba.algo3.modelo.Almacenamiento.*;

public class Comunidad {
    private Raza[] pueblo;
    private Almacenamiento almacenamiento;

    public Comunidad(String raza) {
        this.pueblo = string_a_raza(raza);
    }

    private Raza[] string_a_raza(String raza){
        Raza[] pueblo_;

        if (raza.equals("protoss")) {
            pueblo_ = new Protoss[1];
        }else{
            pueblo_ = new Larva[3];
        }
        return pueblo_;
    }
}
