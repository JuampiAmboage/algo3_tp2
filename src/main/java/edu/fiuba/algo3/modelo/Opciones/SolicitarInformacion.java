package edu.fiuba.algo3.modelo.Opciones;

import edu.fiuba.algo3.modelo.Celdas.Celda;

public class SolicitarInformacion extends OpcionElegible{
    public SolicitarInformacion(String descripcion) {
        this.titulo = "Solicitar informacion";
        // this.pertenceA = null;
        this.rutaImagen = null;
        this.inforomacionSobreOpcion = descripcion;
        this.textoBotones.add("Solicitar");
    }

    @Override
    public void gestionarClick(Celda celda, String opcionElejida) { System.out.println("funciona"); }
}
