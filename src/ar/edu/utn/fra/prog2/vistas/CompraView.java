package ar.edu.utn.fra.prog2.vistas;

import ar.edu.utn.fra.prog2.modelo.Cuenta;
import ar.edu.utn.fra.prog2.modelo.Entrada;
import ar.edu.utn.fra.prog2.modelo.Funcion;
import ar.edu.utn.fra.prog2.modelo.Sala;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CompraView extends VBox {
    public CompraView(Stage stage, Cuenta cuenta, 
                     HashMap<String, Cuenta> cuentas,
                     List<Sala> salas,
                     List<Entrada> entradas) {
        setPadding(new Insets(10));
        setSpacing(10);
        
        Label lblTitulo = new Label("Compra de entradas");
        
        
        Label lblSalas = new Label("Salas disponibles:");
        for (Sala sala : salas) {
            lblSalas.setText(lblSalas.getText() + "\n" + sala.toString());
        }
        
        Label lblInstrucciones = new Label("Ingrese el número de sala y asiento:");
        
        TextField tfSala = new TextField();
        tfSala.setPromptText("Número de sala");
        
        TextField tfAsiento = new TextField();
        tfAsiento.setPromptText("Número de asiento");
        
        Button btnComprar = new Button("Comprar entrada");
        Button btnVolver = new Button("Volver al menú");
        
        btnComprar.setOnAction(e -> {
            try {
                int numSala = Integer.parseInt(tfSala.getText());
                int numAsiento = Integer.parseInt(tfAsiento.getText()) - 1; // Convertir a índice 0-based
                
                Sala salaSeleccionada = null;
                for (Sala sala : salas) {
                    if (sala.getNumero() == numSala) {
                        salaSeleccionada = sala;
                        break;
                    }
                }
                
                if (salaSeleccionada == null) {
                    lblTitulo.setText("Sala no encontrada");
                    return;
                }
                
                if (numAsiento < 0 || numAsiento >= salaSeleccionada.getCapacidad()) {
                    lblTitulo.setText("Número de asiento inválido");
                    return;
                }
                
                if (salaSeleccionada.estaOcupado(numAsiento)) {
                    lblTitulo.setText("Asiento ocupado, seleccione otro");
                    return;
                }
                
                
                Funcion funcion = new Funcion(salaSeleccionada, LocalDateTime.now());
                
                
                Entrada entrada = new Entrada(funcion, numAsiento, cuenta);
                entradas.add(entrada);
                salaSeleccionada.ocuparAsiento(numAsiento);
                
                lblTitulo.setText("Entrada comprada con éxito!\n" + entrada);
                
                
                tfSala.clear();
                tfAsiento.clear();
                
            } catch (NumberFormatException ex) {
                lblTitulo.setText("Ingrese números válidos");
            }
        });
        
        btnVolver.setOnAction(e -> {
            MenuView menu = new MenuView(stage, cuenta, cuentas, salas, entradas);
            stage.getScene().setRoot(menu);
        });
        
        getChildren().addAll(lblTitulo, lblSalas, lblInstrucciones, 
                           tfSala, tfAsiento, btnComprar, btnVolver);
    }
}