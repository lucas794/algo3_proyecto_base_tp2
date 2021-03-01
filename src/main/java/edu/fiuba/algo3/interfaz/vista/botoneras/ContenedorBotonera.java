package edu.fiuba.algo3.interfaz.vista.botoneras;

import edu.fiuba.algo3.interfaz.ObservableSectorAlgoritmo;
import edu.fiuba.algo3.interfaz.ObservadorSectorAlgoritmo;
import edu.fiuba.algo3.interfaz.vista.SectorDibujo;
import edu.fiuba.algo3.interfaz.controladores.MovimientoEventHandler;
import edu.fiuba.algo3.modelo.Personaje;
import edu.fiuba.algo3.modelo.bloques.BloqueMovimiento;
import edu.fiuba.algo3.modelo.tablero.movimiento.MovimientoAbajo;
import edu.fiuba.algo3.modelo.tablero.movimiento.MovimientoArriba;
import edu.fiuba.algo3.modelo.tablero.movimiento.MovimientoDerecha;
import edu.fiuba.algo3.modelo.tablero.movimiento.MovimientoIzquierda;
import javafx.geometry.Insets;
import javafx.scene.control.Separator;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;

import java.util.ArrayList;

public class ContenedorBotonera implements /*ObservableBotonGA, */ObservableSectorAlgoritmo {

    private final VBox botones;
    private Personaje personaje;
    private SectorDibujo sectorDibujo;

    private ArrayList<ObservadorSectorAlgoritmo> observadorSA;
    BotonABGA botonGuardarAlgoritmo;

    public ContenedorBotonera(SectorDibujo sectorDibujo, Personaje personaje){
        this.personaje = personaje;
        this.sectorDibujo = sectorDibujo;

        this.observadorSA = new ArrayList<>();

        //los metodos setOnAction son temporales aca para probar los movimientos del personaje
        BotonAB botonMoverArriba = new BotonAB("Mover Arriba", "arriba.png");
        MovimientoEventHandler movArriba = new MovimientoEventHandler(new BloqueMovimiento(new MovimientoArriba()), sectorDibujo, personaje);
        botonMoverArriba.setOnAction(movArriba);

        BotonAB botonMoverAbajo = new BotonAB("Mover Abajo", "abajo.png");
        MovimientoEventHandler movAbajo = new MovimientoEventHandler(new BloqueMovimiento(new MovimientoAbajo()), sectorDibujo, personaje);
        botonMoverAbajo.setOnAction(movAbajo);

        BotonAB botonMoverIzquierda = new BotonAB("Mover izquierda", "izquierda.png");
        MovimientoEventHandler movIzquierda = new MovimientoEventHandler(new BloqueMovimiento(new MovimientoIzquierda()), sectorDibujo, personaje);
        botonMoverIzquierda.setOnAction(movIzquierda);

        BotonAB botonMoverDerecha = new BotonAB("Mover derecha", "derecha.png");
        MovimientoEventHandler botonMovimiento = new MovimientoEventHandler(new BloqueMovimiento(new MovimientoDerecha()), sectorDibujo, personaje);
        botonMoverDerecha.setOnAction(botonMovimiento);

        BotonAB botonBajarLapiz = new BotonAB("Bajar lapiz", "abajo.png");
        BotonAB botonSubirLapiz = new BotonAB("Subir lapiz", "arriba.png");

        BotonAB botonRepeticion = new BotonAB("Repetir...", "repeticion.png");
        BotonAB botonInvertir = new BotonAB("Invertir comportamiento", "personajeUp.png");

        VBox botones = new VBox(botonMoverArriba, botonMoverAbajo, botonMoverIzquierda, botonMoverDerecha,
                botonBajarLapiz, botonSubirLapiz, botonRepeticion, botonInvertir);

        botonGuardarAlgoritmo = new BotonABGA("Guardar algoritmo", botones );
        this.agregarObservador(botonGuardarAlgoritmo);

        Separator separador = new Separator();

        /*BotonEjecutar ejecutarAlgoritmo = new BotonEjecutar();
        this.agregar(ejecutarAlgoritmo);*/

        Separator nuevoSeparador = new Separator();

        botones.getChildren().addAll(botonGuardarAlgoritmo, separador/*, ejecutarAlgoritmo*/, nuevoSeparador);

        this.botones = botones;
        botones.setBackground(new Background(new BackgroundFill(Color.LIGHTGREY, CornerRadii.EMPTY, Insets.EMPTY)));

    }

    public ContenedorBotonera getContenedorBotonera() {
        return this;
    }

    public VBox obtenerBotones()
    {
        return this.botones;
    }

    public ObservadorSectorAlgoritmo obtenerBotonGuardarAlgoritmo() {
        return botonGuardarAlgoritmo;
    }

    ///////////////////////////////////////////////////////////

    @Override
    public void agregarObservador(ObservadorSectorAlgoritmo observador) {
        this.observadorSA.add(observador);
    }

    @Override
    public void notificarObservador(VBox nuevoContenedor) {
        this.observadorSA.forEach( obs -> obs.cambios(nuevoContenedor) );
    }
}

