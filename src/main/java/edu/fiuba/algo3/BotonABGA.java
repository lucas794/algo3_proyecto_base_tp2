package edu.fiuba.algo3;

import edu.fiuba.algo3.interfaz.ContenedorBotonera;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class BotonABGA extends Button implements Observer {

    VBox botonera;

    public BotonABGA(String nombre, ContenedorBotonera contenedorBotonera, VBox botones) {
        super(nombre);
        this.setDisable(true);
        this.botonera = botones;
        contenedorBotonera.addObserver(this);
    }

    @Override
    public void change(int hijos) {
        this.setDisable(hijos == 0);
    }
}
