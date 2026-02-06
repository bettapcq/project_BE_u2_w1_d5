package projectu2w1d5.bettapcq.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import projectu2w1d5.bettapcq.entities.Edificio;

@Repository
public interface EdificiRepository extends JpaRepository<Edificio, Long> {
    boolean existsByNome(String nome);

}
