package edu.fiuba.algo3;

import edu.fiuba.algo3.interfaz.SectorAlgoritmo;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class EjecucionClickDerecho {

    public void resolucionClickDerecho(HBox contenedor, SectorAlgoritmo sector, MouseEvent mouseEvent) {
        ContextMenu menu = new ContextMenu();
        MenuItem borrar = new MenuItem("BORRAR");
        MenuItem cancelar = new MenuItem("CANCELAR");

        menu.getItems().addAll(borrar, cancelar);
        menu.show(sector, mouseEvent.getScreenX(), mouseEvent.getScreenY());
        borrar.setOnAction(actionEvent -> contenedor.getChildren().clear());

        cancelar.setOnAction(evento -> menu.hide());
    }

    public void resolucionClickDerecho(VBox contenedor, SectorAlgoritmo sector, MouseEvent mouseEvent, BotonAB boton) {
        ContextMenu menu = new ContextMenu();
        MenuItem borrar = new MenuItem("BORRAR");
        MenuItem cancelar = new MenuItem("CANCELAR");

        menu.getItems().addAll(borrar, cancelar);
        menu.show(sector, mouseEvent.getScreenX(), mouseEvent.getScreenY());
        borrar.setOnAction(actionEvent -> contenedor.getChildren().remove(boton));

        cancelar.setOnAction(evento -> menu.hide());
    }
}
