package edu.fiuba.algo3.modelo.Opciones;

public class MoverseHaciaAbajo extends OpcionElegible{
    public MoverseHaciaAbajo(String descripcion) {
        this.titulo = "Mover hacia abajo";
        // this.pertenceA = null;
        this.rutaImagen = null;
        this.inforomacionSobreOpcion = descripcion;
        this.textoBoton = "Mover";
    }

    @Override
    public void gestionarClick() { System.out.println("funciona"); }
}
