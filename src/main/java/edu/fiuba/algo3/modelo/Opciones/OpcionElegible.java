package edu.fiuba.algo3.modelo.Opciones;

import edu.fiuba.algo3.controladores.ControladorVistaMapa;
import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Razas.Tropas.TropaAerea;
import edu.fiuba.algo3.modelo.Razas.Unidad;

import java.util.ArrayList;
import java.util.HashMap;

public abstract class OpcionElegible {
    public String titulo;
    public String pertenceA;

    public ArrayList<String> textoBotones = new ArrayList<>();

    protected ControladorVistaMapa controladorVistaMapa;

    protected ArrayList<Celda> celdasConExtractor;
    protected ArrayList<Celda> enemigosTerrestres = new ArrayList<>();
    protected ArrayList<Celda> enemigosAereos = new ArrayList<>();



    public String obtenerTitulo() { return this.titulo; }
    public String obtenerPertenencia(){ return this.pertenceA; }

    public String obtenerTextoBoton(int index) { return this.textoBotones.get(index); }

    public int cantidadDeOpcionesInternas() { return this.textoBotones.toArray().length; }

    public void estblecerCeldasConExtractor(ArrayList<Celda> celdasConExtractor) {
        this.celdasConExtractor =  celdasConExtractor;
    }

    public void establecerCeldasConTropas(ArrayList<Celda> celdasConTropas) {

        for (Celda celdaConTropa : celdasConTropas) {

            if (celdaConTropa.obtenerOcupanteTerrestre().existe()) {
                Celda enemigoAtacable = celdaConTropa;
                enemigosTerrestres.add(enemigoAtacable);
            }
            if (celdaConTropa.obtenerOcupanteAereo().existe()) {
                Celda enemigoAtacable = celdaConTropa;
                enemigosAereos.add(enemigoAtacable);
            }

        }
    }

    public void establecerControlador(ControladorVistaMapa controladorVistaMapa) {
        this.controladorVistaMapa = controladorVistaMapa;
    }

    public abstract void gestionarClick(Celda celda, String opcionElejida);

}
