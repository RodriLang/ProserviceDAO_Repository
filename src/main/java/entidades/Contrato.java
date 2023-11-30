package entidades;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.time.LocalDate;
import java.util.List;
import lombok.Data;

@Entity
@Data
public class Contrato {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToOne
    private Consumidor consumidor;

    @ManyToOne
    private Prestador prestador;
    @Temporal(TemporalType.DATE)
    private LocalDate fecha;
    private int distancia;

    private List<Integer> rangoHorario;

    @ElementCollection
    private List<Tarea> tareasARealizar;

    private boolean aceptado;
    private double precio;

}
