package projectu2w1d5.bettapcq.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "utenti")
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Utente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    @Column(name = "id_utente")
    private Long idUtente;
    @Column(nullable = false)
    private String username;
    private String nome_completo;
    @Column(nullable = false)
    private String email;

    public Utente(String username, String nome_completo, String email) {
        this.username = username;
        this.nome_completo = nome_completo;
        this.email = email;
    }
}
