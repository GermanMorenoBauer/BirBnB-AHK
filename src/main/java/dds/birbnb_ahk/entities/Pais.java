package dds.birbnb_ahk.entities;

import lombok.Getter;
import lombok.Setter;
//agregamos ambos a todos los atributos de este archivo
@Setter
@Getter

public class Pais {
    //si pongo arriba de setter y getter los atributos,estos no poseen ambos
    @Getter //devolver el valor de mi atributo
    @Setter //metodos que nos permiten cambiar el valor de mi atributo
    private String nombre;
    private String apellido;

}

//hacer direccion,ciudad,foto,rangofechas,clase usuario,clase alojamiento,reserva,cambioEstadoReserva,notificacion,factoryNotificacion
