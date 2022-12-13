package edu.fiuba.algo3.modelo.Opciones;

public class AtacarPorTierra extends OpcionElegible {

    public AtacarPorTierra() {
        this.titulo = "Ataque terrestre";
        // this.pertenceA = null;
        this.rutaImagen = null;
        this.inforomacionSobreOpcion = "";
        this.textoBoton = "Atacar";
    }

    @Override
    public void gestionarClick() {}
}
