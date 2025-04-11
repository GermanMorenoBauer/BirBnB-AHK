package dds.birbnb_ahk.entities.reservas;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
@Embeddable

public class RangoFechas {

    @Column(columnDefinition = "DATE")
    private LocalDate fechaInicio;

    @Column(columnDefinition = "DATE")
    private LocalDate fechaFin;

//f1(x1;x2) f2=(x3,x4)  {x1 <=x4 , x3 <= x2} f1=(25/4/10;25/4/20) f2=(25/4/15;25/4/25)
    public boolean haySuperposicionCon(RangoFechas rango) {
        return this.fechaInicio.isBefore(rango.getFechaFin())
                && rango.getFechaInicio().isBefore(this.fechaFin);
    }
}
