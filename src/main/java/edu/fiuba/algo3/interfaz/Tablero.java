package edu.fiuba.algo3.interfaz;

import javafx.geometry.Insets;
import javafx.scene.layout.BorderPane;

public class Tablero extends BorderPane {

    SectorDibujo sectorDibujo = new SectorDibujo();
    SectorBloquesDisponibles sectorBloques = new SectorBloquesDisponibles();
    SectorAlgoritmo sectorAlgoritmo = new SectorAlgoritmo();

    public Tablero() {

        posicionarSectores();

        BorderPane.setMargin(sectorDibujo, new Insets(20,5,300,10));
        BorderPane.setMargin(sectorBloques, new Insets(20,5,20,10));
        BorderPane.setMargin(sectorAlgoritmo, new Insets(20,5,20,10));

    }

    private void posicionarSectores() {
        this.setCenter(sectorBloques);
        this.setRight(sectorAlgoritmo);
        this.setLeft(sectorDibujo);
    }
}
