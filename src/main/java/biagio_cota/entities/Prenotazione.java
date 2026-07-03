package biagio_cota.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "Prenotazioni")
@Getter
@Setter
@NoArgsConstructor
public class Prenotazione {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "id_utente")
    private Utente utente;

    @ManyToOne
    @JoinColumn(name = "id_postazione")
    private Postazione postazione;

    @Column(nullable = false, name = "data_prenotazione")
    private LocalDate dataPrenotazione;

    @Column(name = "data_evento", nullable = false)
    private LocalDate dataEvento;

    @Column(name = "numero_partecipanti")
    private int numPartecipanti;

    public Prenotazione(Utente utente, Postazione postazione, LocalDate dataEvento, int numPartecipanti) {
        this.utente = utente;
        this.postazione = postazione;
        this.dataPrenotazione = LocalDate.now();
        this.dataEvento = dataEvento;
        this.numPartecipanti = numPartecipanti;
    }

    public boolean isExpired() {
        return LocalDate.now().isAfter(this.dataEvento);
    }

    public void showPrenotazione() {
        System.out.println("Id prenotazione : " + this.id);
        System.out.println("Prenotato da: " + this.utente.getUserName());
        System.out.println("Postazione: " + this.postazione.getEdificio() + "/" + this.postazione.getEdificio().getIndirizzo());
        System.out.println("Tipologia evento: " + this.postazione.getTipoPostazione());
        System.out.println("Data prenotazione: " + this.dataPrenotazione);
        System.out.println("Data evento: " + this.dataEvento);
    }
}
