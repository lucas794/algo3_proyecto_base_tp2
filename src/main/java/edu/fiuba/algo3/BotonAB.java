package edu.fiuba.algo3;

import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.TransferMode;

// esta clase muy posiblemente tenga que ir en otra carpeta, pero lo pongo acá inicialmente.

public class BotonAB extends Button {

    public BotonAB(String nombre_boton) {
        super(nombre_boton);
        this.setOnDragDetected(mouseEvent -> {
            Dragboard db = startDragAndDrop(TransferMode.COPY_OR_MOVE);
            ClipboardContent contenido = new ClipboardContent();
            contenido.putString(nombre_boton);
            db.setContent(contenido);
            mouseEvent.consume();
        });
    }
}
