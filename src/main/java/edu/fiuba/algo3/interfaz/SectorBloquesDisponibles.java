package edu.fiuba.algo3.interfaz;

import edu.fiuba.algo3.BotonAB;
import edu.fiuba.algo3.modelo.recursos.DBAlgoritmoPersonalizados;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Separator;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

import java.util.List;

public class SectorBloquesDisponibles extends VBox {

    public SectorBloquesDisponibles(){
        Label upper = new Label("Bloques Disponibles");
        upper.setMaxWidth(Double.MAX_VALUE);
        upper.setAlignment(Pos.CENTER);
        this.getChildren().add(upper);

        BotonAB botonMoverArriba = new BotonAB("Mover Arriba", "arriba.png");
        BotonAB botonMoverAbajo = new BotonAB( "Mover Abajo", "abajo.png");
        BotonAB botonMoverIzquierda = new BotonAB("Mover izquierda", "izquierda.png");
        BotonAB botonMoverDerecha = new BotonAB("Mover derecha", "derecha.png");
        BotonAB botonBajarLapiz = new BotonAB("Bajar lapiz", "abajo.png");
        BotonAB botonSubirLapiz = new BotonAB("Subir lapiz", "arriba.png");

        BotonAB botonRepeticion = new BotonAB("Repetir...", "repeticion.png");
        BotonAB botonInvertir = new BotonAB("Invertir comportamiento", "personajeUp.png");

        Button botonGuardarAlgoritmo = new Button("Guardar algoritmo");
        botonGuardarAlgoritmo.setDisable( true );

        Separator separador = new Separator();

        VBox contenedorBotonera = new VBox(botonMoverArriba, botonMoverAbajo, botonMoverIzquierda, botonMoverDerecha,
                botonBajarLapiz, botonSubirLapiz, botonRepeticion, botonInvertir, botonGuardarAlgoritmo,
                separador);

        DBAlgoritmoPersonalizados db = new DBAlgoritmoPersonalizados();
        List<List<?>> info_algoritmos_personalizados = db.cargar_todos_algoritmos();

        info_algoritmos_personalizados.forEach( info -> contenedorBotonera.getChildren().add( new Button( (String) info.get(0))));

        contenedorBotonera.setAlignment( Pos.TOP_CENTER );
        contenedorBotonera.setSpacing( 2 );

        this.getChildren().add(contenedorBotonera);

        this.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
    }
}
