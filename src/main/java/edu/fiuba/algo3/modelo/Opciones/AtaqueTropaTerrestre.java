package edu.fiuba.algo3.modelo.Opciones;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Razas.Tropas.TropaTerrestre;

public class AtaqueTropaTerrestre extends OpcionElegible{
    public AtaqueTropaTerrestre(String descripcion) {
        this.titulo = "Atacar";
        this.textoBotones.add("Atacar tropa aérea");
        this.textoBotones.add("Atacar tropa en tierra");
    }
    public void crearBotonesEnemigosTerrestres(){
        this.textoBotones.addAll(enemigosTerrestres.keySet());
    }
    public void crearBotonesEnemigosAereos(){
        this.textoBotones.addAll(enemigosAereos.keySet());
    }
    public void gestionarClick(Celda celda, String opcionElegida){
        TropaTerrestre tropaAtacante = (TropaTerrestre) celda.obtenerOcupanteTerrestre();
        if (textoBotones.contains(opcionElegida)) {
            if (textoBotones.get(0).equals(opcionElegida)) {
                crearBotonesEnemigosAereos();
                //seleccionan enemigo
                //enemigoSeleccionado.cambiarSprite(""); esto no va, pero lo dejo como ref
                //hacer que controlarVistaMapa lea solo esta celda y actualice el sprite
                textoBotones.add("Confirmar ataque");
                tropaAtacante.atacarTierra(enemigoSeleccionado);
                enemigoSeleccionado.restablecerSprite(); //vuelve al original
            }
            else {
                crearBotonesEnemigosTerrestres();
                //lo mismo de arriba pero atancando a aire
            }
        }
    }
}
