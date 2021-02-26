package edu.fiuba.algo3;

import edu.fiuba.algo3.interfaz.ContenedorBotonera;
import edu.fiuba.algo3.interfaz.SectorAlgoritmo;
import javafx.event.EventHandler;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.layout.VBox;

public class HabilidadDropEnContenedorHandler extends CreadorDeTipoDeBloque implements EventHandler<DragEvent> {

    SectorAlgoritmo sector;
    VBox contenedor;
    ContenedorBotonera botonera;
    CreadorDeTipoDeBloque creador;

    public HabilidadDropEnContenedorHandler(SectorAlgoritmo sector, VBox contenedorAEjecutar, ContenedorBotonera botonera, CreadorDeTipoDeBloque creadorDeTipoDeBloque) {
        this.sector = sector;
        this.contenedor = contenedorAEjecutar;
        this.botonera = botonera;
        this.creador = creadorDeTipoDeBloque;
    }

    @Override
    public void handle(DragEvent dragEvent) {
        Dragboard db = dragEvent.getDragboard();
        boolean success = false;
        if (db.hasString()) {
            String nombre = db.getString().split(",")[0];
            String icono = db.getString().split(",")[1];

            if (nombre.contains("Repetir") || nombre.contains("Invertir"))
                crearContenedor(nombre, icono, this.sector, this.contenedor, this.botonera, this.creador);
            else
                crearBloque(nombre, icono, this.sector, this.contenedor, this.botonera, this.creador);

            success = true;
        }
        dragEvent.setDropCompleted(success);
        dragEvent.consume();
    }
}
