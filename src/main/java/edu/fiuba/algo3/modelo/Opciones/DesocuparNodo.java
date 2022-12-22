package edu.fiuba.algo3.modelo.Opciones;

import edu.fiuba.algo3.App;
import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Comunidad.ComunidadZerg;
import edu.fiuba.algo3.modelo.Edificios.Extractor;
import edu.fiuba.algo3.modelo.Excepciones.CeldaOcupada;
import edu.fiuba.algo3.modelo.Razas.Tropas.Zangano;
import edu.fiuba.algo3.modelo.Recursos.Volcan;

public class DesocuparNodo extends OpcionElegible{
    public DesocuparNodo(String descripcion) {
        this.titulo = "Desocupar nodo";
        this.pertenceA = "zerg";
        this.textoBotones.add("Desocupar nodo");
    }

    @Override
    public void gestionarClick(Celda celda, String opcionElejida) {
        Zangano zangano = (Zangano) celda.obtenerOcupanteTerrestre();
        zangano.liberarDeNodo();
    }

}
