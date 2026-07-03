package biagio_cota.services;

import biagio_cota.entities.Postazione;
import biagio_cota.entities.Prenotazione;
import biagio_cota.entities.Utente;
import biagio_cota.repositories.PrenotazioneRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PrenotazioneService {
    private PrenotazioneRepository prenotazioneRepository;

    public PrenotazioneService(PrenotazioneRepository prenotazioneRepository) {
        this.prenotazioneRepository = prenotazioneRepository;
    }

    public void save(Prenotazione prenotazione) {
        prenotazioneRepository.save(prenotazione);
    }

    public void saveAll(List<Prenotazione> lista) {
        prenotazioneRepository.saveAll(lista);
    }

    public Prenotazione getById(UUID id) {
        return prenotazioneRepository.findById(id).orElseThrow(() -> new RuntimeException("Prenotazione non trovata"));
    }

    public List<Prenotazione> getbyDataEvento(LocalDate dataevento) {
        return prenotazioneRepository.findByDataEvento(dataevento);
    }

    public Prenotazione prenota(Utente utente, Postazione postazione, LocalDate dataEvento, int numPartecipanti) {
        List<Prenotazione> prenotazioniInQuellaData = prenotazioneRepository.findByDataEvento(dataEvento);
        boolean occupata = prenotazioniInQuellaData.stream().anyMatch(prenotazione -> prenotazione.getPostazione().equals(postazione));
        if (occupata) {
            System.out.println("La postazione è per questa data gia prenotata!");
            return null;
        }
        if (numPartecipanti > postazione.getMaxCapacitaPers()) {
            System.out.println("La postazione non puo contenere cosi tanti ospiti!");
            return null;
        }
        Prenotazione nuovaprenotazione = new Prenotazione(utente, postazione, dataEvento, numPartecipanti);
        prenotazioneRepository.save(nuovaprenotazione);
        System.out.println("-------PRENOTAZIONE SALVATA----------");
        nuovaprenotazione.showPrenotazione();
        return nuovaprenotazione;
    }

    public List<Prenotazione> getAllAndShow() {
        List<Prenotazione> prenotazioni = prenotazioneRepository.findAll();
        if (!prenotazioni.isEmpty()) {
            System.out.println("------PRENOTAZIONI-------");
            prenotazioni.forEach(prenotazione -> prenotazione.showPrenotazione());
        }
        return prenotazioni;
    }

    public void deleteById(UUID id) {
        Optional<Prenotazione> fromdb = prenotazioneRepository.findById(id);
        if (fromdb.isPresent()) {
            prenotazioneRepository.delete(fromdb.get());
        } else {
            System.out.println("Prenotazione non trovata!");
        }
    }
}
