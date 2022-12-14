package edu.fiuba.algo3.modelo.Opciones;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Excepciones.CeldaOcupada;
import edu.fiuba.algo3.modelo.Razas.Tropas.Tropa;
import edu.fiuba.algo3.modelo.Razas.Tropas.TropaAerea;
import edu.fiuba.algo3.modelo.Razas.Unidad;

public class TropaAereaAtacaTierra extends OpcionElegible{
    public TropaAereaAtacaTierra(String descripcion) {
        this.titulo = "Ataque terrestre";
        // this.pertenceA = null;
        this.rutaImagen = null;
        this.inforomacionSobreOpcion = descripcion;
        this.textoBotones.add("Atacar");
    }

    public void gestionarClick(Celda celdaAtacante, Celda celdaAtacado) {
        TropaAerea tropaAtacante = celdaAtacante.obtenerOcupanteAereo();
        try{
            celdaAtacante.estaOcupadaPorTierra();
        }
        catch (CeldaOcupada celdaOcupada) {
            Unidad tropaAtacada = celdaAtacado.obtenerOcupanteTerrestre();
            tropaAtacante.atacarTierra(tropaAtacada);
        }
    }
}
