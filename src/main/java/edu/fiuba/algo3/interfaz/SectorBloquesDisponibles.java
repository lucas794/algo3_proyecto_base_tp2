package edu.fiuba.algo3.interfaz;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class SectorBloquesDisponibles extends VBox {

    public SectorBloquesDisponibles(){
        Label upper = new Label("Bloques Disponibles");
        this.getChildren().add(upper);
    }

}
