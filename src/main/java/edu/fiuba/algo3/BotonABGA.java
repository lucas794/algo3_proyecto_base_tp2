package edu.fiuba.algo3;

import javafx.scene.control.Button;

public class BotonABGA extends Button implements Observer {

    public BotonABGA(String nombre) {
        super(nombre);
        this.setDisable(true);
    }

    @Override
    public void change(int hijos) {
        this.setDisable(hijos == 0);
    }
}
