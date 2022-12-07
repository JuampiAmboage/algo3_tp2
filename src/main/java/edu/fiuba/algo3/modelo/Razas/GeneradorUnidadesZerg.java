package edu.fiuba.algo3.modelo.Razas;

import edu.fiuba.algo3.modelo.Comunidad.ComunidadZerg;
import edu.fiuba.algo3.modelo.Edificios.*;
import edu.fiuba.algo3.modelo.Razas.Tropas.Guardian;
import edu.fiuba.algo3.modelo.Razas.Tropas.Hidralisco;
import edu.fiuba.algo3.modelo.Razas.Tropas.Mutalisco;
import edu.fiuba.algo3.modelo.Razas.Tropas.Zerling;


public class GeneradorUnidadesZerg {
    public static Unidad crearTropaZerg(String tipoUnidad) {
        ComunidadZerg comunidadZerg = ComunidadZerg.obtenerInstanciaDeClase();
        if (tipoUnidad.equals("zangano")) {
            return new Zangano();
        } else if (tipoUnidad.equals("zerling")) {
            if (comunidadZerg.existeUnidad(new ReservaDeReproduccion()))
                return new Zerling();
        } else if (tipoUnidad.equals("hidralisco")) {
            if (comunidadZerg.existeUnidad(new Guarida()))
                return new Hidralisco();
        } else if (tipoUnidad.equals("mutalisco")){
            if(comunidadZerg.existeUnidad(new Hidralisco()))
                return new Mutalisco();
        } else if(tipoUnidad.equals("guardian")){
            if(comunidadZerg.existeUnidad(new Mutalisco()))
                return new Guardian();
        }
        throw new IllegalArgumentException();
    }

    public static Unidad crearEdificioZerg(String tipoEdificio){
        if(tipoEdificio.equals("criadero")){
            return new Criadero();
        }
        else if (tipoEdificio.equals("reserva")){
            return new ReservaDeReproduccion();
        }
        else if(tipoEdificio.equals("extractor")){
            return new Extractor();
        }
        else if(tipoEdificio.equals("guarida")){
            return new Guarida();
        }
        else if(tipoEdificio.equals("espiral")){
            if(ComunidadZerg.obtenerInstanciaDeClase().existeUnidad(new Guarida()))
                return new Espiral();
        }
        throw new IllegalArgumentException();
    }
}
