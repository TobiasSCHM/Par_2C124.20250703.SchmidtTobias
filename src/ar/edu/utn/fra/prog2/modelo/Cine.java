/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.edu.utn.fra.prog2.modelo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Tobias
 */
public class Cine {
    
    private HashMap<String, Cuenta> cuentas;
    private List<Entrada> entradas;
    private List<Sala> salas;
    private Cuenta cuentaActual;
    private Sala salaSeleccionada;

    public Cine(List<Sala> salas) {
        this.salas = salas;
        this.entradas = new ArrayList<>();
        this.cuentas = new HashMap<>();
    }
    
    
}
