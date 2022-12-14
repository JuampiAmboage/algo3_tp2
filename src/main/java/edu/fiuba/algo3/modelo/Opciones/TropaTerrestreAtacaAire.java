package edu.fiuba.algo3.modelo.Opciones;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Excepciones.CeldaOcupada;
import edu.fiuba.algo3.modelo.Razas.Tropas.Tropa;
import edu.fiuba.algo3.modelo.Razas.Tropas.TropaAerea;

public class TropaTerrestreAtacaAire extends OpcionElegible{

    public TropaTerrestreAtacaAire(String descripcion) {
        this.titulo = "Ataque aereo";
        // this.pertenceA = null;
        this.rutaImagen = null;
        this.inforomacionSobreOpcion = descripcion;
        this.textoBoton = "Atacar";
    }

    public void gestionarClick(Celda celdaAtacante, Celda celdaAtacado) {
        Tropa tropaAtacante = (Tropa) celdaAtacante.obtenerOcupanteTerrestre();
        try{
            celdaAtacante.estaOcupadaPorAire();
        }
        catch (CeldaOcupada celdaOcupada) {
            TropaAerea tropaAtacada = celdaAtacado.obtenerOcupanteAereo();
            tropaAtacante.atacarAire(tropaAtacada);
        }
    }
}
