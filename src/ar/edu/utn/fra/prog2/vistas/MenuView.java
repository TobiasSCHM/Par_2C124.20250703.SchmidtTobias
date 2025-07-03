package ar.edu.utn.fra.prog2.vistas;

import ar.edu.utn.fra.prog2.modelo.Cuenta;
import ar.edu.utn.fra.prog2.modelo.Entrada;
import ar.edu.utn.fra.prog2.modelo.Sala;
import java.util.HashMap;
import java.util.List;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MenuView extends VBox {
    public MenuView(Stage stage, Cuenta cuenta, 
                   HashMap<String, Cuenta> cuentas,
                   List<Sala> salas,
                   List<Entrada> entradas) {
        
        // Configuración básica
        setSpacing(10);
        
        // Componentes simples
        Label lblBienvenida = new Label("Bienvenido, " + cuenta.getNombre());
        
        Button btnVerPeliculas = new Button("Ver películas disponibles");
        Button btnComprarEntrada = new Button("Comprar entrada");
        Button btnMisEntradas = new Button("Mis entradas");
        Button btnCerrarSesion = new Button("Cerrar sesión");
        
        // Label para mostrar información
        Label lblInfo = new Label();
        lblInfo.setWrapText(true); // Para que el texto se ajuste
        
        // Acciones de los botones
        btnVerPeliculas.setOnAction(e -> {
            String info = "Películas disponibles:\n";
            for (Sala sala : salas) {
                info += sala.toString() + "\n";
            }
            lblInfo.setText(info);
        });
        
        btnComprarEntrada.setOnAction(e -> {
            CompraView compraView = new CompraView(stage, cuenta, cuentas, salas, entradas);
            stage.setScene(new Scene(compraView));
        });
        
        btnMisEntradas.setOnAction(e -> {
            String info = "Tus entradas:\n";
            int contador = 0;
            for (Entrada entrada : entradas) {
                if (entrada.getCuenta().equals(cuenta)) {
                    info += entrada.toString() + "\n";
                    contador++;
                }
            }
            if (contador == 0) {
                info = "No tienes entradas compradas.";
            }
            lblInfo.setText(info);
        });
        
        btnCerrarSesion.setOnAction(e -> {
            LoginView login = new LoginView(stage, cuentas, salas, entradas);
            stage.setScene(new Scene(login));
        });
        
        // Agregar componentes al layout
        getChildren().addAll(
            lblBienvenida, 
            btnVerPeliculas, 
            btnComprarEntrada, 
            btnMisEntradas, 
            lblInfo,
            btnCerrarSesion
        );
    }
}
