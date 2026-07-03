package biagio_cota.services;

import biagio_cota.entities.Postazione;
import biagio_cota.entities.Utente;
import biagio_cota.enums.TipoPostazione;
import biagio_cota.repositories.PostazioneRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PostazioneService {
    private PostazioneRepository postazioneRepository;

    public PostazioneService(PostazioneRepository postazioneRepository) {
        this.postazioneRepository = postazioneRepository;
    }

    public void save(Postazione postazione) {
        postazioneRepository.save(postazione);
    }

    public void saveAll(List<Postazione> lista) {
        postazioneRepository.saveAll(lista);
    }

    public Postazione getPostazioneById(String id) {
        return postazioneRepository.findById(UUID.fromString(id)).orElseThrow(() -> new RuntimeException("Postazione non trovata!"));
    }

    public List<Postazione> getPostazioniByType(TipoPostazione tipoPostazione) {
        List<Postazione> postazioniTrovate = postazioneRepository.getPostazioniByType(tipoPostazione);
        if (postazioniTrovate.isEmpty()) {
            System.out.println("Non è stato possibile trovare alcuna postazione di questo tipo");
        } else {
            System.out.println("---------------POSTAZIONI TROVATE----------------");
            postazioniTrovate.forEach(postazione -> postazione.showPostazione());
        }
        return postazioniTrovate;
    }

    public List<Postazione> getPostazioniByCitY(String city) {
        List<Postazione> postazioniTrovate = postazioneRepository.getPostazioniByCityIgnoreCase(city);
        if (postazioniTrovate.isEmpty()) {
            System.out.println("Non è stato possibile trovare alcuna postazione in questa citta");
        } else {
            System.out.println("---------------POSTAZIONI TROVATE----------------");
            postazioniTrovate.forEach(postazione -> postazione.showPostazione());
        }
        return postazioniTrovate;
    }

    public List<Postazione> getAllAndShow() {
        List<Postazione> postazioni = postazioneRepository.findAll();
        if (!postazioni.isEmpty()) {
            System.out.println("------POSTAZIONI-------");
            postazioni.forEach(postazione -> postazione.showPostazione());
        }
        return postazioni;
    }
}
