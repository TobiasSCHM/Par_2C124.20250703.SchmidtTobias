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
import ar.edu.utn.fra.prog2.controladores.ControladorLogin;

public class LoginView extends VBox {
    
    private HashMap<String, Cuenta> cuentas;
    private List<Sala> salas;
    private List<Entrada> entradas;
    
    public LoginView(Stage stage, HashMap<String, Cuenta> cuentas, 
                    List<Sala> salas, List<Entrada> entradas) {
        Label mensaje = new Label("Ingrese nombre de usuario y PIN:");
        
        Button btnIngresar = new Button("Ingresar");
        Button btnRegistrar = new Button("Registrate");
        Button btnCuentas = new Button("Cuentas - DEBUG");
        
        TextField campoNombre = new TextField();
        campoNombre.setPromptText("Nombre de usuario");
        
        PasswordField campoPin = new PasswordField();
        campoPin.setPromptText("PIN");

        btnIngresar.setOnAction(e -> {
            String nombre = campoNombre.getText();
            String pin = campoPin.getText();

            Cuenta cuenta = cuentas.get(nombre);
            if (cuenta != null && cuenta.validarPin(pin)) {
                MenuView menu = new MenuView(stage, cuenta, cuentas, salas, entradas);
                stage.setScene(new Scene(menu));
            } else {
                mensaje.setText("ERROR: usuario o pin incorrecto.");
            }
        });

        btnRegistrar.setOnAction(e -> {
            RegisterView register = new RegisterView(stage, cuentas, salas, entradas);
            stage.setScene(new Scene(register));
        });
        
        btnCuentas.setOnAction(e-> {
            System.out.println("Cuentas cargadas: " + cuentas);
        });
        
        getChildren().addAll(mensaje, campoNombre, campoPin, btnIngresar, btnRegistrar, btnCuentas);
        setSpacing(10);
    }
}