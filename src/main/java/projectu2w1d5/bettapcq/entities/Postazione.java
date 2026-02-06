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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    @Column(name = "id_postazione")
    private Long idPostazione;
    
    @Column(name = "codice_univoco", nullable = false)
    private UUID cu;
    @Enumerated(EnumType.STRING)
    private TipoPostazione tipo;
    private String descrizione;
    private int num_max_occupanti;
    @ManyToOne
    @JoinColumn(name = "id_edificio", nullable = false)
    private Edificio edificio;

    public Postazione(UUID cu, TipoPostazione tipo, String descrizione, int num_max_occupanti, Edificio edificio) {
        this.cu = cu;
        this.tipo = tipo;
        this.descrizione = descrizione;
        this.num_max_occupanti = num_max_occupanti;
        this.edificio = edificio;
    }
}
