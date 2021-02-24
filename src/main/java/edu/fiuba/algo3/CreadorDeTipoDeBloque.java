package edu.fiuba.algo3;

import edu.fiuba.algo3.interfaz.SectorAlgoritmo;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ComboBox;
import javafx.scene.input.TransferMode;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class CreadorDeTipoDeBloque extends Observable {

    public void crearBloque(String nombre, String icono, SectorAlgoritmo sector, VBox contenedor) {
        BotonAB item = new BotonAB(nombre, icono);
        item.setOnDragDetected(null); // no se mueve

        item.setOnMouseClicked( new MenuContextoHandler(item, sector, contenedor) );

        contenedor.getChildren().add(item);
        notificarObservadores(contenedor);
    }

    public void crearContenedor(String nombre, String icono, SectorAlgoritmo sector, VBox contenedor)
    {
        VBox contenedorAEjecutar = new VBox();
        contenedorAEjecutar.setPrefSize( 110, 160 );
        contenedorAEjecutar.setAlignment( Pos.TOP_CENTER );
        contenedorAEjecutar.setOnDragOver( new HabilidadAceptarDragHandler(TransferMode.ANY) );

        contenedorAEjecutar.setOnDragDropped( new HabilidadDropHandler(sector, contenedorAEjecutar ) );
        contenedorAEjecutar.setBorder(new Border(new BorderStroke(Color.ROYALBLUE,
                BorderStrokeStyle.DOTTED, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        contenedorAEjecutar.setBackground(new Background(new BackgroundFill(Color.HOTPINK, CornerRadii.EMPTY, Insets.EMPTY)));

        if( nombre.contains("Repetir") ) {
            ComboBox<Integer> comboBox = new ComboBox<>();
            comboBox.getItems().add(2);
            comboBox.getItems().add(3);
            comboBox.getSelectionModel().selectFirst();
            comboBox.setBackground(new Background(new BackgroundFill(Color.LIGHTPINK, CornerRadii.EMPTY, Insets.EMPTY)));
            comboBox.setBorder(new Border(new BorderStroke(Color.BLACK,
                    BorderStrokeStyle.DASHED, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
            contenedorAEjecutar.getChildren().add(comboBox);
        }

        BotonAB boton = new BotonAB( nombre, icono );
        boton.setOnDragDetected( null );
        HBox item = new HBox(boton, contenedorAEjecutar);
        boton.setOnMouseClicked( new MenuContextoEnContenedorHandler(boton, sector, item) );
        item.setOnMouseClicked( new MenuContextoEnContenedorHandler(boton, sector, item) );
        item.setAlignment(Pos.CENTER);
        contenedor.getChildren().add(item);

        notificarObservadores(contenedor);
    }
}
