package edu.fiuba.algo3;

import edu.fiuba.algo3.interfaz.ContenedorBotonera;
import edu.fiuba.algo3.interfaz.SectorAlgoritmo;
import javafx.event.EventHandler;
import javafx.scene.input.DragEvent;
import javafx.scene.input.Dragboard;
import javafx.scene.layout.*;

public class HabilidadDropHandler extends CreadorDeTipoDeBloque implements EventHandler<DragEvent> {
    SectorAlgoritmo sector;
    VBox contenedor;
    ContenedorBotonera botonera;

    public HabilidadDropHandler(SectorAlgoritmo sectorAlgoritmo, VBox contenedorAlgoritmo, ContenedorBotonera contenedorBotonera) {
        this.sector = sectorAlgoritmo;
        this.contenedor = contenedorAlgoritmo;
        this.botonera = contenedorBotonera;
    }


    @Override
    public void handle(DragEvent dragEvent) {
        Dragboard db = dragEvent.getDragboard();
        boolean success = false;
        if (db.hasString()) {
            String nombre = db.getString().split(",")[0];
            String icono = db.getString().split(",")[1];

            if( nombre.contains("Repetir") || nombre.contains("Invertir") )
                crearContenedor(nombre, icono, this.sector, this.contenedor, this.botonera);
            else crearBloque(nombre, icono, this.sector, this.contenedor, this.botonera);
            success = true;
        }
        dragEvent.setDropCompleted(success);
        dragEvent.consume();
    }

}
