package projectu2w1d5.bettapcq.entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "prenotazioni")
@NoArgsConstructor
@ToString
@Getter
@Setter
public class Prenotazione {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    @Column(name = "id_prenotazione")
    private Long idPrenotazione;
    @ManyToOne
    @JoinColumn(name = "id_utente")
    private Utente utente;

    @ManyToOne
    @JoinColumn(name = "uuid_postazione")
    private Postazione postazione;

    private LocalDate data;


    public Prenotazione(Utente utente, Postazione postazione, LocalDate data) {
        this.utente = utente;
        this.postazione = postazione;
        this.data = data;
    }
}
