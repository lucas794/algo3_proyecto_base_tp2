package edu.fiuba.algo3.interfaz.vista;

import edu.fiuba.algo3.interfaz.controladores.OpcionAcercaDeEventHandler;
import edu.fiuba.algo3.interfaz.controladores.OpcionInstruccionesEventHanlder;
import edu.fiuba.algo3.interfaz.controladores.OpcionSalirEventHandler;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

public class BarraDeMenu extends MenuBar {

    public BarraDeMenu() {

        Menu menuArchivo = new Menu("Archivo");
        Menu menuVer = new Menu("Ver");

        MenuItem opcionSalir = new MenuItem("Salir");
        MenuItem opcionInstrucciones = new MenuItem("Instrucciones");
        MenuItem opcionAcercaDe = new MenuItem("Acerca de...");

        OpcionSalirEventHandler opcionSalirHandler = new OpcionSalirEventHandler();
        opcionSalir.setOnAction(opcionSalirHandler);

        OpcionAcercaDeEventHandler opcionAcercaDeHandler = new OpcionAcercaDeEventHandler();
        opcionAcercaDe.setOnAction(opcionAcercaDeHandler);

        OpcionInstruccionesEventHanlder opcionInstruccionestHanlder = new OpcionInstruccionesEventHanlder();
        opcionInstrucciones.setOnAction(opcionInstruccionestHanlder);

        menuArchivo.getItems().add(opcionSalir);
        menuVer.getItems().addAll(opcionInstrucciones, opcionAcercaDe);

        this.getMenus().addAll(menuArchivo, menuVer);
    }

}
