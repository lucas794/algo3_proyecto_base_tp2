package edu.fiuba.algo3.interfaz.vista.botoneras;

import edu.fiuba.algo3.interfaz.controladores.EjecucionAlgoritmoHandler;
import edu.fiuba.algo3.interfaz.ObservadorSectorAlgoritmo;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class BotonEjecutar extends Button implements ObservadorSectorAlgoritmo {

    VBox contenedorAlgoritmo;

    public BotonEjecutar() {
        super("Ejecutar algoritmo!");
        this.setDisable(true);
    }

    @Override
    public void cambios(VBox nuevoContenedor) {
        this.contenedorAlgoritmo = nuevoContenedor;
        this.setDisable( this.contenedorAlgoritmo.getChildren().size() == 0 );
        this.setOnMouseClicked( new EjecucionAlgoritmoHandler( this.contenedorAlgoritmo  ) );
    }
}
