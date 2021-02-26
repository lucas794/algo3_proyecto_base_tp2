package edu.fiuba.algo3;

public interface ObservableContenedor {
    void agregarObservador(ObservadorContenedor observadorBotonGA);
    void notificarObservadores(double x, double y);
}
