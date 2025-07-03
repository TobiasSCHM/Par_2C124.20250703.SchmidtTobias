/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.edu.utn.fra.prog2.vistas;

import ar.edu.utn.fra.prog2.modelo.Cuenta;
import java.util.HashMap;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Tobias
 */
class MenuView extends VBox {

    public MenuView(Stage stage, Cuenta cuenta, HashMap<String, Cuenta> cuentas) {
        Label bienvenida = new Label("Bienvenido al sistema.");
        Button btnSalir = new Button("Salir");
        
        btnSalir.setOnAction(e -> {
            LoginView login = new LoginView(stage, cuentas);
            stage.setScene(new Scene(login));
        });
    }
    
}
