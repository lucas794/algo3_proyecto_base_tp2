package edu.fiuba.algo3;

import edu.fiuba.algo3.interfaz.ContenedorBotonera;
import edu.fiuba.algo3.interfaz.SectorAlgoritmo;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class EjecucionClickDerecho {

    public void resolucionClickDerecho(HBox contenedor, VBox contenedorMadre, SectorAlgoritmo sector, MouseEvent mouseEvent, ContenedorBotonera botonera) {
        crearMenu(sector, mouseEvent, actionEvent -> {
            contenedor.getChildren().clear();
            contenedorMadre.getChildren().remove(contenedor);
            botonera.notifyObservers(contenedorMadre.getChildren().size());
        });
    }

    public void resolucionClickDerecho(VBox contenedor, SectorAlgoritmo sector, MouseEvent mouseEvent, BotonAB boton, ContenedorBotonera botonera) {
        crearMenu(sector, mouseEvent, actionEvent -> {
            contenedor.getChildren().remove(boton);
            botonera.notifyObservers(contenedor.getChildren().size());
        });
    }

    private void crearMenu(SectorAlgoritmo sector, MouseEvent mouseEvent, EventHandler<ActionEvent> handler) {
        ContextMenu menu = new ContextMenu();
        MenuItem borrar = new MenuItem("BORRAR");
        MenuItem cancelar = new MenuItem("CANCELAR");

        menu.getItems().addAll(borrar, cancelar);
        menu.show(sector, mouseEvent.getScreenX(), mouseEvent.getScreenY());
        cancelar.setOnAction(evento -> menu.hide());
        borrar.setOnAction( handler );
    }
}
