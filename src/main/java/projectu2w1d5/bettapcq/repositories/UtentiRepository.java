package projectu2w1d5.bettapcq.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projectu2w1d5.bettapcq.entities.Utente;

@Repository
public interface UtentiRepository extends JpaRepository<Utente, Long> {
    boolean existsByUsername(String username);
}
