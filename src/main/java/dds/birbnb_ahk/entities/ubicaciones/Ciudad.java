package dds.birbnb_ahk.entities.ubicaciones;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "ciudad")

public class Ciudad {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @ManyToOne
    @JoinColumn(name = "pais_id" , referencedColumnName = "id" , nullable = false)
    private Pais pais;
}
