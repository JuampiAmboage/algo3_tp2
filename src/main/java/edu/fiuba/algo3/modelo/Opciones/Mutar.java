package edu.fiuba.algo3.modelo.Opciones;

public class Mutar extends OpcionElegible{
    public Mutar(String descripcion) {
        this.titulo = "Mutar";
        this.pertenceA = "zerg";
        this.rutaImagen = null;
        this.inforomacionSobreOpcion = descripcion;
        this.textoBoton = this.titulo;
    }
    @Override
    public void gestionarClick() { System.out.println("funciona"); }
}
