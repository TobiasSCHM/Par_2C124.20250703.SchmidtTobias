package ar.edu.utn.fra.prog2.modelo;

import java.io.Serializable;
import java.time.LocalDateTime;
        
public class Funcion implements Serializable {
    private Sala sala;
    private LocalDateTime horario;
    
    public Funcion(Sala sala, LocalDateTime horario) {
        this.sala = sala;
        this.horario = horario;
    }
    
    
    public Sala getSala() { return sala; }
    public LocalDateTime getHorario() { return horario; }
    
    @Override
    public String toString() {
        return sala.toString() + " - " + horario.toLocalDate() + " " + horario.toLocalTime();
    }
}
