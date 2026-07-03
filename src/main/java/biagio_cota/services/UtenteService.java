package biagio_cota.services;

import biagio_cota.entities.Postazione;
import biagio_cota.entities.Prenotazione;
import biagio_cota.entities.Utente;
import biagio_cota.repositories.UtenteRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class UtenteService {
    private UtenteRepository utenteRepository;

    public UtenteService(UtenteRepository utenteRepository) {
        this.utenteRepository = utenteRepository;
    }

    public void save(Utente utente) {
        utenteRepository.save(utente);
    }

    public void saveAll(List<Utente> lista) {
        utenteRepository.saveAll(lista);
    }

    public Utente getUtenteByUserName(String username) {
        return utenteRepository.findByUserName(username);
    }

    public List<Utente> getAllAndshow() {
        List<Utente> utenti = utenteRepository.findAll();
        if (!utenti.isEmpty()) {
            System.out.println("------UTENTI-------");
            utenti.forEach(utente -> utente.showUtente());
        }
        return utenti;
    }
}
