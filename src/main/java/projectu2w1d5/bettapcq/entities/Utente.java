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
    private Long id_utente;
    @Column(nullable = false)
    private String username;
    private String nome_completo;
    @Column(nullable = false)
    private String email;


}
