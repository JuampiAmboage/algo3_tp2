package edu.fiuba.algo3.modelo.Opciones;

public class AsignarTrabajoEnExtractor extends OpcionElegible{

    public AsignarTrabajoEnExtractor(String descripcion) {
        this.titulo = "Asignar trabajo en extractor";
        this.pertenceA = "zerg";
        this.rutaImagen = null;
        this.inforomacionSobreOpcion = descripcion;
        this.textoBoton = "Asignar trabajo";
    }

    @Override
    public void gestionarClick() { System.out.println("funciona"); }
}
