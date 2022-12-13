package edu.fiuba.algo3.modelo.Opciones;

public class Mutar extends OpcionElegible{
    public Mutar() {
        this.titulo = "Mutar";
        this.pertenceA = null;
        this.rutaImagen = null;
        this.inforomacionSobreOpcion = "";
        this.textoBoton = this.titulo;
    }
    @Override
    public void gestionarClick() {}
}
