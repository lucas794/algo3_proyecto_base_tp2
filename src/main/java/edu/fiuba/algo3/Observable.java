package edu.fiuba.algo3;

import javafx.scene.layout.VBox;

import java.util.ArrayList;

public abstract class Observable {
    private final ArrayList<Observador> observadores;

    public Observable() {
        observadores = new ArrayList<>();
    }

    public void agregarObservador(Observador observador) { observadores.add(observador); }

    public void notificarObservadores(VBox contenedor)
    {
        observadores.forEach( observador -> observador.cambios(contenedor) );
    }
}
