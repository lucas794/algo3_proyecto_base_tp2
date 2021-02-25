package edu.fiuba.algo3;

import edu.fiuba.algo3.interfaz.ContenedorBotonera;
import edu.fiuba.algo3.interfaz.SectorAlgoritmo;
import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

public class MenuContextoHandler extends EjecucionClickDerecho implements EventHandler<MouseEvent> {
    ContenedorBotonera botonera;
    SectorAlgoritmo sector;
    VBox contenedor;
    BotonAB boton;

    public MenuContextoHandler(BotonAB item, SectorAlgoritmo sector, VBox contenedor, ContenedorBotonera botonera) {
        this.sector = sector;
        this.contenedor = contenedor;
        this.boton = item;
        this.botonera = botonera;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        if (mouseEvent.getButton() == MouseButton.SECONDARY) {
            resolucionClickDerecho(this.contenedor, this.sector, mouseEvent, this.boton, this.botonera);
        }
    }
}
