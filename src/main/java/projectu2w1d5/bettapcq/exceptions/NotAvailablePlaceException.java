package projectu2w1d5.bettapcq.exceptions;

import java.time.LocalDate;

public class NotAvailablePlaceException extends RuntimeException {
    public NotAvailablePlaceException(Long id, LocalDate data) {
        super("La postazione con id " + id + " non è disponibile il giorno " + data);
    }
}
