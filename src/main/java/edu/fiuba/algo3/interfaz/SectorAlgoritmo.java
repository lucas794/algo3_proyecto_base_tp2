package edu.fiuba.algo3.interfaz;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class SectorAlgoritmo extends VBox {

    public SectorAlgoritmo(){
        Label text = new Label("Espacio de Trabajo");
        text.setMaxWidth(Double.MAX_VALUE);
        text.setAlignment(Pos.CENTER);
        this.getChildren().add(text);

        VBox contenedorAlgoritmo = new VBox();
        contenedorAlgoritmo.setPrefSize(400, 600);
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

        Button guardarAlgoritmo = new Button("Guardar Algoritmo");
        guardarAlgoritmo.setPrefSize(300, 80);
        Label texto = new Label("Borrar algoritmo");
        Rectangle rectanguloBorrarAlgoritmo = new Rectangle(50, 20, 300, 80);
        rectanguloBorrarAlgoritmo.setFill( Color.TRANSPARENT );
        rectanguloBorrarAlgoritmo.setStroke( Color.BLACK );
        rectanguloBorrarAlgoritmo.getStrokeDashArray().addAll(10d, 8d);
        StackPane stack = new StackPane();
        stack.getChildren().addAll(rectanguloBorrarAlgoritmo, texto);
        this.getChildren().add( new HBox( guardarAlgoritmo, stack ) );
        //this.setPrefSize(670,600);
    }

}
