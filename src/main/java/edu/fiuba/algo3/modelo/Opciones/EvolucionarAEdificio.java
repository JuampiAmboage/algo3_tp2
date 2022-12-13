package edu.fiuba.algo3.modelo.Opciones;

public class EvolucionarAEdificio extends OpcionElegible{

    public EvolucionarAEdificio() {
        this.titulo = "Evolucionar a edificio";
        this.pertenceA = null;
        this.rutaImagen = null;
        this.inforomacionSobreOpcion = "";
        this.textoBoton = "evolucionar";
    }

    @Override
    public void gestionarClick() {}
}
