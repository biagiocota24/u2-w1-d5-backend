package biagio_cota.services;

import biagio_cota.entities.Edificio;
import biagio_cota.entities.Utente;
import biagio_cota.repositories.EdificioRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EdificioService {
    private EdificioRepository edificioRepository;

    public EdificioService(EdificioRepository edificioRepository) {
        this.edificioRepository = edificioRepository;
    }

    public void save(Edificio edificio) {
        edificioRepository.save(edificio);
    }

    public void saveAll(List<Edificio> lista) {
        edificioRepository.saveAll(lista);
    }

    public List<Edificio> getAllAndShow() {
        List<Edificio> edifici = edificioRepository.findAll();
        if (!edifici.isEmpty()) {
            System.out.println("------EDIFICI-------");
            edifici.forEach(edificio -> edificio.showEdificio());
        }
        return edifici;
    }

    public Edificio getEdicicio(String nome) {
        try {
            return edificioRepository.findByNome(nome);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }


}
