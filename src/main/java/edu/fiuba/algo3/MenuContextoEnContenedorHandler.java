package edu.fiuba.algo3;

import edu.fiuba.algo3.interfaz.SectorAlgoritmo;
import javafx.event.EventHandler;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

public class MenuContextoEnContenedorHandler implements EventHandler<MouseEvent> {
    BotonAB boton;
    SectorAlgoritmo sector;
    HBox contenedor;
    public MenuContextoEnContenedorHandler(BotonAB boton, SectorAlgoritmo sector, HBox item) {
        this.boton = boton;
        this.sector = sector;
        this.contenedor = item;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        if (mouseEvent.getButton() == MouseButton.SECONDARY) {
            ContextMenu menu = new ContextMenu();
            MenuItem borrar = new MenuItem("BORRAR");
            MenuItem cancelar = new MenuItem("CANCELAR");
            menu.getItems().addAll(borrar, cancelar);

            menu.show(this.sector, mouseEvent.getScreenX(), mouseEvent.getScreenY());

            borrar.setOnAction(actionEvent -> this.contenedor.getChildren().clear());

            cancelar.setOnAction(evento -> menu.hide());
        }
    }
}
