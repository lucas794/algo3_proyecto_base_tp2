package edu.fiuba.algo3.interfaz.controladores;

import edu.fiuba.algo3.interfaz.vista.botoneras.BotonAB;
import edu.fiuba.algo3.modelo.bloques.*;
import edu.fiuba.algo3.modelo.tablero.movimiento.MovimientoAbajo;
import edu.fiuba.algo3.modelo.tablero.movimiento.MovimientoArriba;
import edu.fiuba.algo3.modelo.tablero.movimiento.MovimientoDerecha;
import edu.fiuba.algo3.modelo.tablero.movimiento.MovimientoIzquierda;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;

public class EjecucionAlgoritmoHandler implements EventHandler<MouseEvent> {

    VBox contenedor;

    public EjecucionAlgoritmoHandler(VBox contenedorAlgoritmo) {
        this.contenedor = contenedorAlgoritmo;
    }


    private Bloque obtenerBloque(String nombre){
        switch(nombre){
            case "Movimiento Arriba":
                return new BloqueMovimiento(new MovimientoArriba());
            case "Movimiento Abajo":
                return new BloqueMovimiento(new MovimientoAbajo());
            case "Movimiento Izquierda":
                return new BloqueMovimiento(new MovimientoIzquierda());
            case "Movimiento Derecha":
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

        ObservableList<Node> botones = this.contenedor.getChildren();

        ArrayList<Bloque> bloquesEjecutar = new ArrayList<>();

        bloquesEjecutar.addAll(obtenerBloquesNodos(botones));



    }
}
