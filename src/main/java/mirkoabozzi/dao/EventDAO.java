package mirkoabozzi.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import mirkoabozzi.entities.Event;
import mirkoabozzi.exceptions.NotFoundException;

import java.util.UUID;

public class EventDAO { // buona prassi creare dei DAO per ogni tabella in modo da tener libero e più leggibile il main

    private final EntityManager em;

    public EventDAO(EntityManager em) {  // obbligatorio un costruttore vuoto JPA lo utilizzerà per ricreare gli oggetti leggendo dal database
        this.em = em;
    }

    public void save(Event event) {
        EntityTransaction transaction = em.getTransaction(); //richiedo la transazione
        transaction.begin(); // avvia la transazione
        em.persist(event); // aggiunge l'evento al persistence context
        transaction.commit(); // inviamo l'evento al database
        System.out.println("Evento " + event.getTitle() + " creato"); // stampo il titolo dell'evento in console per conferma
    }

    public Event getById(String eventId) {
        Event eventFound = em.find(Event.class, UUID.fromString(eventId)); // metodo per cercare nel database tramite chiave primaria, inseriamo come primo parametro l'entità e come secondo parametro la chiave
        if (eventFound == null)
            throw new NotFoundException(eventId); // se non trovo nessun evento con l'id passato al metodo lancio una exeption
        else return eventFound; //se lo trovo ritorno l'evento
    }

    public void delete(String eventId) {
        Event eventFound = this.getById(eventId); // sfrutto il metodo getById() creato sopra
        EntityTransaction transaction = em.getTransaction(); // richiedo la transazione
        transaction.begin(); // avvio la transazione
        em.remove(eventFound); // rimuovo l'evento trovato tramite id dal persistence context
        transaction.commit(); // rimuovo l'evento dal database
        System.out.println("Evento " + eventFound.getTitle() + " eliminato"); // stampo il titolo dell'evento per conferma
    }
}
