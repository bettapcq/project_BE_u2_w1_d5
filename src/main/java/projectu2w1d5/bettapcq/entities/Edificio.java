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
    @Column(name = "id_edificio")
    private Long idEdificio;

    private String nome;
    private String indirizzo;
    private String città;

    public Edificio(String nome, String indirizzo, String città) {
        this.nome = nome;
        this.indirizzo = indirizzo;
        this.città = città;
    }
}
