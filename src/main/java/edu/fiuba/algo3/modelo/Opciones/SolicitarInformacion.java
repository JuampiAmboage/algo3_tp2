package edu.fiuba.algo3.modelo.Opciones;

public class SolicitarInformacion extends OpcionElegible{
    public SolicitarInformacion() {
        this.titulo = "Solicitar informacion";
        // this.pertenceA = null;
        this.rutaImagen = null;
        this.inforomacionSobreOpcion = "";
        this.textoBoton = "Solicitar";
    }

    @Override
    public void gestionarClick() {}
}
