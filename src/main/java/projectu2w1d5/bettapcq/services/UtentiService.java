package projectu2w1d5.bettapcq.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import projectu2w1d5.bettapcq.entities.Utente;
import projectu2w1d5.bettapcq.exceptions.NotFoundException;
import projectu2w1d5.bettapcq.exceptions.ValidationException;
import projectu2w1d5.bettapcq.repositories.UtentiRepository;

@Service
@Slf4j
public class UtentiService {
    private final UtentiRepository utentiRepository;

    public UtentiService(UtentiRepository utentiRepository) {
        this.utentiRepository = utentiRepository;
    }

    public void addUtente(Utente nuovoUtente) {
        //1. check nome già in uso
        if (utentiRepository.existsByUsername(nuovoUtente.getUsername()))
            throw new ValidationException("L'utente " + nuovoUtente.getUsername() + " è già esistente");
        this.utentiRepository.save(nuovoUtente);
        log.info("L'edificio è stato salvato con id: " + nuovoUtente.getIdUtente());
    }

    public Utente findById(Long idUtente) {
        return utentiRepository.findById(idUtente).orElseThrow(() -> new NotFoundException("Utente non trovato"));
    }
}
