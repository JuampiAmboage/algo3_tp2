package edu.fiuba.algo3.modelo.Opciones;

public class SolicitarInformacion extends OpcionElegible{
    public SolicitarInformacion(String descripcion) {
        this.titulo = "Solicitar informacion";
        // this.pertenceA = null;
        this.rutaImagen = null;
        this.inforomacionSobreOpcion = descripcion;
        this.textoBoton = "Solicitar";
    }

    public void gestionarClick() { System.out.println("funciona"); }
}
