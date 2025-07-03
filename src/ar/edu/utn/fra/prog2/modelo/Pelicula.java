package ar.edu.utn.fra.prog2.modelo;

import java.io.Serializable;

public class Pelicula implements Serializable {
    private String titulo;
    private String genero;
    private int duracion; // en minutos
    
    public Pelicula(String titulo, String genero, int duracion) {
        this.titulo = titulo;
        this.genero = genero;
        this.duracion = duracion;
    }
    
  
    public String getTitulo() {
        return titulo; }
    
    public String getGenero() {
        return genero; }
    
    public int getDuracion() {
        return duracion; }
    
    @Override
    public String toString() {
        return titulo + " (" + genero + ", " + duracion + " mins)";
    }
}