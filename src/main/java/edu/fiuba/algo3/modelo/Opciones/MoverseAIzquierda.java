package edu.fiuba.algo3.modelo.Opciones;

public class MoverseAIzquierda extends OpcionElegible{

    public MoverseAIzquierda() {
        this.titulo = "Mover a la izquierda";
        // this.pertenceA = null;
        this.rutaImagen = null;
        this.inforomacionSobreOpcion = "";
        this.textoBoton = "Mover";
    }

    @Override
    public void gestionarClick() { System.out.println("funciona"); }
}
