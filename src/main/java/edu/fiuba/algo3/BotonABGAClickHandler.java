package edu.fiuba.algo3;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BotonABGAClickHandler extends Stage implements EventHandler<MouseEvent> {

    VBox contenendorAlgoritmo;

    public BotonABGAClickHandler(VBox contenendorAlgoritmo) {
        this.contenendorAlgoritmo = contenendorAlgoritmo;
    }

    @Override
    public void handle(MouseEvent mouseEvent) {
        Label informacion = new Label("Ingrese un nombre al algoritmo a guardar");
        TextField texto = new TextField();
        Button aceptar = new Button("Aceptar");
        Button cancelar = new Button( "Cancelar" );

        VBox menu = new VBox(informacion, texto);
        menu.setAlignment(Pos.BASELINE_CENTER);

        HBox opciones = new HBox(aceptar, cancelar);
        opciones.setAlignment( Pos.BASELINE_CENTER );

        menu.getChildren().addAll(opciones);

        Scene escena = new Scene(menu, 375, 80);

        this.setTitle("Guardar algoritmo");

        this.setScene(escena);

        this.show();

        cancelar.setOnMouseClicked( e-> this.hide() );
        aceptar.setOnMouseClicked( e-> {
            System.out.println(this.contenendorAlgoritmo.getChildren().size());
            this.contenendorAlgoritmo.getChildren().clear();
            this.hide();
        });
    }

}
