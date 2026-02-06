package projectu2w1d5.bettapcq.runners;

import com.github.javafaker.Faker;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import projectu2w1d5.bettapcq.entities.Utente;
import projectu2w1d5.bettapcq.services.EdificiService;
import projectu2w1d5.bettapcq.services.UtentiService;

import java.util.Locale;

@Component
public class Runner implements CommandLineRunner {

    private final EdificiService edificiService;
    private final UtentiService utentiService;

    public Runner(EdificiService edificiService, UtentiService utentiService) {
        this.edificiService = edificiService;
        this.utentiService = utentiService;
    }

    @Override
    public void run(String... args) throws Exception {
        Faker faker = new Faker(Locale.ITALY);
        //run più volte per creare più edifici:
//        Edificio edificio = new Edificio(faker.funnyName().name(), (faker.address().streetName() + faker.number().numberBetween(1, 900)), faker.address().cityName());
//        edificiService.addEdificio(edificio);

        //run pù volte per creare utenti:
        Utente utente = new Utente(faker.pokemon().name(), faker.name().fullName(), faker.internet().emailAddress());
        utentiService.addUtente(utente);
    }
}

