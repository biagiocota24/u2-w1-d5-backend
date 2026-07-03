package biagio_cota.entities;

import biagio_cota.enums.TipoPostazione;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;
import java.util.UUID;

@Entity
@Table(name = "Postazioni")
@Getter
@Setter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Postazione {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false)
    private String descrizione;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private TipoPostazione tipoPostazione;

    @Column(nullable = false, name = "massima_capacità")
    private int maxCapacitaPers;

    @ManyToOne
    @JoinColumn(name = "id_edificio", nullable = false)
    private Edificio edificio;

    public Postazione(String descrizione, TipoPostazione tipoPostazione, int maxCapacitaPers, Edificio edificio) {
        this.descrizione = descrizione;
        this.tipoPostazione = tipoPostazione;
        this.maxCapacitaPers = maxCapacitaPers;
        this.edificio = edificio;
    }

    public void showPostazione() {
        System.out.println("Postazione: " + this.descrizione
                + " | Tipo: " + this.tipoPostazione
                + " | Capacità max: " + this.maxCapacitaPers + " persone"
                + " | Edificio: " + this.edificio.getNome()
                + " | ID: " + this.id);
    }

}
