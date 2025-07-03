package ar.edu.utn.fra.prog2.vistas;

import ar.edu.utn.fra.prog2.modelo.Cuenta;
import ar.edu.utn.fra.prog2.modelo.Entrada;
import ar.edu.utn.fra.prog2.modelo.Sala;
import java.util.HashMap;
import java.util.List;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class RegisterView extends VBox {
    public RegisterView(Stage stage, HashMap<String, Cuenta> cuentas, 
                      List<Sala> salas, List<Entrada> entradas) {
        Label lbl = new Label("Registro de nuevo usuario");
        Button btnRegistro = new Button("Registrarse");
        Button btnVolver = new Button("Volver");
        
        TextField campoNombre = new TextField();
        campoNombre.setPromptText("Nombre de usuario");
        
        PasswordField campoPin = new PasswordField();
        campoPin.setPromptText("PIN");
        
        TextField campoEmail = new TextField();
        campoEmail.setPromptText("Email");
        
        btnRegistro.setOnAction(e -> {
            String nombre = campoNombre.getText();
            String pin = campoPin.getText();
            String email = campoEmail.getText();
            
            if (nombre.isEmpty() || pin.isEmpty() || email.isEmpty()) {
                lbl.setText("Todos los campos son obligatorios!");
                return;
            }
            
            if (cuentas.containsKey(nombre)) {
                lbl.setText("El nombre de usuario ya existe");
                return;
            }
            
            cuentas.put(nombre, new Cuenta(pin, email));
            lbl.setText("Usuario registrado con éxito!");
            
            
            campoNombre.clear();
            campoPin.clear();
            campoEmail.clear();
        });
        
        btnVolver.setOnAction(e -> {
            LoginView login = new LoginView(stage, cuentas, salas, entradas);
            stage.setScene(new Scene(login));
        });
        
        getChildren().addAll(lbl, campoNombre, campoPin, campoEmail, btnRegistro, btnVolver);
        setSpacing(10);
    }
}

