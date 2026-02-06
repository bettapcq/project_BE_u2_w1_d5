package projectu2w1d5.bettapcq.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projectu2w1d5.bettapcq.entities.Edificio;
import projectu2w1d5.bettapcq.exceptions.NotFoundException;
import projectu2w1d5.bettapcq.exceptions.ValidationException;
import projectu2w1d5.bettapcq.repositories.EdificiRepository;

@Service
@Slf4j
public class EdificiService {
    private final EdificiRepository edificiRepository;

    @Autowired
    public EdificiService(EdificiRepository edificiRepository) {
        this.edificiRepository = edificiRepository;
    }

    public void addEdificio(Edificio nuovoEdificio) {
        //1. check nome già in uso
        if (edificiRepository.existsByNome(nuovoEdificio.getNome()))
            throw new ValidationException("L'edificio " + nuovoEdificio.getNome() + " è già esistente");
        this.edificiRepository.save(nuovoEdificio);
        log.info("L'edificio è stato salvato con id: " + nuovoEdificio.getIdEdificio());
    }

    public Edificio findById(long idEdificio) {

        return edificiRepository.findById(idEdificio).orElseThrow(() -> new NotFoundException("Edificio non trovato"));
    }
}
