package edu.fiuba.algo3.interfaz.controladores;

import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.MediaPlayer;

public class ToggleVolumeHandler implements EventHandler<MouseEvent> {

    private MediaPlayer reproductor;
    public ToggleVolumeHandler(MediaPlayer mediaPlayer) {
        reproductor = mediaPlayer;
    }

    @Override
    public void handle(MouseEvent mouseEvent){
        reproductor.setVolume(0.0);
    }
}
