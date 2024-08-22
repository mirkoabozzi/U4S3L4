package mirkoabozzi.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import mirkoabozzi.entities.Person;
import mirkoabozzi.exceptions.NotFoundException;

import java.util.UUID;

public class PersonDAO { // buona prassi creare dei DAO per ogni tabella in modo da tener libero e più leggibile il main

    private final EntityManager em;

    public PersonDAO(EntityManager em) {  // obbligatorio un costruttore vuoto JPA lo utilizzerà per ricreare gli oggetti leggendo dal database
        this.em = em;
    }

    public void save(Person person) {
        EntityTransaction transaction = em.getTransaction(); //richiedo la transazione
        transaction.begin(); // avvia la transazione
        em.persist(person); // aggiunge l'evento al persistence context
        transaction.commit(); // inviamo l'evento al database
        System.out.println(" " + person.getName() + " creato"); // stampo il titolo dell'evento in console per conferma
    }

    public Person getById(String personId) {
        Person personFound = em.find(Person.class, UUID.fromString(personId)); // metodo per cercare nel database tramite chiave primaria, inseriamo come primo parametro l'entità e come secondo parametro la chiave
        if (personFound == null)
            throw new NotFoundException(personId); // se non trovo nessun evento con l'id passato al metodo lancio una exeption
        else return personFound; //se lo trovo ritorno l'evento
    }

    public void delete(String personId) {
        Person personFound = this.getById(personId); // sfrutto il metodo getById() creato sopra
        EntityTransaction transaction = em.getTransaction(); // richiedo la transazione
        transaction.begin(); // avvio la transazione
        em.remove(personFound); // rimuovo l'evento trovato tramite id dal persistence context
        transaction.commit(); // rimuovo l'evento dal database
        System.out.println("Persona " + personFound.getName() + " eliminata"); // stampo il titolo dell'evento per conferma
    }
}
