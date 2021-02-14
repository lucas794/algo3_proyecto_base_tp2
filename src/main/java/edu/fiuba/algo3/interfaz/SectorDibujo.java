package edu.fiuba.algo3.interfaz;

import javafx.scene.image.Image;
import javafx.scene.layout.*;

public class SectorDibujo extends GridPane{

    public SectorDibujo() {

        this.setPrefSize(400,500);
        Image dibujoImagen = new Image("file:src/main/java/edu/fiuba/algo3/interfaz/imagenes/fondoSectorDibujo.jpg");
        BackgroundImage fondoImagen = new BackgroundImage(dibujoImagen, BackgroundRepeat.REPEAT,BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        Background fondo = new Background(fondoImagen);

        this.setBackground(fondo);
    }
}
