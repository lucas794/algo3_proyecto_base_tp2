package edu.fiuba.algo3;

import edu.fiuba.algo3.interfaz.ContenedorBotonera;
import edu.fiuba.algo3.interfaz.SectorAlgoritmo;
import javafx.scene.layout.*;

import java.util.ArrayList;

public class CreadorDeTipoDeBloque implements ObservableContenedor {

    private Contenedor bloqueEnSectorAlgoritmo;

    public void crearBloque(String nombre, String icono, SectorAlgoritmo sector, VBox contenedor, ContenedorBotonera botonera) {
        BotonAB item = new BotonAB(nombre, icono);
        item.setOnDragDetected(null); // no se mueve

        item.setOnMouseClicked( new MenuContextoHandler(item, sector, contenedor, botonera) );

        contenedor.getChildren().add(item);
        botonera.notificarObservadores(contenedor.getChildren().size());
    }

    // crea un bloque adentro de un contenedor de algoritmo (repeticion/inversion)
    public void crearBloque(String nombre, String icono, SectorAlgoritmo sector, VBox contenedor, ContenedorBotonera botonera, CreadorDeTipoDeBloque creador) {
        BotonAB item = new BotonAB(nombre, icono);
        item.setOnDragDetected(null); // no se mueve
        item.setOnMouseClicked( new MenuContextoEnContenedorHandler(item, sector, contenedor, botonera, creador) );

        contenedor.getChildren().add(item);
        botonera.notificarObservadores(contenedor.getChildren().size());

        creador.notificarObservador(0, 45, 0); // no es un contenedor.
    }
    // contenedor adentro de contenedor
    public void crearContenedor(String nombre, String icono, SectorAlgoritmo sector, VBox contenedor, ContenedorBotonera botonera, CreadorDeTipoDeBloque creador) {
        Contenedor contenedorAEjecutar = new Contenedor(creador, nombre, contenedor, botonera, sector, icono);
        this.agregarObservador(contenedorAEjecutar);
        this.notificarObservador(50, 45 , 0); // agrega un contenedor a uno ya existente.
        creador.notificarObservador( 50, 45, 1); // llamamos al padre para que crezca también
    }

    // crea un contenedor simple
    public void crearContenedor(String nombre, String icono, SectorAlgoritmo sector, VBox contenedor, ContenedorBotonera botonera)
    {
        Contenedor contenedorAEjecutar = new Contenedor(this, nombre, contenedor, botonera, sector, icono);
        this.agregarObservador(contenedorAEjecutar);
        this.notificarObservador( 50, 45, 0);
    }

    @Override
    public void agregarObservador(Contenedor obs) {
        this.bloqueEnSectorAlgoritmo = obs;
    }

    @Override
    public void notificarObservador(double x, double y, int hijos) {
        this.bloqueEnSectorAlgoritmo.cambios(x, y, hijos);
    }

}
