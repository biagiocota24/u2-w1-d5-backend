package biagio_cota.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "Edifici")
@NoArgsConstructor
@Getter
@Setter
public class Edificio {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false , unique = true)
    private String nome;

    @Column(nullable = false)
    private String indirizzo;

    @Column(nullable = false)
    private String citta;

    public Edificio(String nome, String indirizzo, String citta) {
        this.nome = nome;
        this.indirizzo = indirizzo;
        this.citta = citta;
    }

    public void showEdificio() {
        System.out.println("Edificio: " + this.nome
                + " | Indirizzo: " + this.indirizzo
                + ", " + this.citta
                + " | ID: " + this.id);
    }
}
