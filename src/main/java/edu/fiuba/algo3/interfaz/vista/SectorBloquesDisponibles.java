package edu.fiuba.algo3.interfaz.vista;

import edu.fiuba.algo3.interfaz.ObservableSectorAlgoritmo;
import edu.fiuba.algo3.interfaz.ObservadorSectorAlgoritmo;
import edu.fiuba.algo3.interfaz.vista.botoneras.BotonAB;
import edu.fiuba.algo3.interfaz.vista.botoneras.BotonABGA;
import edu.fiuba.algo3.modelo.Personaje;
import edu.fiuba.algo3.modelo.recursos.DBAlgoritmoPersonalizados;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.util.ArrayList;
import java.util.List;


public class SectorBloquesDisponibles extends VBox implements ObservableSectorAlgoritmo {

    private final ArrayList<ObservadorSectorAlgoritmo> observadorSA;
    BotonABGA botonGuardarAlgoritmo;
    SectorDibujo sectorDibujo;

    public SectorBloquesDisponibles(SectorDibujo sectorDibujo, Personaje personaje){

        this.sectorDibujo = sectorDibujo;

        Label upper = new Label("Bloques Disponibles");
        upper.setMaxWidth(Double.MAX_VALUE);
        upper.setAlignment(Pos.CENTER);
        upper.setTextFill(Color.WHITE);
        upper.setStyle("-fx-background-color: rgb(85,40,129);");
        upper.setFont(Font.font("Times",20));
        this.getChildren().add(upper);

        this.observadorSA = new ArrayList<>();

        BotonAB botonMoverArriba = new BotonAB("Mover Arriba", "arriba.png");
        BotonAB botonMoverAbajo = new BotonAB("Mover Abajo", "abajo.png");
        BotonAB botonMoverIzquierda = new BotonAB("Mover Izquierda", "izquierda.png");
        BotonAB botonMoverDerecha = new BotonAB("Mover Derecha", "derecha.png");
        BotonAB botonBajarLapiz = new BotonAB("Bajar Lapiz", "abajo.png");
        BotonAB botonSubirLapiz = new BotonAB("Subir Lapiz", "arriba.png");
        BotonAB botonRepeticion = new BotonAB("Repetir algoritmo", "repeticion.png");
        BotonAB botonInvertir = new BotonAB("Invertir comportamiento", "personajeUp.png");

        this.getChildren().addAll(botonMoverArriba, botonMoverAbajo, botonMoverIzquierda, botonMoverDerecha,
                botonBajarLapiz, botonSubirLapiz, botonRepeticion, botonInvertir);

        botonGuardarAlgoritmo = new BotonABGA("Guardar algoritmo", this );

        this.agregarObservador(botonGuardarAlgoritmo);

        Separator separador = new Separator();

        this.getChildren().addAll(botonGuardarAlgoritmo, separador);

        this.setBackground(new Background(new BackgroundFill(Color.LIGHTGREY, CornerRadii.EMPTY, Insets.EMPTY)));

        DBAlgoritmoPersonalizados db = new DBAlgoritmoPersonalizados();
        List<List<?>> info_algoritmos_personalizados = db.cargar_todos_algoritmos();

        info_algoritmos_personalizados.forEach( info -> this.getChildren().add( new Button( (String) info.get(0))));

        this.setAlignment( Pos.TOP_CENTER );
        this.setSpacing( 2 );

        this.setMaxWidth(300);

        this.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
    }

    @Override
    public void agregarObservador(ObservadorSectorAlgoritmo observador) {
        this.observadorSA.add(observador);
    }

    @Override
    public void notificarObservador(VBox nuevoContenedor) {
        this.observadorSA.forEach( obs -> obs.cambios(nuevoContenedor) );
        this.sectorDibujo.notificarObservador(nuevoContenedor);
    }
}
