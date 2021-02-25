package edu.fiuba.algo3;

public interface Observable {
    void addObserver(Observer observer);
    void notifyObservers(int hijos);
}
