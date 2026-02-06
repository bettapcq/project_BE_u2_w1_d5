package projectu2w1d5.bettapcq.runners;

import com.github.javafaker.Faker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import projectu2w1d5.bettapcq.exceptions.NotFoundException;
import projectu2w1d5.bettapcq.services.EdificiService;
import projectu2w1d5.bettapcq.services.PostazioniService;
import projectu2w1d5.bettapcq.services.PrenotazioniService;
import projectu2w1d5.bettapcq.services.UtentiService;

import java.util.Locale;

@Component
@Slf4j
public class Runner implements CommandLineRunner {

    private final EdificiService edificiService;
    private final UtentiService utentiService;
    private final PostazioniService postazioniService;
    private final PrenotazioniService prenotazioniService;

    public Runner(EdificiService edificiService, UtentiService utentiService, PostazioniService postazioniService, PrenotazioniService prenotazioniService) {
        this.edificiService = edificiService;
        this.utentiService = utentiService;
        this.postazioniService = postazioniService;
        this.prenotazioniService = prenotazioniService;
    }

    @Override
    public void run(String... args) throws Exception {
        Faker faker = new Faker(Locale.ITALY);
        //run più volte per creare più edifici:
//        Edificio edificio = new Edificio(faker.funnyName().name(), (faker.address().streetName() + faker.number().numberBetween(1, 900)), faker.address().cityName());
//        edificiService.addEdificio(edificio);

        //run pù volte per creare utenti:
//        Utente utente = new Utente(faker.pokemon().name(), faker.name().fullName(), faker.internet().emailAddress());
//        utentiService.addUtente(utente);

        //run pù volte per creare postazioni:
//        String uuid1 = UUID.randomUUID().toString();
//        String uuid2 = UUID.randomUUID().toString();
//        String uuid3 = UUID.randomUUID().toString();
//        postazioniService.addPostazione(faker.number().numberBetween(1, 7), UUID.fromString(uuid1), TipoPostazione.OPEN_SPACE, faker.lorem().characters(30), faker.number().numberBetween(1, 50));
//        postazioniService.addPostazione(faker.number().numberBetween(1, 7), UUID.fromString(uuid2), TipoPostazione.PRIVATO, faker.lorem().characters(30), faker.number().numberBetween(1, 4));
//        postazioniService.addPostazione(faker.number().numberBetween(1, 7), UUID.fromString(uuid3), TipoPostazione.SALA_RIUNIONI, faker.lorem().characters(30), faker.number().numberBetween(1, 20));

        try {
//       ok     Edificio edificioFromDB = edificiService.findById(3L);
//            log.info(edificioFromDB.toString());
//       ok    Utente utenteFromDB = utentiService.findById(3L);
//            log.info(utenteFromDB.toString());
//       ok     Postazione postazioneFromDB = postazioniService.findById(4L);
//            log.info(postazioneFromDB.toString());
//       ok     List<Postazione> listaPostazioniTipoCittà = postazioniService.findByTipoAndCittà(TipoPostazione.PRIVATO, "Barbieri umbro");
//            listaPostazioniTipoCittà.forEach(postazione -> log.info(postazione.toString()));


        } catch (NotFoundException ex) {
            log.error(ex.getMessage());

        }
    }
}

