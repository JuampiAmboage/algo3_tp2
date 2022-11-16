package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.Celdas.Celda;
import edu.fiuba.algo3.modelo.Comunidad.Comunidad;
import edu.fiuba.algo3.modelo.Edificios.Asimilador;
import edu.fiuba.algo3.modelo.Edificios.Edificio;

public class Jugador {
    private String nombre, color;
    Comunidad comunidad;

    public Jugador(String nombre, Racita[] raza){
        this.nombre = nombre;
        this.comunidad = new Comunidad(raza);
    }
    //TODO LO DE ABAJO ESTA EN REVISION, SON DOS OPCIONES DISTINTAS
    public void construirUnAsimilador(Celda celda){
        Asimilador.setCostoEnMinerales(100);
        Asimilador.setCostoEnGas(0); //estas dos instanciaciones NO van acá, solo están para entender mejor como funca

        if (comunidad.recursosSuficientes(Asimilador.obtenerCostoEnMinerales(),Asimilador.obtenerCostoEnMinerales())){
           Asimilador asimilador = new Asimilador();
           comunidad.agregar_edificio(asimilador);
           asimilador.construirEn(celda);
           comunidad.restarRecursos(Asimilador.obtenerCostoEnMinerales(),Asimilador.obtenerCostoEnGas());
        }
    }

    public void construir(Edificio edificioAConstruir, Celda celda){
        if(comunidad.recursosSuficientes(edificioAConstruir.obtenerCostoMinerales(),edificioAConstruir.obtenerCostoGas())){
            edificioAConstruir.construirEn(celda);
            comunidad.restarRecursos(edificioAConstruir.obtenerCostoMinerales(),edificioAConstruir.obtenerCostoGas());
        }
        else{
            //tira error y la instancia que viene por parámetro se la lleva el trash
        }
    }
}
