package edu.fiuba.algo3.modelo.Opciones;

public class ConstruirNexoMineral extends OpcionElegible{

    public ConstruirNexoMineral(String descripcion) {
        this.titulo = "Construir nexo Mineral";
        this.pertenceA = "protoss";
        this.rutaImagen = null;
        this.inforomacionSobreOpcion = descripcion;
        this.textoBoton = "Construir";
    }

    @Override
    public void gestionarClick() { System.out.println("funciona"); }
}
