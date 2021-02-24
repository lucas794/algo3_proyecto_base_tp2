package edu.fiuba.algo3.interfaz;

import edu.fiuba.algo3.BotonAB;
import edu.fiuba.algo3.BotonABGA;
import edu.fiuba.algo3.Observable;
import javafx.scene.control.Separator;
import javafx.scene.layout.VBox;

public class ContenedorBotonera extends Observable {

    public VBox getContenedorBotonera() {

        BotonAB botonMoverArriba = new BotonAB("Mover Arriba", "arriba.png");
        BotonAB botonMoverAbajo = new BotonAB("Mover Abajo", "abajo.png");
        BotonAB botonMoverIzquierda = new BotonAB("Mover izquierda", "izquierda.png");
        BotonAB botonMoverDerecha = new BotonAB("Mover derecha", "derecha.png");
        BotonAB botonBajarLapiz = new BotonAB("Bajar lapiz", "abajo.png");
        BotonAB botonSubirLapiz = new BotonAB("Subir lapiz", "arriba.png");

        BotonAB botonRepeticion = new BotonAB("Repetir...", "repeticion.png");
        BotonAB botonInvertir = new BotonAB("Invertir comportamiento", "personajeUp.png");

        BotonABGA botonGuardarAlgoritmo = new BotonABGA("Guardar algoritmo");

        Separator separador = new Separator();

        VBox botones = new VBox(botonMoverArriba, botonMoverAbajo, botonMoverIzquierda, botonMoverDerecha,
                botonBajarLapiz, botonSubirLapiz, botonRepeticion, botonInvertir, botonGuardarAlgoritmo,
                separador);

        return botones;
    }
}

