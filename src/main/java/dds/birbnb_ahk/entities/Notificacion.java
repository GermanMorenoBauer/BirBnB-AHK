package dds.birbnb_ahk.entities;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Setter
@Getter

public class Notificacion {
    private String mensaje;
    private Usuario usuario;
    private LocalDate fechaAlta;
    private Boolean leida;
    private LocalDate fechaLeida;


    public Notificacion(){
        this.leida = true;
        this.fechaAlta = LocalDateTime.now();
    }
    public void marcarComoLeida(){
        this.leida = true;
        this.fechaLeida = LocalDateTime.now();
    }
}
