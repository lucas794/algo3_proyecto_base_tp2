package edu.fiuba.algo3.interfaz;

import edu.fiuba.algo3.ObservadorBotonGA;
import edu.fiuba.algo3.ObservadorSectorAlgoritmo;
import javafx.scene.layout.VBox;

public interface ObservableSectorAlgoritmo {
    void agregarObservador(ObservadorSectorAlgoritmo observador);
    void notificarObservadores(VBox nuevoContenedor);
}