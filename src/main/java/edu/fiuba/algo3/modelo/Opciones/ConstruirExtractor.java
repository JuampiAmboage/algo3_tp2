package edu.fiuba.algo3.modelo.Opciones;

public class ConstruirExtractor extends OpcionElegible{
    public ConstruirExtractor() {
        this.titulo = "Construir extractor";
        this.pertenceA = "zerg";
        this.rutaImagen = null;
        this.inforomacionSobreOpcion = "";
        this.textoBoton = "Construir";
    }

    @Override
    public void gestionarClick() { System.out.println("funciona"); }
}
