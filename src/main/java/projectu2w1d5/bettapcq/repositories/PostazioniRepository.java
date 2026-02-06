package projectu2w1d5.bettapcq.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projectu2w1d5.bettapcq.entities.Postazione;

import java.util.UUID;

@Repository
public interface PostazioniRepository extends JpaRepository<Postazione, UUID> {
}
