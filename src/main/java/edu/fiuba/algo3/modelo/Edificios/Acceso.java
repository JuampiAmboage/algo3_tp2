package edu.fiuba.algo3.modelo.Edificios;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Celdas.CeldaConMoho;
import edu.fiuba.algo3.modelo.Celdas.CeldaEnergizada;
import edu.fiuba.algo3.modelo.Celdas.CeldaLibre;
import edu.fiuba.algo3.modelo.Comunidad.ComunidadProtoss;
import edu.fiuba.algo3.modelo.Excepciones.ConstruccionProhibida;
import edu.fiuba.algo3.modelo.Visibilidad.Visible;
import edu.fiuba.algo3.modelo.Recursos.NoRecurso;
import edu.fiuba.algo3.modelo.Recursos.NodoMineral;
import edu.fiuba.algo3.modelo.Recursos.Volcan;
import edu.fiuba.algo3.modelo.Salud.Salud;
import edu.fiuba.algo3.modelo.Salud.VidaConEscudo;

public class Acceso extends EdificioProtoss implements Construible {

    private Salud vida;
    public Acceso(){
        super();
        this.tiempoConstruccion = 8;
        this.vida = new VidaConEscudo(500, 500);
        this.comunidad = ComunidadProtoss.obtenerInstanciaDeClase();
        this.visibilidad = new Visible(this);
        this.rutaSprite = this.rutaSprite + "edificios/acceso.png";
    }
    @Override
    public void construirSobreRecurso(NoRecurso tipoRecurso) {throw  new ConstruccionProhibida();}
    @Override
    public void construirSobreRecurso(NodoMineral tipoRecurso) {
        throw new ConstruccionProhibida();
    }
    @Override
    public void construirSobreRecurso(Volcan tipoRecurso) {
        throw new ConstruccionProhibida();
    }
    @Override
    public void construirSobreTipo(CeldaConMoho tipo) {}
    @Override
    public void construirSobreTipo(CeldaEnergizada tipo) {
        throw new ConstruccionProhibida();
    }
    @Override
    public void construirSobreTipo(CeldaLibre tipo) {
        throw new ConstruccionProhibida();
    }
    @Override
    public void construirSobre(Celda celda) {
        celda.quiereConstruir(this);
    }

    @Override
    public String obtenerSprite() { return this.rutaSprite; }

    @Override
<<<<<<< HEAD
    public void mostrarDescripcion() {
        System.out.println("-Acceso-");
        System.out.println("Permite construir: Puerto Estelar.");
        System.out.println("Permite generar: Zealot, Dragon. \n");
        System.out.println("Escudo actual: " + this.vida.getEscudoActual());
        System.out.println("Vida actual: "+ this.vida.getVidaActual());
=======
    public String obtenerDescripcion() {
        String descripcion = "";
        return descripcion;
>>>>>>> manejoDeOpciones
    }
}
