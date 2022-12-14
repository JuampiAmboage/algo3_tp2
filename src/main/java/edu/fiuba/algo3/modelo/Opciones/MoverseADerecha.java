package edu.fiuba.algo3.modelo.Opciones;

public class MoverseADerecha extends OpcionElegible{
    public MoverseADerecha(String descripcion) {
        this.titulo = "Mover a la derecha";
        // this.pertenceA = null;
        this.rutaImagen = null;
        this.inforomacionSobreOpcion = descripcion;
        this.textoBoton = "Mover";
    }

    @Override
    public void gestionarClick() { System.out.println("funciona"); }
}
