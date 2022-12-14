package edu.fiuba.algo3.modelo.Opciones;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Comunidad.ComunidadProtoss;
import edu.fiuba.algo3.modelo.Comunidad.ComunidadZerg;
import edu.fiuba.algo3.modelo.Edificios.Asimilador;
import edu.fiuba.algo3.modelo.Edificios.Extractor;
import edu.fiuba.algo3.modelo.Razas.Tropas.Zangano;
import edu.fiuba.algo3.modelo.Recursos.Volcan;

public class ConstruirExtractor extends OpcionElegible{
    public ConstruirExtractor(String descripcion) {
        this.titulo = "Construir extractor";
        this.pertenceA = "zerg";
        this.rutaImagen = null;
        this.inforomacionSobreOpcion = descripcion;
        this.textoBoton = "Construir";
    }

    @Override
    public void gestionarClick(Celda celda) {
        Zangano zanganoAEvolucionar = (Zangano) celda.obtenerOcupanteTerrestre();
        ComunidadZerg.obtenerInstanciaDeClase().construirEdificio(celda,zanganoAEvolucionar,new Extractor((Volcan) celda.obtenerRecurso())); }
}
