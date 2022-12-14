package edu.fiuba.algo3.modelo.Opciones;

public class AtacarPorTierra extends OpcionElegible {

    public AtacarPorTierra(String descripcion) {
        this.titulo = "Ataque terrestre";
        // this.pertenceA = null;
        this.rutaImagen = null;
        this.inforomacionSobreOpcion = descripcion;
        this.textoBoton = "Atacar";
    }

    @Override
    public void gestionarClick() { System.out.println("funciona"); }
}
