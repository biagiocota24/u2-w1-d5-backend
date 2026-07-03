package biagio_cota.repositories;

import biagio_cota.entities.Edificio;
import biagio_cota.entities.Prenotazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Repository
public interface PrenotazioneRepository extends JpaRepository<Prenotazione, UUID> {
    List<Prenotazione> findByDataEvento(LocalDate dataEvento);
}
