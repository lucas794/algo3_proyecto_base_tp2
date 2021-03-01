package edu.fiuba.algo3.interfaz.vista;

import edu.fiuba.algo3.modelo.Personaje;
import javafx.geometry.Insets;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;


public class Tablero extends BorderPane {
    private BarraDeMenu barraDeMenu;
    private SectorDibujo sectorDibujo;
    private SectorBloquesDisponibles sectorBloques;
    private SectorAlgoritmo sectorAlgoritmo;

    public Tablero(MediaPlayer mediaPlayer) {
        inicializar(mediaPlayer);
        posicionarSectores();
        BorderPane.setMargin(sectorDibujo, new Insets(0,5,300,10));
        BorderPane.setMargin(sectorBloques, new Insets(0,5,20,10));
        BorderPane.setMargin(sectorAlgoritmo, new Insets(0,5,20,10));
    }

    private void posicionarSectores() {
        this.setTop(barraDeMenu);
        this.setCenter(sectorBloques);
        this.setRight(sectorAlgoritmo);
        this.setLeft(sectorDibujo);
    }

    private void inicializar(MediaPlayer mediaPlayer){
        barraDeMenu = new BarraDeMenu(mediaPlayer);
        Personaje personaje = new Personaje();
        sectorDibujo = new SectorDibujo(personaje); // acá, de alguna manera posiblemente haya que pasarle los bloques que están en el sector algoritmo..
        sectorBloques = new SectorBloquesDisponibles(sectorDibujo, personaje);
        sectorAlgoritmo = new SectorAlgoritmo( sectorBloques.obtenerBotonera() );
        sectorBloques.agregarEnlaceConSector( sectorAlgoritmo );
        sectorDibujo.agregarEnlaceConSector( sectorAlgoritmo );
    }
}

