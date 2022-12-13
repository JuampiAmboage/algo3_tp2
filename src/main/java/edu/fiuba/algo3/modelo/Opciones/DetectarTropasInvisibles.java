package edu.fiuba.algo3.modelo.Opciones;

public class DetectarTropasInvisibles extends OpcionElegible{

    public DetectarTropasInvisibles() {
        this.titulo = "Detectar tropas invisibles";
        this.pertenceA = "zerg";
        this.rutaImagen = null;
        this.inforomacionSobreOpcion = "";
        this.textoBoton = "Detectar";
    }
    @Override
    public void gestionarClick() { System.out.println("funciona"); }
}
