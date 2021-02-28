package edu.fiuba.algo3.interfaz;

import edu.fiuba.algo3.modelo.Personaje;
import edu.fiuba.algo3.modelo.recursos.DBAlgoritmoPersonalizados;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.util.List;

public class SectorBloquesDisponibles extends VBox {

    private static ContenedorBotonera contenedor;

    public SectorBloquesDisponibles(SectorDibujo sectorDibujo, Personaje personaje){

        //Como se repite codigo en ambos titulos creo que se podría separar en una clase
        Label upper = new Label("Bloques Disponibles");
        upper.setMaxWidth(Double.MAX_VALUE);
        upper.setAlignment(Pos.CENTER);
        upper.setTextFill(Color.WHITE);
        upper.setStyle("-fx-background-color: rgb(85,40,129);");
        upper.setFont(Font.font("Times",20));
        this.getChildren().add(upper);

        contenedor = new ContenedorBotonera(sectorDibujo, personaje);
        VBox contenedorBotonera = contenedor.obtenerBotones();

        ScrollPane scrollVbox = new ScrollPane(contenedorBotonera);
        scrollVbox.setFitToWidth(true);

        DBAlgoritmoPersonalizados db = new DBAlgoritmoPersonalizados();
        List<List<?>> info_algoritmos_personalizados = db.cargar_todos_algoritmos();

        info_algoritmos_personalizados.forEach( info -> contenedorBotonera.getChildren().add( new Button( (String) info.get(0))));

        contenedorBotonera.setAlignment( Pos.TOP_CENTER );
        contenedorBotonera.setSpacing( 2 );

        this.setMaxWidth(300);
        this.getChildren().add(scrollVbox);
        this.setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
    }

    public ContenedorBotonera obtenerBotonera()
    {
        return contenedor.getContenedorBotonera();
    }

    public void agregarEnlaceConSector(SectorAlgoritmo sectorAlgoritmo) {
        sectorAlgoritmo.agregarObservador( contenedor.obtenerBotonGuardarAlgoritmo() );
    }
}
