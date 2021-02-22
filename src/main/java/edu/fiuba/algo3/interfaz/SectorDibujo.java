package edu.fiuba.algo3.interfaz;

import edu.fiuba.algo3.interfaz.vista.VistaPersonaje;
import edu.fiuba.algo3.modelo.Personaje;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;

public class SectorDibujo extends BorderPane{

    private ImageView imagenPersonaje;
    private VistaPersonaje vistaPersonaje;
    //private Personaje personaje;

    public SectorDibujo() {
        this.setPrefSize(400,500);
        clean();
        imagenPersonaje = new ImageView( "file:src/main/java/edu/fiuba/algo3/interfaz/imagenes/personajeRight.png");
        vistaPersonaje = new VistaPersonaje(imagenPersonaje, this);

    }

    public void clean(){
        BackgroundImage fondoImagen = new BackgroundImage(new Image("file:src/main/java/edu/fiuba/algo3/interfaz/imagenes/fondoSectorDibujo.jpg"),
                BackgroundRepeat.REPEAT,BackgroundRepeat.REPEAT, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        Background fondo = new Background(fondoImagen);

        this.setBackground(fondo);
    }

}
