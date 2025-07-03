/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ar.edu.utn.fra.prog2.modelo;

import java.io.Serializable;

/**
 *
 * @author Tobias
 */
public class Cuenta implements Serializable {
    private String pin;
    private String nombre;
    private String email;

    public Cuenta(String pin, String nombre) {
        this.pin = pin;
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
    
    
    
    public boolean validarPin(String pin){
        return this.pin.equals(pin);
    }
    @Override
    public String toString() {
    return "Cuenta{" +
           "nombre='" + nombre + '\'' +  
           ", pin='" + pin + '\'' +
           '}';
}
}
