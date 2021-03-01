package edu.fiuba.algo3.interfaz.vista.botoneras;

import edu.fiuba.algo3.interfaz.ObservadorSectorAlgoritmo;
import edu.fiuba.algo3.interfaz.controladores.ApagarVolumenHandler;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.media.MediaPlayer;

public class BotonVolumen extends Button implements ObservadorSectorAlgoritmo {

    public BotonVolumen(MediaPlayer mediaPlayer) {
        super("Apagar Musica");
        this.setOnMouseClicked( new ApagarVolumenHandler(mediaPlayer, this));
    }

    @Override
    public void cambios(VBox nuevoContenedor) {

    }

}
