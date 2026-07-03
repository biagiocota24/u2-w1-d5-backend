package biagio_cota.services;

import biagio_cota.entities.Postazione;
import biagio_cota.entities.Utente;
import biagio_cota.repositories.PostazioneRepository;
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

    public List<Postazione> getAllAndShow() {
        List<Postazione> postazioni = postazioneRepository.findAll();
        if (!postazioni.isEmpty()) {
            System.out.println("------POSTAZIONI-------");
            postazioni.forEach(postazione -> postazione.showPostazione());
        }
        return postazioni;
    }
}
