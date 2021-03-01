package edu.fiuba.algo3.interfaz.vista.botoneras;

import edu.fiuba.algo3.interfaz.controladores.HabilidadDragHandler;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;


public class BotonAB extends Button {

    String RUTA_ICONOS = "file:src/main/java/edu/fiuba/algo3/interfaz/imagenes/";

    public BotonAB(String nombre_boton, String icono) {
        super();

        ImageView icon = new ImageView(RUTA_ICONOS + icono);
        this.setMaxSize( 100, 100);
        this.setMinSize( 55, 55);
        this.setTooltip( new Tooltip(nombre_boton) );
        this.setBackground(new Background(new BackgroundFill(Color.DARKCYAN, CornerRadii.EMPTY, Insets.EMPTY)));
        this.setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.DASHED, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        this.setGraphic( icon );

        this.setOnDragDetected( new HabilidadDragHandler(this, nombre_boton, TransferMode.ANY, icono) );
    }
}
