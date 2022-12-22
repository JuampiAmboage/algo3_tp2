package edu.fiuba.algo3.modelo.Razas.Tropas;

import edu.fiuba.algo3.modelo.Ataque.AtacarTierra;
import edu.fiuba.algo3.modelo.Comunidad.ComunidadProtoss;
import edu.fiuba.algo3.modelo.Edificios.Acceso;

import edu.fiuba.algo3.modelo.Opciones.AtaqueTropaAerea;
import edu.fiuba.algo3.modelo.Opciones.AtaqueTropaTerrestre;
import edu.fiuba.algo3.modelo.Opciones.MoverTerrestre;
import edu.fiuba.algo3.modelo.Posicion.Posicion;
import edu.fiuba.algo3.modelo.Rango.RangoAtaque;
import edu.fiuba.algo3.modelo.Razas.Unidad;
import edu.fiuba.algo3.modelo.Salud.VidaConEscudo;
import edu.fiuba.algo3.modelo.Visibilidad.Invisible;
import edu.fiuba.algo3.modelo.Visibilidad.VisibilidadCambiante;
import edu.fiuba.algo3.modelo.Visibilidad.Visible;

public class Zealot extends TropaTerrestre implements VisibilidadCambiante {
    Invisible invisible;
    int bajasGeneradas;
    public Zealot(){
        super();
        ataque = new AtacarTierra();
        costoEnMinerales = 100;
        costoEnGas = 0;
        tiempoConstruccion = 4;
        danioTerrestre = 8;
        danioAereo = 0;
        suministro = 2;
        vida = new VidaConEscudo(100,60);
        bajasGeneradas = 0;
        edificioNecesario = new Acceso();
        comunidad = ComunidadProtoss.obtenerInstanciaDeClase();

        this.rutaSprite = this.rutaSprite + "tropas/protoss/zealot.png";
        opciones.add(new MoverTerrestre("protoss"));
        opciones.add(new AtaqueTropaTerrestre("protoss"));
        this.nombreUnidad = "Zelaot";

    }

    @Override
    public void instanciacionesIniciales(Posicion posicionALocalizar){
        this.posicion = posicionALocalizar;
        this.rangoAtaque = new RangoAtaque(this,1,posicion);
    }

    public void realizarAccionesTurno() {
        this.vida.pasarTurno();
        this.cantidadMovimientos = 0;
        cantidadAtaques = 0;


    }
    @Override
    public void atacarTierra(Unidad unidadAtacable){
        ataque.atacarTierra(rangoAtaque,unidadAtacable,danioTerrestre);
        if(unidadAtacable.estaSinVida()) {
            this.bajasGeneradas++;
            if(bajasGeneradas == 3)
                this.volverInsvisible();
        }
    }
    public void volverVisible(){ visibilidad = new Visible(this);}
    public void volverInsvisible(){
        visibilidad = new Invisible(this);
    }
    public int obtenerEscudo(){return vida.getEscudoActual();}

    public String obtenerSprite() { return this.rutaSprite; }

    @Override
    public String obtenerDescripcion() {
        String descripcion = "";
        return descripcion;
    }
}
