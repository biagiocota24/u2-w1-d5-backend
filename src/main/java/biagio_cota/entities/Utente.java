package biagio_cota.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Table(name = "Utenti")
@NoArgsConstructor
@Getter
@Setter
public class Utente {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(nullable = false, unique = true)
    @Setter(AccessLevel.NONE)
    private String userName;

    @Column(name = "Nome_e_cognome", nullable = false)
    private String nomeCompleto;

    @Column(name = "email", nullable = false)
    @Email(message = "Formato email non valido!")
    @NotBlank(message = "Devi inserire un indirizzo mail!")
    private String email;

    public Utente(String userName, String nomeCompleto, String email) {
        this.userName = userName;
        this.nomeCompleto = nomeCompleto;
        this.email = email;
    }

    public void showUtente() {
        System.out.println("Utente: " + this.nomeCompleto
                + " | Username: " + this.userName
                + " | Email: " + this.email
                + " | ID: " + this.id);
    }
}
