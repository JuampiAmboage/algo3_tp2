package edu.fiuba.algo3.modelo.Razas;

import edu.fiuba.algo3.modelo.Comunidad.ComunidadProtoss;
import edu.fiuba.algo3.modelo.Edificios.*;
import edu.fiuba.algo3.modelo.Razas.Tropas.Hidralisco;
import edu.fiuba.algo3.modelo.Razas.Tropas.Mutalisco;
import edu.fiuba.algo3.modelo.Razas.Tropas.Zerling;

public class GeneradorUnidadesProtoss {

    public static Unidad crearUnidadProtoo(String tipoUnidad) {
        ComunidadProtoss comunidadProtoss = ComunidadProtoss.obtenerInstanciaDeClase();
        if (tipoUnidad.equals("zangano")) {
            return new Zangano();
        } else if (tipoUnidad.equals("zerling")) {
            if (comunidadProtoss.existeUnidad(new ReservaDeReproduccion()))
                return new Zerling();
        } else if (tipoUnidad.equals("hidralisco")) {
            if (comunidadProtoss.existeUnidad(new Guarida()))
                return new Hidralisco();
        } else if (tipoUnidad.equals("mutalisco")){
            if(comunidadProtoss.existeUnidad(new Hidralisco()))
                return new Mutalisco();
        }
        else if(tipoUnidad.equals("nexo")){
            return new NexoMineral();
        }
        else if (tipoUnidad.equals("pilon")){
            return new Pilon();
        }
        else if(tipoUnidad.equals("asimilador")){
            return new Asimilador();
        }
        else if(tipoUnidad.equals("acceso")){
            return new Acceso();
        }
        else if(tipoUnidad.equals("puerto")){
            if(ComunidadProtoss.obtenerInstanciaDeClase().existeUnidad(new Acceso()))
                return new PuertaEstelar();
        }
        throw new IllegalArgumentException();
    }
}
