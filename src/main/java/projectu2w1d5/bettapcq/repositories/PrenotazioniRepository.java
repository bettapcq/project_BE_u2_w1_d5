package projectu2w1d5.bettapcq.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projectu2w1d5.bettapcq.entities.Postazione;
import projectu2w1d5.bettapcq.entities.Prenotazione;

import java.time.LocalDate;

@Repository
public interface PrenotazioniRepository extends JpaRepository<Prenotazione, Long> {
    boolean existsByDataAndPostazione(LocalDate data, Postazione postazione);

}
