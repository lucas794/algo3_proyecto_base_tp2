package edu.fiuba.algo3;

import edu.fiuba.algo3.interfaz.Tablero;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;
import java.time.Duration;

/**
 * JavaFX App
 */

public class App extends Application {

    private static final String TITULO_VENTANA = "TP2 - Algoritmos y Programacion III FIUBA - Grupo IV";
    private static final int RES_X = 1280; // default: 640
    private static final int RES_Y = 720;  // defauilt: 480

    @Override
    public void start(Stage stage) {

        String musicFile = "src/main/java/edu/fiuba/algo3/interfaz/musica/main.mp3";     // For example
        Media musica = new Media(new File(musicFile).toURI().toString());
        MediaPlayer mediaPlayer = new MediaPlayer(musica);
        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayer.play();

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