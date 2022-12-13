package edu.fiuba.algo3.modelo.Opciones;

public class Mutar extends OpcionElegible{
    public Mutar() {
        this.titulo = "Mutar";
        this.pertenceA = "zerg";
        this.rutaImagen = null;
        this.inforomacionSobreOpcion = "";
        this.textoBoton = this.titulo;
    }
    @Override
    public void gestionarClick() { System.out.println("funciona"); }
}
