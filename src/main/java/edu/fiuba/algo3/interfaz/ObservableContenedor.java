package edu.fiuba.algo3.interfaz;

public interface ObservableContenedor {
    void agregarObservador(Contenedor observador);
    void notificarObservador(double x, double y, int hijos );
}
