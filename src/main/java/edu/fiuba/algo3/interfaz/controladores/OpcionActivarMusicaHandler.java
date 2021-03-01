package edu.fiuba.algo3.interfaz.controladores;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.MenuItem;
import javafx.scene.media.MediaPlayer;

public class OpcionActivarMusicaHandler implements EventHandler<ActionEvent> {
    private MenuItem opcion;
    private MediaPlayer reproductor;
    public OpcionActivarMusicaHandler(MediaPlayer mediaPlayer, MenuItem opcionToggle) {
        reproductor = mediaPlayer;
        opcion = opcionToggle;
    }

    @Override
    public void handle(ActionEvent actionEvent){
        reproductor.setVolume(1.0);
        opcion.setOnAction(new OpcionDesactivarMusicaHandler(reproductor,opcion));
        opcion.setText("Apagar Musica");
    }
}
