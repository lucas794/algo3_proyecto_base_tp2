package edu.fiuba.algo3.interfaz;

import edu.fiuba.algo3.ObservadorSectorAlgoritmo;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;

public class ContenedorAlgoritmo extends VBox implements ObservadorSectorAlgoritmo {

    public ContenedorAlgoritmo(int sizeX, int sizeY, Pos posicion) {
        super();
        this.setPrefSize( sizeX, sizeY );
        this.setAlignment( posicion );
    }

    @Override
    public void cambios(VBox nuevoContenedor) {
        // dummy, no necesita ningún tipo de actualización.
    }
}
