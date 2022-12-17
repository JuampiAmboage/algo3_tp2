package edu.fiuba.algo3.modelo.Opciones;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Comunidad.ComunidadZerg;
import edu.fiuba.algo3.modelo.Edificios.Criadero;
import edu.fiuba.algo3.modelo.Razas.Tropas.*;


public class Engendrar extends OpcionElegible{

    public Engendrar(String descripcion) {
        this.titulo = "Engendrar";
        this.pertenceA = "zerg";
        this.textoBotones.add("Engendrar zangano");
        this.textoBotones.add("Engendrar zerling");
        this.textoBotones.add("Engendrar hidralisco");
        this.textoBotones.add("Engendrar mutalisco");
        this.textoBotones.add("Engendrar amo supremo");
    }

    public void gestionarClick(Celda celda, String opcionElejida){
        Criadero criadero = (Criadero) celda.obtenerOcupanteTerrestre();
        if (textoBotones.contains(opcionElejida)) {

            if (textoBotones.get(0).equals(opcionElejida)) {
                engendrarZangano(celda,criadero);
            }else if (textoBotones.get(1).equals(opcionElejida)){
                engendrarZerling(celda,criadero);}
            else if (textoBotones.get(2).equals(opcionElejida)){
                engendrarHidralisco(celda,criadero);}
            else if (textoBotones.get(3).equals(opcionElejida)){
                engendrarMutalisco(celda,criadero);}
            else{
                engendrarAmoSupremo(celda,criadero);
            }

        }
    }

    public void engendrarZangano(Celda celda, Criadero criadero){
        Zangano zangano = new Zangano();
        ComunidadZerg.obtenerInstanciaDeClase().crearUnidadTerrestre(criadero,zangano);
        celda.instanciarUnidad(zangano);
    }
    public void engendrarZerling(Celda celda, Criadero criadero){
        Zerling zerling = new Zerling();
        ComunidadZerg.obtenerInstanciaDeClase().crearUnidadTerrestre(criadero,zerling);
        celda.instanciarUnidad(zerling);
    }
    public void engendrarHidralisco(Celda celda, Criadero criadero){
        Hidralisco hidralisco = new Hidralisco();
        ComunidadZerg.obtenerInstanciaDeClase().crearUnidadTerrestre(criadero,hidralisco);
        celda.instanciarUnidad(hidralisco);
    }
    public void engendrarMutalisco(Celda celda, Criadero criadero){
        Mutalisco mutalisco = new Mutalisco();
        ComunidadZerg.obtenerInstanciaDeClase().crearUnidadAerea(criadero,mutalisco);
        celda.instanciarUnidad(mutalisco);
    }

    public void engendrarAmoSupremo(Celda celda, Criadero criadero){
        AmoSupremo amoSupremo = new AmoSupremo();
        ComunidadZerg.obtenerInstanciaDeClase().crearUnidadAerea(criadero,amoSupremo);
        celda.instanciarUnidad(amoSupremo);
    }

    /*public void gestionarClick(Celda celda) {
        Tropa unidadAEngendrar = obtenerTropa();
        Criadero criadero = (Criadero) celda.obtenerOcupanteTerrestre();
        ComunidadZerg.obtenerInstanciaDeClase().crearUnidad(criadero,unidadAEngendrar);
    }


    private Tropa obtenerTropa() {
        // TODO: Mostrar ventana con opciones.
        Opciones de tropas: Zangano, Zerling, Hidralisco, Mutalisco, Amo Supremo

        return tropa;
    }*/
}
