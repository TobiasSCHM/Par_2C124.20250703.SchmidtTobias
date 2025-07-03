/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.edu.utn.fra.prog2.modelO;

import java.io.Serializable;

/**
 *
 * @author Tobias
 */
public class Butaca implements Serializable {
    private int numero;
    private int fila;
    private boolean ocupada;
    
    public Butaca(int fila, int numero) {
        this.fila = fila;
        this.numero = numero;
        this.ocupada = false;
    }
    
    // Getters y setters
    public int getNumero() { return numero; }
    public int getFila() { return fila; }
    public boolean isOcupada() { return ocupada; }
    public void setOcupada(boolean ocupada) { this.ocupada = ocupada; }
    
    @Override
    public String toString() {
        return "Fila " + fila + ", Butaca " + numero + (ocupada ? " (Ocupada)" : " (Libre)");
    }
}