package edu.fiuba.algo3;

import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.input.ClipboardContent;
import javafx.scene.input.Dragboard;
import javafx.scene.input.TransferMode;

public class HabilidadDrag implements EventHandler {

    String nombre_boton;
    BotonAB boton;
    TransferMode[] transferencia;

    public HabilidadDrag(BotonAB referencia, String nombre_boton, TransferMode[] copyOrMove) {
        this.boton = referencia;
        this.nombre_boton = nombre_boton;
        this.transferencia = copyOrMove;
    }

    @Override
    public void handle(Event event) {
        Dragboard db = this.boton.startDragAndDrop(this.transferencia);
        ClipboardContent contenido = new ClipboardContent();
        contenido.putString(this.nombre_boton);
        db.setContent(contenido);
        event.consume();
    }
}
