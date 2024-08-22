package mirkoabozzi.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import mirkoabozzi.entities.Partecipation;
import mirkoabozzi.exceptions.NotFoundException;

public class PartecipationDAO { // buona prassi creare dei DAO per ogni tabella in modo da tener libero e più leggibile il main

    private final EntityManager em;

    public PartecipationDAO(EntityManager em) {  // obbligatorio un costruttore vuoto JPA lo utilizzerà per ricreare gli oggetti leggendo dal database
        this.em = em;
    }

    public void save(Partecipation Partecipation) {
        EntityTransaction transaction = em.getTransaction(); //richiedo la transazione
        transaction.begin(); // avvia la transazione
        em.persist(Partecipation); // aggiunge l'evento al persistence context
        transaction.commit(); // inviamo l'evento al database
        System.out.println(" " + Partecipation.getEvent() + " creato"); // stampo il titolo dell'evento in console per conferma
    }

    public Partecipation getById(String PartecipationId) {
        Partecipation PartecipationFound = em.find(Partecipation.class, PartecipationId); // metodo per cercare nel database tramite chiave primaria, inseriamo come primo parametro l'entità e come secondo parametro la chiave
        if (PartecipationFound == null)
            throw new NotFoundException(PartecipationId); // se non trovo nessun evento con l'id passato al metodo lancio una exeption
        else return PartecipationFound; //se lo trovo ritorno l'evento
    }

    public void delete(String PartecipationId) {
        Partecipation PartecipationFound = this.getById(PartecipationId); // sfrutto il metodo getById() creato sopra
        EntityTransaction transaction = em.getTransaction(); // richiedo la transazione
        transaction.begin(); // avvio la transazione
        em.remove(PartecipationFound); // rimuovo l'evento trovato tramite id dal persistence context
        transaction.commit(); // rimuovo l'evento dal database
        System.out.println("Partecipation " + PartecipationFound.getEvent() + " eliminata"); // stampo il titolo dell'evento per conferma
    }
}
