package edu.fiuba.algo3;

import edu.fiuba.algo3.interfaz.SectorAlgoritmo;
import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

public class MenuContextoHandler extends EjecucionClickDerecho implements EventHandler<MouseEvent> {
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
            resolucionClickDerecho(this.contenedor, this.sector, mouseEvent, this.boton);
        }
    }
}
