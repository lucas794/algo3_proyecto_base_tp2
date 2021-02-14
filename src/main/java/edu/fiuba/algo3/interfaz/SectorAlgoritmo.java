package edu.fiuba.algo3.interfaz;

import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class SectorAlgoritmo extends Pane {

    public SectorAlgoritmo(){
        Label text = new Label("Espacio de Trabajo");
        this.getChildren().add(text);
    }

}
