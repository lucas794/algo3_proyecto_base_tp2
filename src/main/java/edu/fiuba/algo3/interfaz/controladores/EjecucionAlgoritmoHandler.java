package edu.fiuba.algo3.interfaz.controladores;

import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

public class EjecucionAlgoritmoHandler implements EventHandler<MouseEvent> {

    VBox contenedor;

    public EjecucionAlgoritmoHandler(VBox contenedorAlgoritmo) {
        this.contenedor = contenedorAlgoritmo;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {

        ObservableList<Node> test = this.contenedor.getChildren(); //
        for( Node bloque : test ) {
        }
    }
}
