package edu.fiuba.algo3;

import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.media.MediaPlayer;

public class BotonVolumen extends Button implements ObservadorSectorAlgoritmo{

    public BotonVolumen(MediaPlayer mediaPlayer) {
        super("Musica");
        this.setOnMouseClicked( new ToggleVolumeHandler(mediaPlayer));
    }

    @Override
    public void cambios(VBox nuevoContenedor) {

    }

}
