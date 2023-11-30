package entidades;

import enumerados.TipoDia;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.List;
import lombok.Data;

@Entity
@Data
public class Prestador {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String nombre;
    private String apellido;
    private String cuil_cuit;
    private String telefono;
    private String email;

    @ManyToOne
    private Servicio servicioOfrecido;

    @ElementCollection(targetClass = TipoDia.class)
    @Enumerated(EnumType.STRING)
    private List<TipoDia> diasDisponibles;

    @OneToMany
    private List<Horario> horariosDeAtencion;

    private int radioCobertura;

    @ElementCollection
    private List<String> imagenesTrabajos;

    private String experiencia;

}
