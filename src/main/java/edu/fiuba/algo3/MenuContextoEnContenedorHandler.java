package edu.fiuba.algo3;

import edu.fiuba.algo3.interfaz.SectorAlgoritmo;
import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

public class MenuContextoEnContenedorHandler extends EjecucionClickDerecho implements EventHandler<MouseEvent> {
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
            resolucionClickDerecho(this.contenedor, this.sector, mouseEvent);
        }
    }

}
