package edu.fiuba.algo3.modelo.Opciones;

public class AsignarTrabajoEnExtractor extends OpcionElegible{

    public AsignarTrabajoEnExtractor() {
        this.titulo = "Asignar trabajo en extractor";
        this.pertenceA = null;
        this.rutaImagen = null;
        this.inforomacionSobreOpcion = "";
        this.textoBoton = "Asignar trabajo";
    }

    @Override
    public void gestionarClick() {}
}
