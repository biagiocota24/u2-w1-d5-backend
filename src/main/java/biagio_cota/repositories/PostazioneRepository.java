package biagio_cota.repositories;

import biagio_cota.entities.Postazione;
import biagio_cota.enums.TipoPostazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PostazioneRepository extends JpaRepository<Postazione, UUID> {

    @Query("SELECT p FROM Postazione p WHERE p.tipoPostazione = :tipo")
    List<Postazione> getPostazioniByType(@Param("tipo") TipoPostazione tipo);

    @Query("SELECT p FROM Postazione p WHERE LOWER(p.edificio.citta) LIKE LOWER(CONCAT('%', :citta, '%'))")
    List<Postazione> getPostazioniByCityIgnoreCase(@Param("citta") String citta);
}
