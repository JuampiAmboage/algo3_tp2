package edu.fiuba.algo3.entrega_1;

import org.junit.jupiter.api.Test;

public class TestsVale {

    @Test
    public void caso13() {
        //Se destruye un criadero e igual se puede seguir construyendo sobre el moho que dejó
        CeldaLibre celda1 = new CeldaLibre();
        CeldaLibre celda2 = new CeldaLibre();
        //conecto las celdas para que esten una al lado de la otra
        celda1.direccionarNorte(celda2);
        celda1.direccionarEste(celda3);
        celda2.direccionarSur(celda1);
        celda2.direccionarSureste(celda3);

        Criadero criadero = new Criadero(4);
        celda1.construir(criadero); //Se construye el criadero en celda1, la celda 2 tiene moho
        celda1.destruirEstructura(); //Se destruye el criadero

        celda2.construirExtractor(); //no deberia saltar excepcion porque sigue teniendo el moho
    }

        @Test
    public void caso14() {
            //Un pilón no puede energizar en un área ya cubierta por moho (Es decir las construcciones
            //protoss no se pueden hacer sobre moho, por más que estén dentro del alcance de un
            //pilón)

            //como planteo las celdas para probarlo??
            Criadero criadero = new Criadero(4);
            celda1.construir(criadero); //deberia ser una funcion construirCriadero() que se encargue de crearlo?
            //Necesito un radio de 5 lleno de moho
            Pilar pilar1 = new Pilar();
            celda2.construir(pilar1);

            pilar1.expandirEnergia(); //deberia elegir una coordenada que este cubierta por moho pero tambien al alcance del pila
            celda3.energizada(); //deberia dar falso

            //sino
            CeldaConMoho celdaMoho = new CeldaConMoho();
            celdaMoho.energizar(); //deberia dar excepcion o false
            // El moho se puede expandir por un área no ocupada (es decir que no tenga un edificio ya
            // construido) aunque ésta esté energizada por un pilón.
            CeldaConEnergia celdaEnergizada = new CeldaConEnergia();
            celdaConEnergia.agregarMoho(); //no deberia saltar error
    }

    @Test
    public void caso15() {
        //Verificar que no se sigan recolectando ni gas ni mineral una vez agotados los recursos del
        //nodo mineral o del volcán.
        Volcan v = new Volcan();
        v.extraer(5000); //extrae  el gas total
        v.extraer(1); //salta excepcion o devuelve false

        NodoMineral nodo = new NodoMineral();
        nodo.extraer(2000); //extrae  el mineral total
        nodo.extraer(1); //salta excepcion o devuelve false
    }

    @Test
    public void caso16() {
        //Verificar que no se pueda construir sobre un volcán con una edificación ya existente
        Volcan v = new Volcan();
        v.construir(new Extractor()); //creo una estructura
        v.construir(new Extractor()); //salta error porque ya tiene una estructura

        //Verificar que no se pueda construir un nexo mineral si hay un zángano trabajando en él y
        //viceversa

        NodoMineral nodo1 = new NodoMineral();
        Zangano z1= new Zangano();
        CeldaLibre celda1 = new CeldaLibre();
        celda1.construir(nodo1);
        zangano.extraer(celda1);
        celda1.construir(NexoMineral new()); //deberia lanzar error

        NodoMineral nodo2 = new NodoMineral();
        Zangano z2= new Zangano();
        CeldaLibre celda2 = new CeldaLibre();
        celda2.construir(nodo2);
        celda2.construir(NexoMineral new());
        zangano.extraer(celda2); //deberia lanzar error
    }
}
