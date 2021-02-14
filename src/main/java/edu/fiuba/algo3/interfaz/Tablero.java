package edu.fiuba.algo3.interfaz;

import javafx.geometry.Insets;
import javafx.scene.layout.BorderPane;

public class Tablero extends BorderPane {

    public Tablero() {

        SectorDibujo sectorDibujo = new SectorDibujo();
        SectorBloquesDisponibles sectorBloques = new SectorBloquesDisponibles();
        SectorAlgoritmo sectorAlgoritmo = new SectorAlgoritmo();

        this.setCenter(sectorBloques);
        this.setRight(sectorAlgoritmo);
        this.setLeft(sectorDibujo);

        BorderPane.setMargin(sectorDibujo, new Insets(20,50,300,30));
        BorderPane.setMargin(sectorBloques, new Insets(20,50,50,30));
        BorderPane.setMargin(sectorAlgoritmo, new Insets(20,50,50,30));

    }
}
