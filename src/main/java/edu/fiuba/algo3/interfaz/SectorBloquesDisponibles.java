package edu.fiuba.algo3.interfaz;

import edu.fiuba.algo3.modelo.recursos.DBAlgoritmoPersonalizados;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.util.List;

public class SectorBloquesDisponibles extends VBox {

    public SectorBloquesDisponibles(){
        Label upper = new Label("Bloques Disponibles");
        this.getChildren().add(upper);

        Button botonMoverArriba = new Button("Mover arriba");
        Button botonMoverAbajo = new Button("Mover abajo");
        Button botonMoverIzquierda = new Button("Mover izquierda");
        Button botonMoverDerecha = new Button("Mover derecha");
        Button botonBajarLapiz = new Button("Bajar lapiz");
        Button botonSubirLapiz = new Button("Subir lapiz");

        Button botonRepeticion = new Button("Repetir: ");
        ObservableList<Integer> repeticiones = FXCollections.observableArrayList( 2, 3 );
        ComboBox cantidadRepeticiones = new ComboBox( repeticiones );
        cantidadRepeticiones.getSelectionModel().selectFirst();

        Button botonInvertir = new Button("Invertir comportamiento");
        Button botonGuardarAlgoritmo = new Button("Guardar algoritmo");
        botonGuardarAlgoritmo.setDisable( true );

        HBox contenedorRepeticion = new HBox(botonRepeticion, cantidadRepeticiones);
        contenedorRepeticion.setAlignment( Pos.CENTER );

        Separator separador = new Separator();

        VBox contenedorBotonera = new VBox(botonMoverAbajo, botonMoverArriba, botonMoverDerecha, botonMoverIzquierda,
                botonBajarLapiz, botonSubirLapiz, contenedorRepeticion,
                botonInvertir, botonGuardarAlgoritmo, separador);

        DBAlgoritmoPersonalizados db = new DBAlgoritmoPersonalizados();
        List<List<?>> info_algoritmos_personalizados = db.cargar_todos_algoritmos();
        // esto es un ejemplo, hay que preguntar mas al respecto, alternativa hashmap?
        info_algoritmos_personalizados.forEach( info -> contenedorBotonera.getChildren().add( new Button( (String) info.get(0))));

        contenedorBotonera.setAlignment( Pos.CENTER );
        contenedorBotonera.setSpacing( 10 );

        this.getChildren().add(contenedorBotonera);
        this.setBackground(new Background(new BackgroundFill(Color.LIGHTGREY, CornerRadii.EMPTY, Insets.EMPTY)));

    }

}
