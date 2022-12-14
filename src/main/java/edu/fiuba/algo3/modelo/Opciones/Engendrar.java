package edu.fiuba.algo3.modelo.Opciones;

public class Engendrar extends OpcionElegible{

    public Engendrar(String descripcion) {
        this.titulo = "Engendrar";
        this.pertenceA = "zerg";
        this.rutaImagen = null;
        this.inforomacionSobreOpcion = descripcion;
        this.textoBoton = this.titulo;
    }

    @Override
    public void gestionarClick() { System.out.println("funciona"); }
}
