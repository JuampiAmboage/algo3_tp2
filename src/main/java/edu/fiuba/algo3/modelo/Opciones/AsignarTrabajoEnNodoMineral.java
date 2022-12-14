package edu.fiuba.algo3.modelo.Opciones;

public class AsignarTrabajoEnNodoMineral extends OpcionElegible{
    //Nodo mineral o nexo mineral? pertenencia =? protoss
    public AsignarTrabajoEnNodoMineral(String descripcion) {
        this.titulo = "Asignar trabajo en nodo mineral";
        this.pertenceA = null;
        this.rutaImagen = null;
        this.inforomacionSobreOpcion = descripcion;
        this.textoBoton = "Asignar trabajo";
    }

    @Override
    public void gestionarClick() { System.out.println("funciona"); }
}

