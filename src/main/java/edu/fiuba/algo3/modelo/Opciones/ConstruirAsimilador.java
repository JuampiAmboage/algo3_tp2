package edu.fiuba.algo3.modelo.Opciones;

public class ConstruirAsimilador extends OpcionElegible {

    public ConstruirAsimilador(String descripcion) {
        this.titulo = "Construir asimilador";
        this.pertenceA = "protoss";
        this.rutaImagen = null;
        this.inforomacionSobreOpcion = descripcion;
        this.textoBoton = "Construir";
    }

    @Override
    public void gestionarClick() { System.out.println("funciona"); }
}
