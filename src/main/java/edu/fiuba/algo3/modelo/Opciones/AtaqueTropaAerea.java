package edu.fiuba.algo3.modelo.Opciones;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Razas.Tropas.TropaAerea;
import edu.fiuba.algo3.modelo.Razas.Tropas.TropaTerrestre;

public class AtaqueTropaAerea  extends OpcionElegible {
    private Celda celdaAtacante;

    public AtaqueTropaAerea(String descripcion) {
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
                crearBotonesEnemigosAereos();
            } else {
                crearBotonesEnemigosTerrestres();
            }
        }
    }

    public void crearBotonesEnemigosTerrestres(){
        for (Celda celdaConTerrestre : this.enemigosTerrestres) {
            this.controladorVistaMapa.cambiarBotonAAtaque(celdaConTerrestre, this);
        }
    }
    public void crearBotonesEnemigosAereos(){
        for (Celda celdaConAereo : this.enemigosAereos) {
            this.controladorVistaMapa.cambiarBotonAAtaque(celdaConAereo, this);
        }
    }

    @Override
    public void atacar(Celda celdaAAtacar){
        System.out.println("Funciona");
    }
}
