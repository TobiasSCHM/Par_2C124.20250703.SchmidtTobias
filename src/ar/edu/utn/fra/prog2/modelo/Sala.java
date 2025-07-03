package ar.edu.utn.fra.prog2.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Sala implements Serializable {
    private int numero;
    private Pelicula pelicula;
    private int capacidad;
    private List<Boolean> asientos; // true = ocupado

    public Sala(int numero, Pelicula pelicula, int capacidad) {
        this.numero = numero;
        this.pelicula = pelicula;
        this.capacidad = capacidad;
        this.asientos = new ArrayList<>(capacidad);
        for (int i = 0; i < capacidad; i++) {
            asientos.add(false);
        }
    }
    
    
    public int getNumero() { return numero; }
    public Pelicula getPelicula() { return pelicula; }
    public int getCapacidad() { return capacidad; }
    
    public boolean estaOcupado(int asiento) {
        return asientos.get(asiento);
    }
    
    public boolean ocuparAsiento(int asiento) {
        if (asiento < 0 || asiento >= capacidad || estaOcupado(asiento)) {
            return false;
        }
        asientos.set(asiento, true);
        return true;
    }
    
    public int asientosDisponibles() {
        int disponibles = 0;
        for (boolean ocupado : asientos) {
            if (!ocupado) disponibles++;
        }
        return disponibles;
    }
    
    @Override
    public String toString() {
        return "Sala " + numero + ": " + pelicula.getTitulo() + 
               " (" + asientosDisponibles() + "/" + capacidad + " disponibles)";
    }
    
}