package edu.fiuba.algo3;

import edu.fiuba.algo3.interfaz.ContenedorBotonera;
import edu.fiuba.algo3.interfaz.SectorAlgoritmo;
import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class MenuContextoEnContenedorHandler extends EjecucionClickDerecho implements EventHandler<MouseEvent> {

    ContenedorBotonera botonera;
    VBox contenedorMadre;
    SectorAlgoritmo sector;
    HBox contenedor;
    CreadorDeTipoDeBloque creador;

    public MenuContextoEnContenedorHandler(VBox contenedorMadre, SectorAlgoritmo sector, HBox item, ContenedorBotonera botonera, CreadorDeTipoDeBloque creador) {
        this.contenedorMadre = contenedorMadre;
        this.sector = sector;
        this.contenedor = item;
        this.botonera = botonera;
        this.creador = creador;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        if (mouseEvent.getButton() == MouseButton.SECONDARY) {
            resolucionClickDerecho(this.contenedor, this.contenedorMadre, this.sector, mouseEvent, this.botonera, this.creador);
        }
    }

}
