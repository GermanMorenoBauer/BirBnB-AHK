package dds.birbnb_ahk.entities.alojamientos;

import dds.birbnb_ahk.entities.*;
import dds.birbnb_ahk.entities.reservas.RangoFechas;
import dds.birbnb_ahk.entities.reservas.Reserva;
import dds.birbnb_ahk.entities.ubicaciones.Direccion;
import dds.birbnb_ahk.entities.usuarios.Usuario;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name ="alojamiento")
public class Alojamiento {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;


    @ManyToOne
    @JoinColumn(name = "anfitrion_id" , nullable = false)
    @Getter
    @Setter
    private Usuario anfitrion;

    @Setter
    @Getter
    @Column
    private String nombre;

    @Setter
    @Getter
    @Column(columnDefinition = "TEXT")
    private String descripcion;

    @Setter
    @Getter
    @Column
    private  Double precioPorNoche;

    @Setter
    @Getter
    @Enumerated(EnumType.STRING)
    private Moneda moneda;

    @Setter
    @Getter
    @Column(columnDefinition = "TIME")
    private LocalTime horarioCheckIn;

    @Setter
    @Getter
    @Column(columnDefinition = "TIME")
    private LocalTime HorarioCheckOut;

    @Setter
    @Getter
    @OneToOne
    @JoinColumn(name = "direccion_id" , nullable = false)
    private Direccion direccion;

    @Setter
    @Getter
    private Integer cantHuespedesMax;

    @Setter
    @Getter
    @OneToMany
    @JoinColumn(name = "alojamiento_id")
    private List<Foto> fotos;

    @Getter
    @ElementCollection
    @CollectionTable(name = "alojamiento_caracteristica", joinColumns = @JoinColumn(name = "alojamiento_id"))
    @Enumerated(EnumType.STRING)
    @Column(name = "caracteristas")
    private List<Caracteristica> caracteristicas;

    @Setter
    @Getter
    @OneToMany(mappedBy = "alojamiento")
    private List<Reserva> reservas;



    public Alojamiento(){
        this.fotos = new ArrayList<>();
        this.caracteristicas = new ArrayList<>();
        this.reservas = new ArrayList<>();
    }
    public Boolean tenesCaracteristica(Caracteristica caracteristica){
        return this.caracteristicas.contains(caracteristica);
    }
    public Boolean tuPrecioEstaDentroDe(Double valorMinimo, Double valorMax){

        return this.precioPorNoche <=valorMax && this.precioPorNoche >= valorMinimo;
    }

    public Boolean estasDisponibleEn(RangoFechas rango) {
        /*boolean haySuperposicion = false;

        int i = 0;

        while (i<this.reservas.size() && !haySuperposicion){
            Reserva reserva = this.reservas.get(i);
            RangoFechas rangoDeLaReserva = reserva.getRango();

            if(rangoDeLaReserva.haySuperposicionCon(rango)){
                haySuperposicion = true;
            }

            i++;
        }

        return !haySuperposicion;*/

        return  !this.reservas.stream().anyMatch(r -> r.getRango().haySuperposicionCon(rango));

    }

    public Boolean puedenAlojarse(Integer cantHuespedes){
        return cantHuespedes <= this.cantHuespedesMax;
    }
}




