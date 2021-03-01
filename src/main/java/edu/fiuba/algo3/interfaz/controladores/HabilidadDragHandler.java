package edu.fiuba.algo3.interfaz.controladores;

import edu.fiuba.algo3.interfaz.vista.botoneras.BotonAB;
import javafx.event.EventHandler;
import javafx.scene.input.*;

public class HabilidadDragHandler implements EventHandler<MouseEvent> {

    String nombre_boton;
    BotonAB boton;
    TransferMode[] transferencia;
    String icono;

    public HabilidadDragHandler(BotonAB referencia, String nombre_boton, TransferMode[] copyOrMove, String icono) {
        this.boton = referencia;
        this.nombre_boton = nombre_boton;
        this.transferencia = copyOrMove;
        this.icono = icono;
    }

    @Override
    public void handle(MouseEvent event) {
        Dragboard db = this.boton.startDragAndDrop(this.transferencia);
        ClipboardContent contenido = new ClipboardContent();
        contenido.putString(this.nombre_boton + "," + this.icono);
        db.setContent(contenido);
        event.consume();
    }
}
