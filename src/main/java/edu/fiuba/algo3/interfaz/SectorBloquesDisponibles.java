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
        this.getChildren().add(upper);

        BotonAB botonMoverArriba = new BotonAB("Mover Arriba");
        BotonAB botonMoverAbajo = new BotonAB( "Mover Abajo");
        BotonAB botonMoverIzquierda = new BotonAB("Mover izquierda");
        BotonAB botonMoverDerecha = new BotonAB("Mover derecha");
        BotonAB botonBajarLapiz = new BotonAB("Bajar lapiz");
        BotonAB botonSubirLapiz = new BotonAB("Subir lapiz");

        BotonAB botonRepeticion2x = new BotonAB("Repetir 2x");
        BotonAB botonRepeticion3x = new BotonAB("Repetir 3x");

        BotonAB botonInvertir = new BotonAB("Invertir comportamiento");
        //Button botonGuardarAlgoritmo = new Button("Guardar algoritmo");
        //botonGuardarAlgoritmo.setDisable( true );

        Separator separador = new Separator();

        VBox contenedorBotonera = new VBox(botonMoverArriba, botonMoverAbajo, botonMoverIzquierda, botonMoverDerecha,
                botonBajarLapiz, botonSubirLapiz, botonRepeticion2x, botonRepeticion3x, botonInvertir);

        DBAlgoritmoPersonalizados db = new DBAlgoritmoPersonalizados();
        List<List<?>> info_algoritmos_personalizados = db.cargar_todos_algoritmos();

        info_algoritmos_personalizados.forEach( info -> contenedorBotonera.getChildren().add( new Button( (String) info.get(0))));

        contenedorBotonera.setAlignment( Pos.CENTER );
        contenedorBotonera.setSpacing( 10 );

        this.getChildren().add(contenedorBotonera);

        this.setBackground(new Background(new BackgroundFill(Color.LIGHTGREY, CornerRadii.EMPTY, Insets.EMPTY)));
    }
}
