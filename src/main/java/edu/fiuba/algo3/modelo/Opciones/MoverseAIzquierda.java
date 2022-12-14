package edu.fiuba.algo3.modelo.Opciones;

public class MoverseAIzquierda extends OpcionElegible{

    public MoverseAIzquierda(String descripcion) {
        this.titulo = "Mover a la izquierda";
        // this.pertenceA = null;
        this.rutaImagen = null;
        this.inforomacionSobreOpcion = descripcion;
        this.textoBoton = "Mover";
    }

    @Override
    public void gestionarClick() { System.out.println("funciona"); }
}
