package edu.fiuba.algo3;

import edu.fiuba.algo3.interfaz.Tablero;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * JavaFX App
 */

public class App extends Application {

    private static final String TITULO_VENTANA = "TP2 - Algoritmos y Programacion III FIUBA - Grupo IV";
    private static final int RES_X = 1280; // default: 640
    private static final int RES_Y = 1024;  // defauilt: 480

    @Override
    public void start(Stage stage) {

        Tablero tablero = new Tablero();

        var scene = new Scene(tablero, RES_X, RES_Y);

        stage.setTitle( TITULO_VENTANA );
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}