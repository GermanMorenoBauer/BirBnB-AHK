package dds.birbnb_ahk.entities;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Alojamiento {

    @Setter
    @Getter
    private Usuario anfitrion;

    @Setter
    @Getter
    private String nombre;

    @Setter
    @Getter
    private String descripcion;

    @Setter
    @Getter
    private  Double precioPorNoche;

    @Setter
    @Getter
    private Moneda moneda;

    @Setter
    @Getter
    private LocalTime horarioCheckIn;

    @Setter
    @Getter
    private LocalTime HorarioCheckOut;

    @Setter
    @Getter
    private  Direccion direccion;

    @Setter
    @Getter
    private Integer cantHuespedesMax;

    @Getter
    private List<Caracteristica> caracteristicas;

    @Setter
    @Getter
    private List<Reserva> reservas;

    @Setter
    @Getter
    private List<Foto> fotos;

    public Alojamiento(){
        this.fotos = new ArrayList<>();
        this.caracteristicas = new ArrayList<>();
        this.reserva = new ArrayList<>();
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




