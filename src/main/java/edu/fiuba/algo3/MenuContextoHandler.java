package edu.fiuba.algo3;

import edu.fiuba.algo3.interfaz.SectorAlgoritmo;
import javafx.event.EventHandler;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

public class MenuContextoHandler implements EventHandler<MouseEvent> {
    SectorAlgoritmo sector;
    VBox contenedor;
    BotonAB boton;

    public MenuContextoHandler(BotonAB boton, SectorAlgoritmo sector, VBox contenedor) {
        this.sector = sector;
        this.contenedor = contenedor;
        this.boton = boton;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        if (mouseEvent.getButton() == MouseButton.SECONDARY) {
            ContextMenu menu = new ContextMenu();
            MenuItem borrar = new MenuItem("BORRAR");
            MenuItem cancelar = new MenuItem("CANCELAR");
            menu.getItems().addAll(borrar, cancelar);

            menu.show(this.sector, mouseEvent.getScreenX(), mouseEvent.getScreenY());

            borrar.setOnAction(actionEvent -> this.contenedor.getChildren().remove(this.boton));

            cancelar.setOnAction(evento -> menu.hide());
        }
    }
}
