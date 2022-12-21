package edu.fiuba.algo3.modelo.Opciones;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Posicion.Posicion;

import java.util.ArrayList;

public abstract class OpcionElegible {
    public String titulo;
    public String pertenceA;

    public ArrayList<String> textoBotones = new ArrayList<>();
    public ArrayList<Posicion> posicionesEnemigas = new ArrayList<>();

    protected ArrayList<Celda> celdasConExtractor;
    protected ArrayList<Celda> celdasConTropas;


    public String obtenerTitulo() { return this.titulo; }
    public String obtenerPertenencia(){ return this.pertenceA; }

    public String obtenerTextoBoton(int index) { return this.textoBotones.get(index); }

    public int cantidadDeOpcionesInternas() { return this.textoBotones.toArray().length; }

    public void estblecerCeldasConExtractor(ArrayList<Celda> celdasConExtractor) {
        this.celdasConExtractor =  celdasConExtractor;
    }

    public void establecerCeldasConTropas(ArrayList<Celda> celdasConTropas) {
        this.celdasConTropas =  celdasConTropas;

        String nombreEnemigoAtacable;
        ArrayList<String> enemigosAtacables = new ArrayList<>();

        for (Celda celdaConTropa : celdasConTropas) {
            nombreEnemigoAtacable = "";

            if (celdaConTropa.obtenerOcupanteTerrestre().existe()) {
                nombreEnemigoAtacable = celdaConTropa.obtenerOcupanteTerrestre().obtenerNombreUnidad();
            }
            else if (celdaConTropa.obtenerOcupanteAereo().existe()) {
                nombreEnemigoAtacable = celdaConTropa.obtenerOcupanteAereo().obtenerNombreUnidad();
            }

            if (!nombreEnemigoAtacable.equals("")) {
                enemigosAtacables.add(nombreEnemigoAtacable);
                this.posicionesEnemigas.add(celdaConTropa.obtenerPosicion());
            }
        }

        this.textoBotones.addAll(enemigosAtacables);


    }

    public abstract void gestionarClick(Celda celda, String opcionElejida);



}
