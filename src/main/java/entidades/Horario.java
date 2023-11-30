package entidades;


import enumerados.TipoDia;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.time.LocalDate;
import java.util.List;
import lombok.Data;


@Entity
public @Data class Horario {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private TipoDia dia;
    private int horarioComienzo;
    private int horarioFin;
}
