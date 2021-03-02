package edu.fiuba.algo3.interfaz.controladores;

import edu.fiuba.algo3.interfaz.vista.SectorDibujo;
import edu.fiuba.algo3.interfaz.vista.botoneras.BotonAB;
import edu.fiuba.algo3.modelo.Personaje;
import edu.fiuba.algo3.modelo.bloques.*;
import edu.fiuba.algo3.modelo.tablero.Dibujo;
import edu.fiuba.algo3.modelo.tablero.movimiento.MovimientoAbajo;
import edu.fiuba.algo3.modelo.tablero.movimiento.MovimientoArriba;
import edu.fiuba.algo3.modelo.tablero.movimiento.MovimientoDerecha;
import edu.fiuba.algo3.modelo.tablero.movimiento.MovimientoIzquierda;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class EjecucionAlgoritmoHandler implements EventHandler<MouseEvent> {

    VBox contenedor;
    Personaje personaje;
    SectorDibujo sectorDibujo;
    Dibujo dibujo;

    public EjecucionAlgoritmoHandler(VBox contenedorAlgoritmo, Personaje personaje, SectorDibujo sectorDibujo, Dibujo dibujo) {
        this.contenedor = contenedorAlgoritmo;
        this.personaje = personaje;
        this.sectorDibujo = sectorDibujo;
        this.dibujo = dibujo;
    }


    private Bloque obtenerBloque(String nombre){
        switch(nombre){
            case "Mover Arriba":
                return new BloqueMovimiento(new MovimientoArriba());
            case "Mover Abajo":
                return new BloqueMovimiento(new MovimientoAbajo());
            case "Mover Izquierda":
                return new BloqueMovimiento(new MovimientoIzquierda());
            case "Mover Derecha":
                return new BloqueMovimiento(new MovimientoDerecha());
            case "Bajar Lapiz":
                return new BloqueBajarLapiz();
            case "Subir Lapiz":
                return new BloqueLevantarLapiz();
        }
        return new BloqueMovimiento(new MovimientoArriba());
    }

    private Bloque obtenerBloquesContenedores(HBox contenedor){

        ObservableList<Node> nodos = contenedor.getChildren();
        VBox nuevoContenedor = new VBox();
        ComboBox comboBox;
        int veces = 2;
        for(Node nodo : nodos){
            if(nodo instanceof VBox){
                nuevoContenedor = (VBox) nodo;
                for(Node nodito : nuevoContenedor.getChildren()){
                    if(nodito instanceof ComboBox){
                        comboBox = (ComboBox) nodito;
                        veces = (int) comboBox.getValue();

                    }
                }
            }
        }

        switch(contenedor.getId()){
            case "Repetir algoritmo":
                return new BloqueRepeticion(veces,obtenerBloquesNodos(nuevoContenedor.getChildren()));
            case "Invertir comportamiento":
                return new BloqueInversion(obtenerBloquesNodos(nuevoContenedor.getChildren()));
        }
        return new BloqueMovimiento(new MovimientoArriba());
    }

    private ArrayList<Bloque> obtenerBloquesNodos(ObservableList<Node> nodos){
        ArrayList<Bloque> bloquesEjecutar = new ArrayList<>();

        for( Node bloque : nodos) {
            if( bloque instanceof BotonAB ) {
                BotonAB boton = (BotonAB) bloque;
                bloquesEjecutar.add(obtenerBloque(boton.getText()));
                System.out.println(boton.getText());
            }else if(bloque instanceof HBox){
                HBox contenedor = (HBox) bloque;
                bloquesEjecutar.add(obtenerBloquesContenedores(contenedor));
            }
        }

        return bloquesEjecutar;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        sectorDibujo.reset();

        ObservableList<Node> botones = this.contenedor.getChildren();

        ArrayList<Bloque> bloquesEjecutar = new ArrayList<>();

        bloquesEjecutar.addAll(obtenerBloquesNodos(botones));

        Timeline timeleine;

        AtomicInteger contador = new AtomicInteger();
        timeleine = new Timeline(new KeyFrame(Duration.seconds(1), (ActionEvent event) -> {
            Bloque temp = bloquesEjecutar.get(contador.getAndIncrement());

            temp.ejecutar(personaje, dibujo);
            sectorDibujo.update();
        }));

        timeleine.setCycleCount(bloquesEjecutar.size());
        timeleine.play();
    }
}
