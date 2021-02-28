package edu.fiuba.algo3;

import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class BotonABGA extends Button implements ObservadorBotonGA, ObservadorSectorAlgoritmo {

    VBox contenendorAlgoritmo = null;

    public BotonABGA(String nombre) {
        super(nombre);
        this.setDisable(true);
        //this.setOnMouseClicked( new BotonABGAClickHandler(this.contenendorAlgoritmo) );
    }

    @Override
    public void cambios(int hijos) {
        this.setDisable(hijos == 0);
    }

    @Override
    public void cambios(VBox nuevoContenedor) {
        // esta acción va a ser llamada cuando tenga un bloque, por lo tanto no hay chances de la variable
        // sea null

        this.contenendorAlgoritmo = nuevoContenedor;
        // re-escribimos el handler con el nuevo info del contenedor :)
        this.setOnMouseClicked( new BotonABGAClickHandler(this.contenendorAlgoritmo) );
    }
}
