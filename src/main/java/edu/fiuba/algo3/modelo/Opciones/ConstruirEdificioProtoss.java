package edu.fiuba.algo3.modelo.Opciones;

import edu.fiuba.algo3.App;
import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Comunidad.ComunidadProtoss;
import edu.fiuba.algo3.modelo.Edificios.*;
import edu.fiuba.algo3.modelo.Excepciones.CeldaOcupada;

public class ConstruirEdificioProtoss extends OpcionElegible{

    public ConstruirEdificioProtoss(String descripcion) {
        this.titulo = "Construir edificio protos";
        this.pertenceA = "protoss";

        this.textoBotones.add("Pilon");
        this.textoBotones.add("Accseso");
        this.textoBotones.add("Puerto estelar");
    }

    @Override
    public void gestionarClick(Celda celda, String opcionElejida) {

        if (textoBotones.contains(opcionElejida)) {

            if (textoBotones.get(0).equals(opcionElejida)) {
                construirPilonEn(celda);
            }else if (textoBotones.get(1).equals(opcionElejida)){
                construirAccsesoEn(celda);
            }else{
                construirPuertoEn(celda);
            }

        }
    }

    private void construirPilonEn(Celda celda) {
        Pilon pilon = new Pilon();
        try {
            ComunidadProtoss.obtenerInstanciaDeClase().construirEdificio(celda, pilon);
            celda.instanciarUnidad(pilon);
        }
        catch (CeldaOcupada celdaOcupada){
            App.lanzarWarning("Esta celda esta ocupada");
        }
    }private void construirAccsesoEn(Celda celda) {
        Acceso acceso = new Acceso();
        try {
            ComunidadProtoss.obtenerInstanciaDeClase().construirEdificio(celda, acceso);
            celda.instanciarUnidad(acceso);
        }
        catch (CeldaOcupada celdaOcupada){
            App.lanzarWarning("Esta celda esta ocupada");
        }
    }
    private void construirPuertoEn(Celda celda) {
        PuertoEstelar puertoEstelar = new PuertoEstelar();
        try {
            ComunidadProtoss.obtenerInstanciaDeClase().construirEdificio(celda, puertoEstelar);
            celda.instanciarUnidad(puertoEstelar);
        }
        catch (CeldaOcupada celdaOcupada){
            App.lanzarWarning("Esta celda esta ocupada");
        }
    }

}
