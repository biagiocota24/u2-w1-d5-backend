package biagio_cota.repositories;

import biagio_cota.entities.Edificio;
import biagio_cota.entities.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UtenteRepository extends JpaRepository<Utente, UUID> {
    Utente findByUserName(String userName);
}
