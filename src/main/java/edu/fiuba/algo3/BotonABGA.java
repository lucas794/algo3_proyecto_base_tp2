package edu.fiuba.algo3;

import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class BotonABGA extends Button implements ObservadorSectorAlgoritmo {

    VBox contenendorAlgoritmo = null;
    VBox botoneraSectorBloquesDisponibles;

    public BotonABGA(String nombre, VBox botones) {
        super(nombre);
        this.setDisable(true);
        this.botoneraSectorBloquesDisponibles = botones;
    }

    @Override
    public void cambios(VBox nuevoContenedor) {
        // esta acción va a ser llamada cuando tenga un bloque, por lo tanto no hay chances de la variable
        // sea null

        this.contenendorAlgoritmo = nuevoContenedor;

        this.setDisable( this.contenendorAlgoritmo.getChildren().size() == 0 ); // no tiene hijos...

        // re-escribimos el handler con el nuevo info del contenedor :)
        this.setOnMouseClicked( new BotonABGAClickHandler(this.contenendorAlgoritmo, this.botoneraSectorBloquesDisponibles) );
    }
}
