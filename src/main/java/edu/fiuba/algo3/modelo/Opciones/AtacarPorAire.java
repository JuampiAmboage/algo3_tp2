package edu.fiuba.algo3.modelo.Opciones;

public class AtacarPorAire extends OpcionElegible{

    public AtacarPorAire(String descripcion) {
        this.titulo = "Ataque aereo";
        // this.pertenceA = null;
        this.rutaImagen = null;
        this.inforomacionSobreOpcion = descripcion;
        this.textoBoton = "Atacar";
    }

    @Override
    public void gestionarClick() { System.out.println("funciona"); }
}
