package edu.fiuba.algo3.interfaz;

import edu.fiuba.algo3.HabilidadAceptarDragHandler;
import edu.fiuba.algo3.HabilidadDropHandler;
import edu.fiuba.algo3.ObservadorSectorAlgoritmo;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.util.ArrayList;

public class SectorAlgoritmo extends VBox implements ObservableSectorAlgoritmo {

    private ArrayList<ObservadorSectorAlgoritmo> observadores;

    public SectorAlgoritmo(ContenedorBotonera contenedorBotonera){
        observadores = new ArrayList<>();
        Label text = new Label("Espacio de Trabajo");
        text.setMaxWidth(Double.MAX_VALUE);
        text.setAlignment(Pos.CENTER);
        text.setTextFill(Color.WHITE);
        text.setStyle("-fx-background-color: rgb(85,40,129);");
        text.setFont(Font.font("Times",20));
        text.setTextFill(Color.WHITE);
        this.getChildren().add(text);

        ContenedorAlgoritmo contenedorAlgoritmo = new ContenedorAlgoritmo(400, 900, Pos.TOP_CENTER);

        this.agregar(contenedorAlgoritmo);
        this.getChildren().add(contenedorAlgoritmo);

        this.setMinWidth(600);
        this.setBackground(new Background(new BackgroundFill(Color.LIGHTGREY, CornerRadii.EMPTY, Insets.EMPTY)));

        contenedorAlgoritmo.setOnDragOver( new HabilidadAceptarDragHandler(TransferMode.ANY) );

        contenedorAlgoritmo.setOnDragDropped( new HabilidadDropHandler(this, contenedorAlgoritmo, contenedorBotonera) );
    }

    @Override
    public void agregar(ObservadorSectorAlgoritmo observador) {
        this.observadores.add(observador);
    }

    @Override
    public void notificar(VBox nuevoContenedor) {
        this.observadores.forEach( obs -> obs.cambios(nuevoContenedor) );
    }
}
