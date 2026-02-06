package projectu2w1d5.bettapcq.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "edifici")
@NoArgsConstructor
@Setter
@Getter
@ToString
public class Edificio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Setter(AccessLevel.NONE)
    private Long id_edificio;

    private String nome;
    private String indirizzo;
    private String città;

    public Edificio(String nome, String indirizzo, String città) {
        this.nome = nome;
        this.indirizzo = indirizzo;
        this.città = città;
    }
}
