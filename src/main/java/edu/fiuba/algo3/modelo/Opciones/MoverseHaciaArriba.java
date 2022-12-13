package edu.fiuba.algo3.modelo.Opciones;

public class MoverseHaciaArriba extends OpcionElegible{
    public MoverseHaciaArriba() {
        this.titulo = "Mover hacia arriba";
        // this.pertenceA = null;
        this.rutaImagen = null;
        this.inforomacionSobreOpcion = "";
        this.textoBoton = "Mover";
    }
    @Override
    public void gestionarClick() { System.out.println("funciona"); }
}
