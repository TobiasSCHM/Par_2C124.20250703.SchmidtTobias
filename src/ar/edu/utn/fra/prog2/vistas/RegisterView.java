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
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author Tobias
 */
public class RegisterView extends VBox {

    public RegisterView(Stage stage, HashMap<String, Cuenta> cuentas) {
                Label lbl = new Label("Registro de nuevo usuario");
        Button btnRegistro = new Button("Registrarse");
        Button btnVolver = new Button("Volver");
        
        TextField campoNombre = new TextField();
        campoNombre.setPromptText("Nombre de usuario");
        
        PasswordField campoPin = new PasswordField();
        campoPin.setPromptText("PIN");
        
        TextField campoNombreCompleto = new TextField();
        campoNombreCompleto.setPromptText("Nombre completo");
        
        TextField campoEmail = new TextField();
        campoEmail.setPromptText("Direccion Mail.");
        
        btnRegistro.setOnAction(e -> {
            String nombre = campoNombre.getText();
            String pin = campoPin.getText();
            String nombreCompleto = campoNombreCompleto.getText();
            String mail = campoEmail.getText();
            
            if (nombre.isEmpty() || pin.isEmpty() || nombreCompleto.isEmpty() || mail.isEmpty()) {
                lbl.setText("Todos los campos son obligatorios!");
                return;
            }
            
            if (cuentas.containsKey(nombre)) {
                lbl.setText("El nombre de usuario ya existe");
                return;
            }
            
            cuentas.put(nombre, new Cuenta(pin, nombreCompleto));
            lbl.setText("Usuario registrado con éxito!");
            
            // Limpiar campos
            campoNombre.clear();
            campoPin.clear();
            campoNombreCompleto.clear();
            campoEmail.clear();
        });
        
        btnVolver.setOnAction(e -> {
            LoginView login = new LoginView(stage, cuentas);
            stage.setScene(new Scene(login));
        });
        
        getChildren().addAll(lbl, campoNombre, campoPin, campoNombreCompleto, campoEmail, btnRegistro, btnVolver);
        setSpacing(10);
    }
}
    
    

