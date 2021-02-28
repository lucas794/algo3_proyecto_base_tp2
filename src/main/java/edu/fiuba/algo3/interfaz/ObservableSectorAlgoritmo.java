package edu.fiuba.algo3.interfaz;

import edu.fiuba.algo3.ObservadorSectorAlgoritmo;
import javafx.scene.layout.VBox;

public interface ObservableSectorAlgoritmo {
    void agregar(ObservadorSectorAlgoritmo observador);
    void notificar(VBox nuevoContenedor);
}