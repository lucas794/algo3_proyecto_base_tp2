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
    CreadorDeTipoDeBloque creador = null;

    public HabilidadDropHandler(SectorAlgoritmo sectorAlgoritmo, VBox contenedorAlgoritmo, ContenedorBotonera contenedorBotonera) {
        this.sector = sectorAlgoritmo;
        this.contenedor = contenedorAlgoritmo;
        this.botonera = contenedorBotonera;
    }

    public HabilidadDropHandler(SectorAlgoritmo sector, VBox contenedorAEjecutar, ContenedorBotonera botonera, CreadorDeTipoDeBloque creadorDeTipoDeBloque) {
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

            if( nombre.contains("Repetir") || nombre.contains("Invertir") )
                if( this.creador != null ) // hace un drop en un contenedor
                    crearContenedor(nombre, icono, this.sector, this.contenedor, this.botonera, this.creador);
                else
                    crearContenedor(nombre, icono, this.sector, this.contenedor, this.botonera);
            else
                if( this.creador != null ) // hace un drop en un contenedor
                    crearBloque(nombre, icono, this.sector, this.contenedor, this.botonera, this.creador);
                else
                    crearBloque(nombre, icono, this.sector, this.contenedor, this.botonera);
            success = true;
        }
        dragEvent.setDropCompleted(success);
        dragEvent.consume();
    }

}
