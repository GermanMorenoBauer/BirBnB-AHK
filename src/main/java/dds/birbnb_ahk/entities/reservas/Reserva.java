package dds.birbnb_ahk.entities.reservas;

import dds.birbnb_ahk.entities.usuarios.Usuario;
import dds.birbnb_ahk.entities.alojamientos.Alojamiento;
import dds.birbnb_ahk.entities.notificaciones.FactoryNotificacion;
import dds.birbnb_ahk.entities.notificaciones.Notificacion;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "reserva")

public class Reserva {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(columnDefinition = "DATE")
    private LocalDate fechaAlta;

    @ManyToOne
    @JoinColumn(name = "huesped_id", nullable = false)
    private Usuario huesped;

    @ManyToOne
    @JoinColumn(name = "alojamiento_id", nullable = false)
    private Alojamiento alojamiento;

    @Embedded
    private RangoFechas rango;

    @Enumerated(EnumType.STRING)
    private EstadoReserva estado;

    @Column
    private Double precioPornoche;

    public void actualizarEstado(EstadoReserva estado){
        this.estado = estado;
        //TODO pendiente de ser guardado
        Notificacion notificacion = new FactoryNotificacion().crearSegunReserva(this);
        //TODO
        return;
    }
}
