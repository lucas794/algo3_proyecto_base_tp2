package edu.fiuba.algo3;

import edu.fiuba.algo3.interfaz.Tablero;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * JavaFX App
 */

/*
Links interesantes para revisar:

https://github.com/Zabaha/PR3-Movable/blob/10dbd958a172f94a073ee7276fdf5246d5b16153/src/Movable/Movable.java
https://stackoverflow.com/questions/11437097/not-implementing-all-of-the-methods-of-interface-is-it-possible/11437160

public interface MovimientosVerticales {
    void moverDerecha();
    void moverIzquierda();
}

public interface MovimientosHorizontales {
    void moverArriba();
    void moverAbajo();
}

public class Lapiz implements MovimientosHorizontales {
    @Override
    public void moverArriba()
    {
    }

    @Override
    public void moverAbajo()
    {
    }
}

public class Personaje implements MovimientosHorizontales, MovimientosVerticales {
    @Override
    public void moverArriba()
    {
    }

    @Override
    public void moverAbajo()
    {
    }

    @Override
    public void moverDerecha()
    {
    }

    @Override
    public void moverIzquierda()
    {
    }
}

para las clases y movimientos?
 */
public class App extends Application {

    private static final String TITULO_VENTANA = "TP2 - Algoritmos y Programacion III FIUBA - Grupo IV";
    private static final int RES_X = 1280; // default: 640
    private static final int RES_Y = 720;  // defauilt: 480

    @Override
    public void start(Stage stage) {

        Tablero tablero = new Tablero();

        var scene = new Scene(tablero, RES_X, RES_Y);

        stage.setTitle( TITULO_VENTANA );
        stage.setOnCloseRequest(e -> cerrarVentana());
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
        ArrayList<String> test = new ArrayList<>();

        test.add("elemento 1");
        test.add("Elemento 2");
        test.add("Elemento 3");

        System.out.println(test);
    }

    public void cerrarVentana()
    {
        System.out.println("Esto se cerró ché!");
    }

}