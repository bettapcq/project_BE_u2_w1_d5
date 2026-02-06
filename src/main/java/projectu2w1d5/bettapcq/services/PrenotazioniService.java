package projectu2w1d5.bettapcq.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import projectu2w1d5.bettapcq.entities.Postazione;
import projectu2w1d5.bettapcq.entities.Prenotazione;
import projectu2w1d5.bettapcq.entities.Utente;
import projectu2w1d5.bettapcq.exceptions.NotAvailablePlaceException;
import projectu2w1d5.bettapcq.exceptions.NotFoundException;
import projectu2w1d5.bettapcq.repositories.PrenotazioniRepository;

import java.time.LocalDate;

@Service
@Slf4j
public class PrenotazioniService {

    private final PrenotazioniRepository prenotazioniRepository;
    private final PostazioniService postazioniService;
    private final UtentiService utentiService;

    public PrenotazioniService(PrenotazioniRepository prenotazioniRepository, PostazioniService postazioniService, UtentiService utentiService) {
        this.prenotazioniRepository = prenotazioniRepository;
        this.postazioniService = postazioniService;
        this.utentiService = utentiService;
    }

    public void addPrenotazione(Long idUtente, Long idPostazione, LocalDate data) {

        //check utente e postazione in DB:
        Utente utenteFromDB = utentiService.findById(idUtente);
        Postazione postazioneFromDB = postazioniService.findById(idPostazione);
        if (utenteFromDB == null) throw new NotFoundException("Utente non trovato");
        if (postazioneFromDB == null) throw new NotFoundException("Postazione non trovata");

        //check postazione già occupata in quella data:
        boolean occupata = prenotazioniRepository.existsByDataAndPostazione(data, postazioneFromDB);
        if (occupata) throw new NotAvailablePlaceException(idPostazione, data);

        //Prenotazione(Utente utente, Postazione postazione, LocalDate data)
        Prenotazione nuovaPrenotazione = new Prenotazione(utenteFromDB, postazioneFromDB, data);


        prenotazioniRepository.save(nuovaPrenotazione);

        log.info("Prenotazione salvata con id: " + nuovaPrenotazione.getIdPrenotazione());
    }

    public boolean existingByDataAndPostazione(LocalDate data, Postazione postazione) {
        return prenotazioniRepository.existsByDataAndPostazione(data, postazione);
    }


}
