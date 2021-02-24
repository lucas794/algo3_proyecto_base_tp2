package edu.fiuba.algo3;

import edu.fiuba.algo3.interfaz.SectorAlgoritmo;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;


public class HabilidadDrop implements EventHandler<DragEvent> {
    SectorAlgoritmo sector;
    VBox contenedor;

    public HabilidadDrop(SectorAlgoritmo sectorAlgoritmo, VBox contenedorAlgoritmo) {
        this.sector = sectorAlgoritmo;
        this.contenedor = contenedorAlgoritmo;
    }

    @Override
    public void handle(DragEvent dragEvent) {
        Dragboard db = dragEvent.getDragboard();
        boolean success = false;
        if (db.hasString()) {
            String nombre = db.getString().split(",")[0];
            String icono = db.getString().split(",")[1];

            if( nombre.contains("Repetir") || nombre.contains("Invertir") ) {
                VBox contenedorAEjecutar = new VBox();
                contenedorAEjecutar.setPrefSize( 110, 160 );
                contenedorAEjecutar.setAlignment( Pos.TOP_CENTER );
                contenedorAEjecutar.setOnDragOver( new HabilidadAceptarDrag(TransferMode.ANY) );

                contenedorAEjecutar.setOnDragDropped( new HabilidadDrop(this.sector, contenedorAEjecutar ) );
                contenedorAEjecutar.setBorder(new Border(new BorderStroke(Color.ROYALBLUE,
                        BorderStrokeStyle.DOTTED, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
                contenedorAEjecutar.setBackground(new Background(new BackgroundFill(Color.HOTPINK, CornerRadii.EMPTY, Insets.EMPTY)));

                if( nombre.contains("Repetir") ) {
                    ChoiceBox<Integer> choiceBox = new ChoiceBox<>();
                    choiceBox.getItems().add(2);
                    choiceBox.getItems().add(3);
                    choiceBox.getSelectionModel().selectFirst();
                    contenedorAEjecutar.getChildren().add(choiceBox);
                }

                BotonAB boton = new BotonAB( nombre, icono );
                boton.setOnDragDetected( null );
                HBox item = new HBox(boton, contenedorAEjecutar);
                boton.setOnMouseClicked( new MenuContextoEnContenedorHandler(boton, this.sector, item) );
                item.setOnMouseClicked( new MenuContextoEnContenedorHandler(boton, this.sector, item) );
                item.setAlignment(Pos.CENTER);
                this.contenedor.getChildren().add(item);
            }
            else {
                BotonAB item = new BotonAB(nombre, icono);
                item.setOnDragDetected(null); // no se mueve

                item.setOnMouseClicked( new MenuContextoHandler(item, this.sector, this.contenedor) );

                this.contenedor.getChildren().add(item);
            }
            success = true;
        }
        dragEvent.setDropCompleted(success);
        dragEvent.consume();
    }
}
