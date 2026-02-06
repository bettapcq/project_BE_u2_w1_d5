package projectu2w1d5.bettapcq.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "postazioni")
@Getter
@Setter
@NoArgsConstructor
@ToString
public class Postazione {
    @Id
    @GeneratedValue
    @Setter(AccessLevel.NONE)
    private UUID uuid_postazione;
    @Enumerated(EnumType.STRING)
    private TipoPostazione tipo;
    private String descrizione;
    private int num_max_occupanti;
    @ManyToOne
    @JoinColumn(name = "id_edificio", nullable = false)
    private Edificio edificio;

    public Postazione(TipoPostazione tipo, String descrizione, int num_max_occupanti, Edificio edificio) {
        this.tipo = tipo;
        this.descrizione = descrizione;
        this.num_max_occupanti = num_max_occupanti;
        this.edificio = edificio;
    }
}
