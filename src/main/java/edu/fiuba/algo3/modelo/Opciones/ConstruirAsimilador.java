package edu.fiuba.algo3.modelo.Opciones;

import edu.fiuba.algo3.App;
import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Comunidad.ComunidadProtoss;
import edu.fiuba.algo3.modelo.Edificios.Asimilador;
import edu.fiuba.algo3.modelo.Edificios.NexoMineral;
import edu.fiuba.algo3.modelo.Excepciones.CeldaOcupada;
import edu.fiuba.algo3.modelo.Recursos.NodoMineral;
import edu.fiuba.algo3.modelo.Recursos.Volcan;

public class ConstruirAsimilador extends OpcionElegible {

    public ConstruirAsimilador(String descripcion) {
        this.titulo = "Construir asimilador";
        this.pertenceA = "protoss";
        this.textoBotones.add("Construir asimilador");
    }
    @Override
    public void gestionarClick(Celda celda, String opcionElejida) {
        try {
            Asimilador asimilador = new Asimilador((Volcan) celda.obtenerRecurso());
            ComunidadProtoss.obtenerInstanciaDeClase().construirEdificio(celda, asimilador);
            celda.instanciarUnidad(asimilador);
        }
        catch (CeldaOcupada celdaOcupada){
            App.lanzarWarning("Esta celda esta ocupada");
        }
    }

}
