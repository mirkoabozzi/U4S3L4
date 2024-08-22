package mirkoabozzi.dao;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import mirkoabozzi.entities.Location;
import mirkoabozzi.exceptions.NotFoundException;

import java.util.UUID;

public class LocationDAO { // buona prassi creare dei DAO per ogni tabella in modo da tener libero e più leggibile il main

    private final EntityManager em;

    public LocationDAO(EntityManager em) {  // obbligatorio un costruttore vuoto JPA lo utilizzerà per ricreare gli oggetti leggendo dal database
        this.em = em;
    }

    public void save(Location location) {
        EntityTransaction transaction = em.getTransaction(); //richiedo la transazione
        transaction.begin(); // avvia la transazione
        em.persist(location); // aggiunge l'evento al persistence context
        transaction.commit(); // inviamo l'evento al database
        System.out.println(" " + location.getName() + " creato"); // stampo il titolo dell'evento in console per conferma
    }

    public Location getById(String locationId) {
        Location locationFound = em.find(Location.class, UUID.fromString(locationId)); // metodo per cercare nel database tramite chiave primaria, inseriamo come primo parametro l'entità e come secondo parametro la chiave
        if (locationFound == null)
            throw new NotFoundException(locationId); // se non trovo nessun evento con l'id passato al metodo lancio una exeption
        else return locationFound; //se lo trovo ritorno l'evento
    }

    public void delete(String locationId) {
        Location locationFound = this.getById(locationId); // sfrutto il metodo getById() creato sopra
        EntityTransaction transaction = em.getTransaction(); // richiedo la transazione
        transaction.begin(); // avvio la transazione
        em.remove(locationFound); // rimuovo l'evento trovato tramite id dal persistence context
        transaction.commit(); // rimuovo l'evento dal database
        System.out.println("Location " + locationFound.getName() + " eliminata"); // stampo il titolo dell'evento per conferma
    }
}
