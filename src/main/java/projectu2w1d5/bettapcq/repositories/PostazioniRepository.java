package projectu2w1d5.bettapcq.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import projectu2w1d5.bettapcq.entities.Postazione;
import projectu2w1d5.bettapcq.entities.TipoPostazione;

import java.util.List;
import java.util.UUID;

@Repository
public interface PostazioniRepository extends JpaRepository<Postazione, Long> {
    boolean existsByCu(UUID cu);


    // https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html

    @Query("SELECT p FROM Postazione p WHERE p.tipo = :tipo AND p.edificio.città = :città")
    List<Postazione> findByTipoAndCittà(TipoPostazione tipo, String città);

}
