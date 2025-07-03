package ar.edu.utn.fra.prog2.modelo;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Entrada implements Serializable {
    private Funcion funcion;
    private int asiento;
    private LocalDateTime fechaCompra;
    private Cuenta cuenta;
    
    public Entrada(Funcion funcion, int asiento, Cuenta cuenta) {
        this.funcion = funcion;
        this.asiento = asiento;
        this.cuenta = cuenta;
        this.fechaCompra = LocalDateTime.now();
    }
    
    // Getters
    public Funcion getFuncion() { return funcion; }
    public int getAsiento() { return asiento; }
    public LocalDateTime getFechaCompra() { return fechaCompra; }
    public Cuenta getCuenta() { return cuenta; }
    
    @Override
    public String toString() {
        return "Entrada para " + funcion.getSala().getPelicula().getTitulo() +  ///////SOLUCIONAR-SOLUCIONAR-SOLUCIONAR-SOLUCIONAR-SOLUCIONAR-
               ", Asiento: " + asiento + ", " + funcion.getHorario().toLocalTime();
    }
}