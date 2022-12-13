package edu.fiuba.algo3.modelo.Opciones;

public class MoverseHaciaAbajo extends OpcionElegible{
    public MoverseHaciaAbajo() {
        this.titulo = "Mover hacia abajo";
        // this.pertenceA = null;
        this.rutaImagen = null;
        this.inforomacionSobreOpcion = "";
        this.textoBoton = "Mover";
    }

    @Override
    public void gestionarClick() { System.out.println("funciona"); }
}
