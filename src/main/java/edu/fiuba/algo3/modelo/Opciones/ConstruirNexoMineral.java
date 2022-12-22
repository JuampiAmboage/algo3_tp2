package edu.fiuba.algo3.modelo.Opciones;

import edu.fiuba.algo3.App;
import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Comunidad.ComunidadProtoss;
import edu.fiuba.algo3.modelo.Edificios.NexoMineral;
import edu.fiuba.algo3.modelo.Excepciones.CeldaOcupada;
import edu.fiuba.algo3.modelo.Recursos.NodoMineral;

public class ConstruirNexoMineral extends OpcionElegible{

    public ConstruirNexoMineral(String descripcion) {
        this.titulo = "Construir nexo Mineral";
        this.pertenceA = "protoss";
        this.textoBotones.add("Construir Nexo Mineral");
    }

    @Override
    public void gestionarClick(Celda celda, String opcionElejida) {
        NexoMineral nexoMineral = new NexoMineral((NodoMineral) celda.obtenerRecurso());
        try {
            ComunidadProtoss.obtenerInstanciaDeClase().construirEdificio(celda, nexoMineral);
            celda.instanciarUnidad(nexoMineral);
        }
        catch (CeldaOcupada celdaOcupada){
            App.lanzarWarning("Esta celda esta ocupada");
        }
    }

    @Override
    public void atacar(Celda celdaAAtacar){}
}
