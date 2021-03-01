package edu.fiuba.algo3.interfaz.controladores;

import edu.fiuba.algo3.interfaz.vista.botoneras.BotonVolumen;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.MediaPlayer;

public class ApagarVolumenHandler implements EventHandler<MouseEvent> {
    private BotonVolumen boton;
    private MediaPlayer reproductor;
    public ApagarVolumenHandler(MediaPlayer mediaPlayer, BotonVolumen botonVolumen) {
        reproductor = mediaPlayer;
        boton = botonVolumen;
    }

    @Override
    public void handle(MouseEvent mouseEvent){
        reproductor.setVolume(0.0);
        boton.setOnMouseClicked(new PrenderVolumenHandler(reproductor,boton));
        boton.setText("Prender Musica");
    }
}
