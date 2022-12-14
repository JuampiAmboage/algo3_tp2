package edu.fiuba.algo3.modelo.Opciones;

public class EvolucionarAEdificio extends OpcionElegible{

    public EvolucionarAEdificio(String descripcion) {
        this.titulo = "Evolucionar a edificio";
        this.pertenceA = "zerg";
        this.rutaImagen = null;
        this.inforomacionSobreOpcion = descripcion;
        this.textoBoton = "evolucionar";
    }

    @Override
    public void gestionarClick() { System.out.println("funciona"); }
}
