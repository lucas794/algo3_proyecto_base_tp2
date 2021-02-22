package edu.fiuba.algo3.interfaz.vista;

import edu.fiuba.algo3.interfaz.SectorDibujo;
import edu.fiuba.algo3.modelo.Personaje;
import javafx.scene.image.ImageView;

public class VistaPersonaje {

    ImageView imagenPersonaje;
    //Personaje personaje;

    public VistaPersonaje(ImageView imagenPersonaje, SectorDibujo sectorDibujo){

        this.imagenPersonaje = imagenPersonaje;
        imagenPersonaje.setX(180);
        imagenPersonaje.setY(180);
        imagenPersonaje.setFitHeight(35);
        imagenPersonaje.setFitWidth(30);
        sectorDibujo.getChildren().add(imagenPersonaje);
    }
}
