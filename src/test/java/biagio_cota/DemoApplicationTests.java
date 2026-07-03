package biagio_cota;

import biagio_cota.entities.Edificio;
import biagio_cota.entities.Postazione;
import biagio_cota.entities.Prenotazione;
import biagio_cota.entities.Utente;
import biagio_cota.enums.TipoPostazione;
import biagio_cota.repositories.EdificioRepository;
import biagio_cota.repositories.PostazioneRepository;
import biagio_cota.repositories.UtenteRepository;
import biagio_cota.services.PrenotazioneService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class DemoApplicationTests {

    @Autowired
    private PrenotazioneService prenotazioneService;

    @Autowired
    private EdificioRepository edificioRepository;

    @Autowired
    private PostazioneRepository postazioneRepository;

    @Autowired
    private UtenteRepository utenteRepository;

    private Utente biagio;
    private Utente giulia;
    private Postazione bariVistaMare;
    private LocalDate dataEvento;

    @BeforeEach
    void setUp() {
        // ---- Creazione e salvataggio preliminare delle entità referenziate ----
        biagio = utenteRepository.save(new Utente("biagio.cota", "Biagio Cota", "biagio.cota@example.com"));
        giulia = utenteRepository.save(new Utente("giulia.rossi", "Giulia Rossi", "giulia.rossi@example.com"));

        Edificio sedeBari = edificioRepository.save(new Edificio("Sede Bari Centro", "Via Sparano 12", "Bari"));

        bariVistaMare = postazioneRepository.save(
                new Postazione("Ufficio singolo vista mare", TipoPostazione.PRIVATO, 1, sedeBari)
        );

        dataEvento = LocalDate.of(2026, 8, 12);
    }

    @Test
    void verificaBloccoPrenotazioniSovrapposte() {
        Prenotazione prima = prenotazioneService.prenota(biagio, bariVistaMare, dataEvento);
        Prenotazione seconda = prenotazioneService.prenota(giulia, bariVistaMare, dataEvento);
        assertEquals(null, seconda);
    }

    @Test
    void verificaEliminazione() {
        Prenotazione prenotazione = prenotazioneService.prenota(biagio, bariVistaMare, dataEvento);
        prenotazioneService.deleteById(prenotazione.getId());
        assertThrows(RuntimeException.class, () -> prenotazioneService.getById(prenotazione.getId()));
    }

    @ParameterizedTest
    @CsvSource({
            "2026-07-02, true",
            "2026-07-21, false"
    })
    void verificaScadenza(LocalDate data, boolean atteso) {
        Prenotazione prenotazione = prenotazioneService.prenota(biagio, bariVistaMare, dataEvento);
        prenotazione.setDataEvento(data);
        assertEquals(atteso, prenotazione.isExpired());
    }
}