module edu.fiuba.algo3 {
    requires javafx.controls;
    requires javafx.fxml;


    exports edu.fiuba.algo3;
    exports edu.fiuba.algo3.controladores;

    opens edu.fiuba.algo3.controladores;

    exports edu.fiuba.algo3.modelo.Razas;
    exports edu.fiuba.algo3.modelo.Partida;
}