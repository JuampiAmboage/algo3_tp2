package edu.fiuba.algo3.modelo.Opciones;

public class AsignarTrabajoEnNodoMineral extends OpcionElegible{
    //Nodo mineral o nexo mineral? pertenencia =? protoss
    public AsignarTrabajoEnNodoMineral() {
        this.titulo = "Asignar trabajo en nodo mineral";
        this.pertenceA = null;
        this.rutaImagen = null;
        this.inforomacionSobreOpcion = "";
        this.textoBoton = "Asignar trabajo";
    }

    @Override
    public void gestionarClick() {}
}

