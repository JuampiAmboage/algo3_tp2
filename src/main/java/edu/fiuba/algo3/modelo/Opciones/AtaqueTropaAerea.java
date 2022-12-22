package edu.fiuba.algo3.modelo.Opciones;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Razas.Tropas.TropaAerea;
import edu.fiuba.algo3.modelo.Razas.Tropas.TropaTerrestre;

public class AtaqueTropaAerea  extends OpcionElegible {
    private Celda celdaAtacante;
    public AtaqueTropaAerea() {
        this.titulo = "Atacar";
        this.textoBotones.add("Atacar tropa aérea");
        this.textoBotones.add("Atacar tropa en tierra");
    }

    @Override
    public void gestionarClick(Celda celda, String opcionElegida){
        this.celdaAtacante = celda;

        TropaAerea tropaAtacante = (TropaAerea) this.celdaAtacante.obtenerOcupanteTerrestre();
        if (textoBotones.contains(opcionElegida)) {
            if (textoBotones.get(0).equals(opcionElegida)) {
                crearBotonesEnemigosAereos(tropaAtacante);
            } else {
                crearBotonesEnemigosTerrestres(tropaAtacante);
            }
        }
    }
    public void crearBotonesEnemigosAereos(TropaAerea tropaAtacante){
        for (Celda celdaConAereo : this.enemigosAereos) {
            if(!tropaAtacante.unidadDesconocidaEnComunidadPropia(celdaConAereo.obtenerOcupanteAereo()))
                this.controladorVistaMapa.cambiarBotonAAtaque(celdaConAereo, this, this.celdaAtacante, this.textoBotones.get(0));
        }
    }
    public void crearBotonesEnemigosTerrestres(TropaAerea tropaAtacante){
        for (Celda celdaConTerrestre : this.enemigosTerrestres) {
            if(!tropaAtacante.unidadDesconocidaEnComunidadPropia(celdaConTerrestre.obtenerOcupanteTerrestre()))
                this.controladorVistaMapa.cambiarBotonAAtaque(celdaConTerrestre, this, this.celdaAtacante, this.textoBotones.get(1));
        }
    }

}
