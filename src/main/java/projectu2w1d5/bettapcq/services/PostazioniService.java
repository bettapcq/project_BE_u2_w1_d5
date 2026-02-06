package projectu2w1d5.bettapcq.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import projectu2w1d5.bettapcq.entities.Edificio;
import projectu2w1d5.bettapcq.entities.Postazione;
import projectu2w1d5.bettapcq.entities.TipoPostazione;
import projectu2w1d5.bettapcq.exceptions.NotFoundException;
import projectu2w1d5.bettapcq.exceptions.ValidationException;
import projectu2w1d5.bettapcq.repositories.PostazioniRepository;
import projectu2w1d5.bettapcq.repositories.PrenotazioniRepository;

import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class PostazioniService {

    private final PostazioniRepository postazioniRepository;
    private final EdificiService edificiService;
    private final PrenotazioniRepository prenotazioniRepository;

    public PostazioniService(PostazioniRepository postazioniRepository, EdificiService edificiService, PrenotazioniRepository prenotazioniRepository) {
        this.postazioniRepository = postazioniRepository;
        this.edificiService = edificiService;
        this.prenotazioniRepository = prenotazioniRepository;
    }

    public void addPostazione(long idEdificio, UUID cuPostazione, TipoPostazione tipo, String descrizione, int num_max_occupanti) {
        //1. check edificio esistente:
        Edificio edificioFromDb = this.edificiService.findById(idEdificio);
        if (edificioFromDb == null)
            throw new ValidationException("L'edificio con id: " + idEdificio + " non esiste");
        Postazione nuovaPostazione = new Postazione(cuPostazione, tipo, descrizione, num_max_occupanti, edificioFromDb);

        this.postazioniRepository.save(nuovaPostazione);
        log.info("La postazione è stata salvata con id: " + nuovaPostazione.getIdPostazione());
    }

    public Postazione findById(long idPostazione) {

        return postazioniRepository.findById(idPostazione).orElseThrow(() -> new NotFoundException("Postazione non trovata"));
    }

    public List<Postazione> findByTipoAndCittà(TipoPostazione tipo, String città) {
        return postazioniRepository.findByTipoAndCittà(tipo, città);

    }
}
