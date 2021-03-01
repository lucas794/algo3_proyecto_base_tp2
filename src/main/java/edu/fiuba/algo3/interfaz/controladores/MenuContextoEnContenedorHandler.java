package edu.fiuba.algo3.interfaz.controladores;

import edu.fiuba.algo3.interfaz.CreadorDeTipoDeBloque;
import edu.fiuba.algo3.interfaz.EjecucionClickDerecho;
import edu.fiuba.algo3.interfaz.vista.botoneras.BotonAB;
import edu.fiuba.algo3.interfaz.vista.botoneras.ContenedorBotonera;
import edu.fiuba.algo3.interfaz.vista.SectorAlgoritmo;
import javafx.event.EventHandler;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class MenuContextoEnContenedorHandler extends EjecucionClickDerecho implements EventHandler<MouseEvent> {

    ContenedorBotonera botonera;
    SectorAlgoritmo sector;
    VBox contenedorMadre;
    HBox contenedor;
    CreadorDeTipoDeBloque creador;

    //
    BotonAB boton = null;

    public MenuContextoEnContenedorHandler(VBox contenedorMadre, SectorAlgoritmo sector, HBox item, ContenedorBotonera botonera, CreadorDeTipoDeBloque creador) {
        this.contenedorMadre = contenedorMadre;
        this.sector = sector;
        this.contenedor = item;
        this.botonera = botonera;
        this.creador = creador;
    }

    public MenuContextoEnContenedorHandler(BotonAB item, SectorAlgoritmo sector, VBox contenedorAlgoritmo, ContenedorBotonera botonera, CreadorDeTipoDeBloque creador) {
        this.sector = sector;
        this.botonera = botonera;
        this.contenedorMadre = contenedorAlgoritmo;
        this.boton = item;
        this.creador = creador;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        if (mouseEvent.getButton() == MouseButton.SECONDARY) {
            if( this.boton != null )
                resolucionClickDerecho(this.contenedorMadre, this.sector, mouseEvent, this.boton, this.botonera, this.creador);
            else
                resolucionClickDerecho(this.contenedor, this.contenedorMadre, this.sector, mouseEvent, this.botonera, this.creador);
        }
    }

}
