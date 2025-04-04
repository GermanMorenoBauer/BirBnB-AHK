package dds.birbnb_ahk.entities;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter

public class Reserva {
    private LocalDate fechaAlta;
    private Usuario huesped;
    private Alojamiento alojamiento;
    private RangoFechas rango;
    private EstadoReserva estado;
    private Double precioPornoche;

    public void actualizarEstado(EstadoReserva estado){
        this.estado = estado;
        //TODO pendiente de ser guardado
        Notificacion notificacion = new FactoryNotificacion().crearSegunReserva(this);
        //TODO
        return;
    }
}
