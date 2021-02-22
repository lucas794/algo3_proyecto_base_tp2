package edu.fiuba.algo3.interfaz;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class SectorAlgoritmo extends VBox {

    public SectorAlgoritmo(){
        Label text = new Label("Espacio de Trabajo");
        text.setMaxWidth(Double.MAX_VALUE);
        text.setAlignment(Pos.CENTER);
        this.getChildren().add(text);

        VBox contenedorAlgoritmo = new VBox();
        contenedorAlgoritmo.setAlignment( Pos.CENTER_RIGHT );
        this.getChildren().add(contenedorAlgoritmo);

        this.setBackground(new Background(new BackgroundFill(Color.LIGHTGREY, CornerRadii.EMPTY, Insets.EMPTY)));

        this.setOnDragOver(dragEvent -> {
            Dragboard db = dragEvent.getDragboard();
            if (db.hasString()) {
                dragEvent.acceptTransferModes(TransferMode.COPY_OR_MOVE);
            }
            dragEvent.consume();
        });

        this.setOnDragDropped(dragEvent -> {
            Dragboard db = dragEvent.getDragboard();
            boolean success = false;
            if (db.hasString()) {
                TitledPane temp_pane = new TitledPane();
                temp_pane.setText(db.getString());
                temp_pane.setAlignment( Pos.CENTER );

                contenedorAlgoritmo.getChildren().add(temp_pane);
                success = true;
            }
            dragEvent.setDropCompleted(success);
            dragEvent.consume();
        });

        this.setPrefSize(670,600);
    }

}
