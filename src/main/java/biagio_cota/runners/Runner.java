package biagio_cota.runners;

import biagio_cota.entities.Edificio;
import biagio_cota.entities.Postazione;
import biagio_cota.entities.Prenotazione;
import biagio_cota.entities.Utente;
import biagio_cota.enums.TipoPostazione;
import biagio_cota.repositories.UtenteRepository;
import biagio_cota.services.EdificioService;
import biagio_cota.services.PostazioneService;
import biagio_cota.services.PrenotazioneService;
import biagio_cota.services.UtenteService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Component
public class Runner implements CommandLineRunner {

    private UtenteService utenteService;
    private EdificioService edificioService;
    private PostazioneService postazioneService;
    private PrenotazioneService prenotazioneService;

    public Runner(UtenteService utenteService, EdificioService edificioService, PostazioneService postazioneService, PrenotazioneService prenotazioneService) {
        this.utenteService = utenteService;
        this.edificioService = edificioService;
        this.postazioneService = postazioneService;
        this.prenotazioneService = prenotazioneService;
    }

    @Override
    public void run(String... args) throws Exception {
//        // ---- Edifici ----
//        Edificio sedeBari = new Edificio("Sede Bari Centro", "Via Sparano 12", "Bari");
//        Edificio sedeMilano = new Edificio("Sede Milano Porta Nuova", "Via Melchiorre Gioia 8", "Milano");
//        Edificio sedeRoma = new Edificio("Sede Roma EUR", "Viale Europa 190", "Roma");
////
//        List<Edificio> edifici = List.of(sedeBari, sedeMilano, sedeRoma);
//        edificioService.saveAll(edifici);
////
////        // ---- Postazioni ----
//        Postazione postoBari1 = new Postazione("Ufficio singolo vista mare", TipoPostazione.PRIVATO, 1, sedeBari);
//        Postazione postoBari2 = new Postazione("Open space piano terra", TipoPostazione.OPENSPACE, 20, sedeBari);
//        Postazione postoBari3 = new Postazione("Sala riunioni Adriatico", TipoPostazione.SALA_RIUNIONI, 8, sedeBari);
//
//        Postazione postoMilano1 = new Postazione("Ufficio privato executive", TipoPostazione.PRIVATO, 1, sedeMilano);
//        Postazione postoMilano2 = new Postazione("Open space coworking", TipoPostazione.OPENSPACE, 35, sedeMilano);
//        Postazione postoMilano3 = new Postazione("Sala riunioni Duomo", TipoPostazione.SALA_RIUNIONI, 12, sedeMilano);
//
//        Postazione postoRoma2 = new Postazione("Open space open floor", TipoPostazione.OPENSPACE, 25, sedeRoma);
//        Postazione postoRoma1 = new Postazione("Ufficio privato dirigenza", TipoPostazione.PRIVATO, 2, sedeRoma);
//
//        List<Postazione> postazioni = List.of(
//                postoBari1, postoBari2, postoBari3,
//                postoMilano1, postoMilano2, postoMilano3,
//                postoRoma1, postoRoma2
//        );
//        postazioneService.saveAll(postazioni);
////
////        // ---- Utenti ----
//        Utente utente1 = new Utente("biagio.cota", "Biagio Cota", "biagio.cota@example.com");
//        Utente utente2 = new Utente("giulia.rossi", "Giulia Rossi", "giulia.rossi@example.com");
//        Utente utente3 = new Utente("marco.bianchi", "Marco Bianchi", "marco.bianchi@example.com");
//        Utente utente4 = new Utente("anna.verdi", "Anna Verdi", "anna.verdi@example.com");
//        Utente utente5 = new Utente("luca.ferrari", "Luca Ferrari", "luca.ferrari@example.com");
//
//        List<Utente> utenti = List.of(utente1, utente2, utente3, utente4, utente5);
//        utenteService.saveAll(utenti);
//
//        System.out.println("Dati di esempio caricati: " + edifici.size() + " edifici, "
//                + postazioni.size() + " postazioni, " + utenti.size() + " utenti.");

        utenteService.getAllAndshow();
        edificioService.getAllAndShow();
        postazioneService.getAllAndShow();
//
        Edificio sedeBari = edificioService.getEdicicio("Sede Bari Centro");
        Edificio sedeRoma = edificioService.getEdicicio("Sede Roma EUR");
        Edificio sedeMilano = edificioService.getEdicicio("Sede Milano Porta Nuova");

        Postazione bariVistaMare = postazioneService.getPostazioneById("6bab668d-f1d6-4e11-aaaa-965b0978e2a0");
        Postazione bariPianoTerra = postazioneService.getPostazioneById("6ee65f0c-61c4-4ba1-a483-808daa07895c");
        Postazione bariSalaAdriatico = postazioneService.getPostazioneById("95fbe429-0fc0-47ad-a8fb-97c0de2d4c29");
        Postazione milanoUfficio = postazioneService.getPostazioneById("4cba2b45-8a24-43e2-83d2-febdfc3a201a");
        Postazione milanoOpenSpace = postazioneService.getPostazioneById("ce092bf6-701a-43b2-90d9-543adc9888b2");
        Postazione milanoDuomo = postazioneService.getPostazioneById("8049c9e1-2860-40ad-9832-68665e70bfd8");
        Postazione romauffcio = postazioneService.getPostazioneById("9de04337-d6e4-4843-95c2-f90c9c484eb9");
        Postazione romapenSpace = postazioneService.getPostazioneById("0e83dd93-4bfb-4e08-815c-7a4a819b0fdc");

        Utente biagio = utenteService.getUtenteByUserName("biagio.cota");
        Utente giulia = utenteService.getUtenteByUserName("giulia.rossi");
        Utente marco = utenteService.getUtenteByUserName("marco.bianchi");
        Utente anna = utenteService.getUtenteByUserName("anna.verdi");
        Utente luca = utenteService.getUtenteByUserName("luca.ferrari");

//        prenotazioneService.prenota(biagio, bariVistaMare, LocalDate.of(2026, 8, 12), 1);
//        prenotazioneService.prenota(giulia, bariVistaMare, LocalDate.of(2026, 8, 12), 1);
//
//// ---- 40 prenotazioni con combinazioni distinte ----
//        prenotazioneService.prenota(biagio, bariVistaMare, LocalDate.of(2026, 8, 1), 1);
//        prenotazioneService.prenota(giulia, bariVistaMare, LocalDate.of(2026, 8, 2), 1);
//        prenotazioneService.prenota(marco, bariVistaMare, LocalDate.of(2026, 8, 3), 1);
//        prenotazioneService.prenota(anna, bariVistaMare, LocalDate.of(2026, 8, 4), 1);
//        prenotazioneService.prenota(luca, bariVistaMare, LocalDate.of(2026, 8, 5), 1);
//
//        prenotazioneService.prenota(biagio, bariPianoTerra, LocalDate.of(2026, 8, 1), 10);
//        prenotazioneService.prenota(giulia, bariPianoTerra, LocalDate.of(2026, 8, 2), 15);
//        prenotazioneService.prenota(marco, bariPianoTerra, LocalDate.of(2026, 8, 3), 8);
//        prenotazioneService.prenota(anna, bariPianoTerra, LocalDate.of(2026, 8, 4), 20);
//        prenotazioneService.prenota(luca, bariPianoTerra, LocalDate.of(2026, 8, 5), 5);
//
//        prenotazioneService.prenota(biagio, bariSalaAdriatico, LocalDate.of(2026, 8, 6), 6);
//        prenotazioneService.prenota(giulia, bariSalaAdriatico, LocalDate.of(2026, 8, 7), 8);
//        prenotazioneService.prenota(marco, bariSalaAdriatico, LocalDate.of(2026, 8, 8), 4);
//        prenotazioneService.prenota(anna, bariSalaAdriatico, LocalDate.of(2026, 8, 9), 7);
//        prenotazioneService.prenota(luca, bariSalaAdriatico, LocalDate.of(2026, 8, 10), 2);
//
//        prenotazioneService.prenota(biagio, milanoUfficio, LocalDate.of(2026, 8, 11), 1);
//        prenotazioneService.prenota(giulia, milanoUfficio, LocalDate.of(2026, 8, 12), 1);
//        prenotazioneService.prenota(marco, milanoUfficio, LocalDate.of(2026, 8, 13), 1);
//        prenotazioneService.prenota(anna, milanoUfficio, LocalDate.of(2026, 8, 14), 1);
//        prenotazioneService.prenota(luca, milanoUfficio, LocalDate.of(2026, 8, 15), 1);
//
//        prenotazioneService.prenota(biagio, milanoOpenSpace, LocalDate.of(2026, 8, 11), 20);
//        prenotazioneService.prenota(giulia, milanoOpenSpace, LocalDate.of(2026, 8, 12), 30);
//        prenotazioneService.prenota(marco, milanoOpenSpace, LocalDate.of(2026, 8, 13), 15);
//        prenotazioneService.prenota(anna, milanoOpenSpace, LocalDate.of(2026, 8, 14), 35);
//        prenotazioneService.prenota(luca, milanoOpenSpace, LocalDate.of(2026, 8, 15), 25);
//
//        prenotazioneService.prenota(biagio, milanoDuomo, LocalDate.of(2026, 8, 16), 10);
//        prenotazioneService.prenota(giulia, milanoDuomo, LocalDate.of(2026, 8, 17), 12);
//        prenotazioneService.prenota(marco, milanoDuomo, LocalDate.of(2026, 8, 18), 6);
//        prenotazioneService.prenota(anna, milanoDuomo, LocalDate.of(2026, 8, 19), 9);
//        prenotazioneService.prenota(luca, milanoDuomo, LocalDate.of(2026, 8, 20), 4);
//
//        prenotazioneService.prenota(biagio, romauffcio, LocalDate.of(2026, 8, 21), 2);
//        prenotazioneService.prenota(giulia, romauffcio, LocalDate.of(2026, 8, 22), 1);
//        prenotazioneService.prenota(marco, romauffcio, LocalDate.of(2026, 8, 23), 2);
//        prenotazioneService.prenota(anna, romauffcio, LocalDate.of(2026, 8, 24), 1);
//        prenotazioneService.prenota(luca, romauffcio, LocalDate.of(2026, 8, 25), 2);
//
//        prenotazioneService.prenota(biagio, romapenSpace, LocalDate.of(2026, 8, 21), 15);
//        prenotazioneService.prenota(giulia, romapenSpace, LocalDate.of(2026, 8, 22), 20);
//        prenotazioneService.prenota(marco, romapenSpace, LocalDate.of(2026, 8, 23), 25);
//        prenotazioneService.prenota(anna, romapenSpace, LocalDate.of(2026, 8, 24), 10);
//        prenotazioneService.prenota(luca, romapenSpace, LocalDate.of(2026, 8, 25), 18);
//
//// ---- 10 prenotazioni con sovrapposizione intenzionale  ----
//        prenotazioneService.prenota(marco, bariVistaMare, LocalDate.of(2026, 8, 1), 1);
//        prenotazioneService.prenota(anna, bariPianoTerra, LocalDate.of(2026, 8, 3), 12);
//        prenotazioneService.prenota(luca, bariSalaAdriatico, LocalDate.of(2026, 8, 7), 5);
//        prenotazioneService.prenota(biagio, milanoUfficio, LocalDate.of(2026, 8, 13), 1);
//        prenotazioneService.prenota(giulia, milanoOpenSpace, LocalDate.of(2026, 8, 14), 28);
//        prenotazioneService.prenota(marco, milanoDuomo, LocalDate.of(2026, 8, 18), 7);
//        prenotazioneService.prenota(anna, romauffcio, LocalDate.of(2026, 8, 22), 2);
//        prenotazioneService.prenota(luca, romapenSpace, LocalDate.of(2026, 8, 24), 22);
//        prenotazioneService.prenota(biagio, bariVistaMare, LocalDate.of(2026, 8, 4), 1);
//        prenotazioneService.prenota(giulia, milanoUfficio, LocalDate.of(2026, 8, 15), 1);
//
//// ---- 10 prenotazioni che superano la capacità massima  ----
//        prenotazioneService.prenota(biagio, bariVistaMare, LocalDate.of(2026, 9, 1), 3);
//        prenotazioneService.prenota(giulia, milanoUfficio, LocalDate.of(2026, 9, 2), 4);
//        prenotazioneService.prenota(marco, romauffcio, LocalDate.of(2026, 9, 3), 6);
//        prenotazioneService.prenota(anna, bariSalaAdriatico, LocalDate.of(2026, 9, 4), 15);
//        prenotazioneService.prenota(luca, milanoDuomo, LocalDate.of(2026, 9, 5), 20);
//        prenotazioneService.prenota(biagio, bariPianoTerra, LocalDate.of(2026, 9, 6), 25);
//        prenotazioneService.prenota(giulia, romapenSpace, LocalDate.of(2026, 9, 7), 30);
//        prenotazioneService.prenota(marco, milanoOpenSpace, LocalDate.of(2026, 9, 8), 40);
//        prenotazioneService.prenota(anna, bariVistaMare, LocalDate.of(2026, 9, 9), 2);
//        Prenotazione p1 = prenotazioneService.prenota(luca, romauffcio, LocalDate.of(2026, 9, 10), 5);

//        //CERCA POSTAZIONE PER TIPOLOGIA
//        postazioneService.getPostazioniByType(TipoPostazione.PRIVATO);
//        postazioneService.getPostazioniByType(TipoPostazione.OPENSPACE);
//        postazioneService.getPostazioniByType(TipoPostazione.SALA_RIUNIONI);
//
//        //CERCA POSTAZIONE PER CITTA O PARTE DEL NOME DELLA CITTA
//        postazioneService.getPostazioniByCitY("b");

//        Prenotazione p1 = prenotazioneService.getById(UUID.fromString("943e5344-2606-4cca-bcdb-40ab9357c14e"));

        //RIMUOVE UNA PRENOTAZIONE
//        prenotazioneService.deleteById(UUID.fromString("sgdsfsdfds"));
    }
}
