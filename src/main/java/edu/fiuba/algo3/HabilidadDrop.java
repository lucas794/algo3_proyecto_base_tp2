package edu.fiuba.algo3;

import edu.fiuba.algo3.interfaz.SectorAlgoritmo;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TitledPane;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.VBox;

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
            TitledPane temp_pane = new TitledPane();
            temp_pane.setText(db.getString());
            temp_pane.setAlignment( Pos.CENTER );

            temp_pane.setOnMouseClicked(mouseEvent -> {
                if( mouseEvent.isSecondaryButtonDown() || mouseEvent.getButton() == MouseButton.SECONDARY)
                {
                    ContextMenu menu = new ContextMenu();
                    MenuItem borrar = new MenuItem("BORRAR");
                    MenuItem cancelar = new MenuItem("CANCELAR");
                    menu.getItems().addAll(borrar, cancelar);

                    menu.show(this.sector, mouseEvent.getScreenX(), mouseEvent.getScreenY());

                    borrar.setOnAction(actionEvent -> this.contenedor.getChildren().remove(temp_pane));

                    cancelar.setOnAction( evento -> menu.hide());
                }
            });

            this.contenedor.getChildren().add(temp_pane);
            success = true;
        }
        dragEvent.setDropCompleted(success);
        dragEvent.consume();
    }
}
