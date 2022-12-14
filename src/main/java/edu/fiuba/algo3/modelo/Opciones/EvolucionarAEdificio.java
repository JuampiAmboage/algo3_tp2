package edu.fiuba.algo3.modelo.Opciones;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Comunidad.ComunidadZerg;
import edu.fiuba.algo3.modelo.Edificios.*;
import edu.fiuba.algo3.modelo.Razas.Tropas.Zangano;

public class EvolucionarAEdificio extends OpcionElegible{

    public EvolucionarAEdificio(String descripcion) {
        this.titulo = "Evolucionar a edificio";
        this.pertenceA = "zerg";
        this.rutaImagen = null;
        this.inforomacionSobreOpcion = descripcion;
        this.textoBoton = "evolucionar";
    }

    @Override
    public void gestionarClick(Celda celda, String opcionElejida) {
        Zangano zanganoAEvolucionar = (Zangano) celda.obtenerOcupanteTerrestre();
        if (textoBotones.contains(opcionElejida)) {

            if (textoBotones.get(0).equals(opcionElejida)) {
                construirCriaderoEn(celda,zanganoAEvolucionar);
            }else if (textoBotones.get(1).equals(opcionElejida)){
                construirReservaReproduccionEn(celda,zanganoAEvolucionar);
            }
            else if (textoBotones.get(2).equals(opcionElejida)) {
                construirReservaReproduccionEn(celda,zanganoAEvolucionar);
            }
            else if (textoBotones.get(3).equals(opcionElejida)){
                construirGuaridaEn(celda,zanganoAEvolucionar);}
            else{
                construirEspiralEn(celda,zanganoAEvolucionar);
            }

        }
    }

    public void construirCriaderoEn(Celda celda,Zangano zangano){
        Criadero criadero = new Criadero();
        ComunidadZerg.obtenerInstanciaDeClase().construirEdificio(celda,zangano,criadero);
        celda.instanciarUnidad(criadero);
    }

    public void construirGuaridaEn(Celda celda,Zangano zangano){
        Guarida guarida = new Guarida();
        ComunidadZerg.obtenerInstanciaDeClase().construirEdificio(celda,zangano,guarida);
        celda.instanciarUnidad(guarida);
    }

    public void construirReservaReproduccionEn(Celda celda,Zangano zangano){
        ReservaDeReproduccion reservaDeReproduccion = new ReservaDeReproduccion();
        ComunidadZerg.obtenerInstanciaDeClase().construirEdificio(celda,zangano,reservaDeReproduccion);
        celda.instanciarUnidad(reservaDeReproduccion);
    }

    public void construirEspiralEn(Celda celda,Zangano zangano){
        Espiral espiral = new Espiral();
        ComunidadZerg.obtenerInstanciaDeClase().construirEdificio(celda,zangano,espiral);
        celda.instanciarUnidad(espiral);
    }
/*
    public void gestionarClick(Celda celdaAConstruir) {
        Edificio edificioAConstruir = obtenerEdificioAConstruir();
        Zangano zanganoAEvolucionar = (Zangano) celdaAConstruir.obtenerOcupanteTerrestre();
        ComunidadZerg.obtenerInstanciaDeClase().construirEdificio(celdaAConstruir,zanganoAEvolucionar,edificioAConstruir);
        celdaAConstruir.instanciarUnidad(edificioAConstruir);
    }

    private Edificio obtenerEdificioAConstruir(){
        // TODO: Mostrar ventana con opciones.
        Opciones de edificio: Criadero, Reserva De Reproduccion, Guarida, Espiral

        return edificioAConstruir;
    }*/
}
