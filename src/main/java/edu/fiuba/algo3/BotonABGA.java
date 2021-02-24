package edu.fiuba.algo3;

import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class BotonABGA extends Button implements Observador {
    
    public BotonABGA(String nombre) {
        super(nombre);
        this.setDisable(true);
    }

    @Override
    public void cambios(VBox contenedor) {
        this.setDisable(contenedor.getChildren().size() != 0);
    }
}
