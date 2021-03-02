package edu.fiuba.algo3.interfaz.vista;

import edu.fiuba.algo3.modelo.tablero.Dibujo;
import javafx.scene.shape.Line;

import java.util.List;

public class VistaLinea {
    private static final int POS_INICIAL_CENTER = 200;
    Dibujo dibujo;
    int siguienteLinea = 0;
    int tamAnterior = 0;
    Line line;
    public VistaLinea(Dibujo dibujo) {
        this.dibujo = dibujo;
    }

    public void updateVistaLinea(SectorDibujo sectorDibujo) {

        if (dibujo.obtenerSectorDibujado().size() != 0 && dibujo.obtenerSectorDibujado().size() >= tamAnterior) {
            List<Integer> PosInicial = dibujo.obtenerSectorDibujado().get(siguienteLinea).obtenerCoordenadasPosicionInicial();
            List<Integer> PosFinal = dibujo.obtenerSectorDibujado().get(siguienteLinea).obtenerCoordenadasPosicionFinal();
            line = new Line(215 + PosInicial.get(0) * 10, 235 - PosInicial.get(1) * 20, 250 + PosFinal.get(0) * 10, 235 - PosFinal.get(1) * 20);
            line.setStrokeWidth(5);
            sectorDibujo.getChildren().add(line);
            siguienteLinea++;
            tamAnterior = dibujo.obtenerSectorDibujado().size();
        }
    }

    public void reset(){
        this.line = new Line();
    }
}


