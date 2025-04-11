package dds.birbnb_ahk.entities.ubicaciones;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
//agregamos ambos a todos los atributos de este archivo
@Setter
@Getter
@Entity
@Table(name= "pais")

public class Pais {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nombre",columnDefinition = "VARCHAR(50)")
    private String nombre;

    public Pais(String nombre){
        this.nombre = nombre;
    }

}

//hacer direccion,ciudad,foto,rangofechas,clase usuario,clase alojamiento,reserva,cambioEstadoReserva,notificacion,factoryNotificacion
