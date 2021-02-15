package edu.fiuba.algo3.interfaz;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

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
        Button botonRepeticion2x = new Button("Repetir 2x");
        Button botonRepeticion3x = new Button("Repetir 3x");
        Button botonInvertir = new Button("Invertir comportamiento");
        Button botonGuardarAlgoritmo = new Button("Guardar algoritmo");
        botonGuardarAlgoritmo.setDisable( true );

        VBox contenedorBotonera = new VBox(botonMoverAbajo, botonMoverArriba, botonMoverDerecha, botonMoverIzquierda,
                                           botonBajarLapiz, botonSubirLapiz, botonRepeticion2x, botonRepeticion3x,
                                            botonInvertir, botonGuardarAlgoritmo);

        contenedorBotonera.setAlignment( Pos.CENTER );
        contenedorBotonera.setSpacing( 20 );

        this.getChildren().add(contenedorBotonera);
    }

}
