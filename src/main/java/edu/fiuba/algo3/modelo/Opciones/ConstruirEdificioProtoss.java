package edu.fiuba.algo3.modelo.Opciones;

public class ConstruirEdificioProtoss extends OpcionElegible{

    public ConstruirEdificioProtoss(String descripcion) {
        this.titulo = "Construir edificio protos";
        this.pertenceA = "protoss";
        this.rutaImagen = null;
        this.inforomacionSobreOpcion = descripcion;
        this.textoBoton = "Construir";
    }

    @Override
    public void gestionarClick() { System.out.println("funciona"); }
}
