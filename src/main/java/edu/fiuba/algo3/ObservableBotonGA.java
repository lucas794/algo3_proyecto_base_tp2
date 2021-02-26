package edu.fiuba.algo3;

public interface ObservableBotonGA {
    void agregarObservador(ObservadorBotonGA observadorBotonGA);
    void notificarObservadores(int hijos);
}
