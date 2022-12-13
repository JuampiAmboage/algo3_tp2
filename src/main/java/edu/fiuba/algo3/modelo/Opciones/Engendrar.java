package edu.fiuba.algo3.modelo.Opciones;

public class Engendrar extends OpcionElegible{

    public Engendrar() {
        this.titulo = "Engendrar";
        this.pertenceA = "zerg";
        this.rutaImagen = null;
        this.inforomacionSobreOpcion = "";
        this.textoBoton = this.titulo;
    }

    @Override
    public void gestionarClick() { System.out.println("funciona"); }
}
