module edu.fiuba.algo3 {
    requires javafx.controls;
    requires javafx.fxml;


    exports edu.fiuba.algo3;
    //opens edu.fiuba.algo3.controladores to java.fxml;

    exports edu.fiuba.algo3.modelo.Razas;
    exports edu.fiuba.algo3.modelo.Partida;
}