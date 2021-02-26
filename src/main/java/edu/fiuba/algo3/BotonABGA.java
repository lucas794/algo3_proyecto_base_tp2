package edu.fiuba.algo3;

import javafx.scene.control.Button;

public class BotonABGA extends Button implements ObservadorBotonGA {

    public BotonABGA(String nombre) {
        super(nombre);
        this.setDisable(true);
    }

    @Override
    public void cambios(int hijos) {
        this.setDisable(hijos == 0);
    }
}
