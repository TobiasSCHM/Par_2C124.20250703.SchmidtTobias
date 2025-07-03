/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ar.edu.utn.fra.prog2.app;

import ar.edu.utn.fra.prog2.modelo.Cuenta;
import ar.edu.utn.fra.prog2.modelo.Entrada;
import ar.edu.utn.fra.prog2.modelo.Sala;
import ar.edu.utn.fra.prog2.persistencia.PersistenciaDatos;
import ar.edu.utn.fra.prog2.vistas.LoginView;
import java.util.HashMap;
import java.util.List;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;



/**
 *
 * @author Tobias
 */
public class Parcial2 extends Application {
    private HashMap<String, Cuenta> cuentas;
    private List<Sala> salas;
    private List<Entrada> entradas;

    public static void main(String[] args) {
        launch(args);
    }
    
@Override    
    public void start(Stage stage) throws Exception {
        cuentas = PersistenciaDatos.cargarCuentas();
        salas = PersistenciaDatos.cargarSalas();
        entradas = PersistenciaDatos.cargarEntradas();
        
        LoginView login = new LoginView(stage, cuentas, salas, entradas);
        
        stage.setScene(new Scene(login));
        stage.setTitle("Sistema de Cine - Inicio de sesión"); 
        
        stage.setOnCloseRequest(e -> {
        PersistenciaDatos.guardarTodo(cuentas, salas, entradas);
        });
        
        stage.show();
    } 
}
