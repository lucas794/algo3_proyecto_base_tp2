package edu.fiuba.algo3.interfaz;

import edu.fiuba.algo3.HabilidadAceptarDrag;
import edu.fiuba.algo3.HabilidadDrop;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;

public class SectorAlgoritmo extends VBox {

    public SectorAlgoritmo(){
        Label text = new Label("Espacio de Trabajo");
        text.setMaxWidth(Double.MAX_VALUE);
        text.setAlignment(Pos.CENTER);
        this.getChildren().add(text);

        VBox contenedorAlgoritmo = new VBox();
        contenedorAlgoritmo.setPrefSize(400, 600);
        contenedorAlgoritmo.setAlignment(Pos.TOP_CENTER);
        this.getChildren().add(contenedorAlgoritmo);

        this.setBackground(new Background(new BackgroundFill(Color.LIGHTGREY, CornerRadii.EMPTY, Insets.EMPTY)));

        contenedorAlgoritmo.setOnDragOver( new HabilidadAceptarDrag(TransferMode.ANY) );

        contenedorAlgoritmo.setOnDragDropped( new HabilidadDrop(this, contenedorAlgoritmo) );
    }

}
