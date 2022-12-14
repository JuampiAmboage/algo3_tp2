package edu.fiuba.algo3.modelo.Opciones;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Razas.Tropas.Tropa;
import edu.fiuba.algo3.modelo.Razas.Tropas.TropaAerea;
import edu.fiuba.algo3.modelo.Razas.Unidad;

public class AtacarPorTierra extends OpcionElegible {

    public AtacarPorTierra(String descripcion) {
        this.titulo = "Ataque terrestre";
        // this.pertenceA = null;
        this.rutaImagen = null;
        this.inforomacionSobreOpcion = descripcion;
        this.textoBoton = "Atacar";
    }

    @Override
    public void gestionarClick(Celda celdaAtacante, Celda celdaAtacado) {
        Tropa tropaAtacante = (Tropa) celdaAtacante.obtenerOcupanteTerrestre();
        Unidad tropaAtacada = celdaAtacado.obtenerOcupanteTerrestre();
        tropaAtacante.atacarTierra(tropaAtacada);
    }
}
