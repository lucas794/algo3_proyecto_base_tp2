package edu.fiuba.algo3;

import edu.fiuba.algo3.interfaz.ContenedorBotonera;
import edu.fiuba.algo3.interfaz.SectorAlgoritmo;
import javafx.scene.layout.*;

import java.util.ArrayList;

public class CreadorDeTipoDeBloque implements ObservableContenedor {

    private ArrayList<ObservadorContenedor> observadores;

    public CreadorDeTipoDeBloque() {
        this.observadores = new ArrayList<>();
    }

    public void crearBloque(String nombre, String icono, SectorAlgoritmo sector, VBox contenedor, ContenedorBotonera botonera) {
        //this.crearBloquePrivado(nombre, icono, sector, contenedor, botonera);
        BotonAB item = new BotonAB(nombre, icono);
        item.setOnDragDetected(null); // no se mueve

        item.setOnMouseClicked( new MenuContextoHandler(item, sector, contenedor, botonera) );

        contenedor.getChildren().add(item);
        botonera.notificarObservadores(contenedor.getChildren().size());
    }

    public void crearBloque(String nombre, String icono, SectorAlgoritmo sector, VBox contenedor, ContenedorBotonera botonera, CreadorDeTipoDeBloque creador) {
        BotonAB item = new BotonAB(nombre, icono);
        item.setOnDragDetected(null); // no se mueve

        item.setOnMouseClicked( new MenuContextoAdentroContenedorHandler(item, sector, contenedor, botonera, creador) );

        contenedor.getChildren().add(item);
        botonera.notificarObservadores(contenedor.getChildren().size());
        creador.notificarObservadores(0, 65);
    }

    public void crearContenedor(String nombre, String icono, SectorAlgoritmo sector, VBox contenedor, ContenedorBotonera botonera, CreadorDeTipoDeBloque creador) {
        Contenedor contenedorAEjecutar = new Contenedor(creador, nombre, contenedor, botonera, sector, icono);
        creador.agregarObservador(contenedorAEjecutar);
        creador.notificarObservadores(75, 10); // agrega un contenedor a uno ya existente.
    }

    public void crearContenedor(String nombre, String icono, SectorAlgoritmo sector, VBox contenedor, ContenedorBotonera botonera)
    {
        Contenedor contenedorAEjecutar = new Contenedor(this, nombre, contenedor, botonera, sector, icono);
        this.agregarObservador(contenedorAEjecutar);
    }

    @Override
    public void agregarObservador(ObservadorContenedor obs) {
        this.observadores.add(obs);
    }

    @Override
    public void notificarObservadores(double x, double y) {
        this.observadores.forEach( obs -> obs.cambios(x,y) );
    }
}
