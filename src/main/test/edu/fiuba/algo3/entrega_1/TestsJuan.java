package edu.fiuba.algo3.entrega_1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestsJuan {

    @Test
    public void caso09(){
        //Verificar que un edificio protoss sigue operativo si le destruyen un pilon que lo energiza
        //pero aún está dentro del rango de otro que también lo energiza.
        CeldaLibre celda1 = new CeldaLibre();
        CeldaLibre celda2 = new CeldaLibre();
        CeldaLibre celda3 = new CeldaLibre(); //instancio tres celdas
        //hago que las celdas formen un triángulo
        celda1.direccionarNorte(celda2);
        celda1.direccionarEste(celda3);
        celda2.direccionarSur(celda1);
        celda2.direccionarSureste(celda3);
        celda3.direccionarOeste(celda1);
        celda3.direccionarNoroeste(celda2);
        //creo dos pilares y los construyo en dos de las tres celdas
        Pilar pilar1 = new Pilar();
        Pilar pilar2 = new Pilar();

        //construyo un asimilador que va a estar en rango de ambos pilares
        Asimilador asimilador = new Asimilador();
        //celda3.construir(asimilador);
        //celda1.construir(pilar1);
        //celda2.construir(pilar2);

        /*aca iria el método donde el pilar se "expande" y energiza sus celdas limitrofes
        problablemente expandirEnergia() deba cambiarse */
        pilar1.expandirEnergia();
        pilar2.expandirEnergia();

        //destruyo un pilar
        celda1.destruirEstructura();

        assertEquals(asimilador.energizado());
        /*como las estructuras protoss necesitan energia para funcionar, seguramente tengamos que usar
        un metodo como este para saber si esta recibiendo energia o no*/
    }

    @Test
    public void caso10(){
        //Verificar que al dañar una construcción zerg, la misma recupera la vida por turnos hasta
        //volver a tener el 100%.

        CeldaMoho celda = new CeldaMoho();
        Criadero criadero = new Criadero();
        //celda.construir(criadero);
        celda.afectarEdificio(150); //el parametro es el daño, criadero tiene 500V, pasa a tener 350

        //ahora llamo al método reparar tres veces, emulando que se lo llama una vez por turno
        //tambien hago que por cada reparacion le den 50V (no lo aclara la consigna)
        celda.repararEdificio(50); //turno 1
        celda.repararEdificio(50); //turno 2
        celda.repararEdificio(50); //turno 3, aca ya vuelve a 500V
        assertEquals(500,celda.obtenerEdificio().obtenerVida());

        //OPCION 2: sin necesidad de usar celdas
        Criadero criader = new Criadero();
        criader.reducirVida(150);
        criader.aumentarVida(50);
        criader.aumentarVida(50);
        criader.aumentarVida(50);
        assertEquals(500,criader.obtenerVida());
    }

    @Test
    public void caso11(){
        //Verificar que al dañar una construcción protoss sin quitarle todo el escudo, la misma
        //recupera su escudo por turnos hasta volver a tener el 100% del mismo

        CeldaLibre celda = new CeldaLibre();
        NexoMineral nexoMineral = new NexoMineral();
        //celda.construir(pilon);
        celda.afectarEdificio(150); //le paso 150 de daño, pilon tiene 300E 300V, queda con 150E 300V

        //emulo tres turnos llamando tres veces a reparar
        celda.repararEdificio(50);
        celda.repararEdificio(50);
        celda.repararEdificio(50); //vuelve al escudo máximo

        assertEquals(300,celda.obtenerEdificio().obtenerEscudo());

        //OPCION 2: sin necesidad de usar celdas
        NexoMineral nexMineral = new NexoMineral();
        nexMineral.reducirVida(150);
        nexMineral.aumentarEscudo(50);
        nexMineral.aumentarEscudo(50);
        nexMineral.aumentarEscudo(50);
        assertEquals(500,nexMineral.obtenerEscudo());

    }

    @Test
    public void caso12(){
        /*Verificar que al dañar una construcción protoss quitandole todo el escudo y parte de la
        vida la misma recupera SOLO su escudo por turnos hasta volver a tener el 100% del
        mismo*/

        CeldaLibre celda = new CeldaLibre();
        Acceso acceso = new Acceso();
        //celda.construir(acceso);

        celda.afectarEdificio(700); //acceso tiene 500E 500V, va a quedar con 0E 300V
        celda.repararEdificio(200); //turno 1
        celda.repararEdificio(200); //turno 2
        celda.repararEdificio(200); //turno 3, acá ya se repara el escudo y sobran 100

        assertEquals(300,celda.obtenerEdificio().obtenerVida());
        //el sobrante de 100 no afecto a la vida, que sigue quedando en 300

        //OPCION 2: sin necesidad de usar celdas
        Acceso acceso_ = new Acceso();
        acceso_.reducirEscudo(700); /*el metodo reducirEscudo si ve que escudo estaría quedando en negativo
        llama a reducirVida para que le salpique el daño*/
        acceso_.aumentarEscudo(200);
        acceso_.aumentarEscudo(200);
        acceso_.aumentarEscudo(200);
        assertEquals(300,acceso_.obtenerVida());


    }



}
