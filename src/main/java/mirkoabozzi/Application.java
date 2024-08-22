package mirkoabozzi;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import mirkoabozzi.dao.EventDAO;
import mirkoabozzi.dao.LocationDAO;
import mirkoabozzi.dao.PartecipationDAO;
import mirkoabozzi.dao.PersonDAO;
import mirkoabozzi.entities.Concert;
import mirkoabozzi.entities.Location;
import mirkoabozzi.enums.ConcertType;
import mirkoabozzi.enums.EventType;

import java.time.LocalDate;

public class Application {
    private static final EntityManagerFactory emf = Persistence.createEntityManagerFactory("u4s3l4");

    public static void main(String[] args) {

        EntityManager em = emf.createEntityManager(); // creo EntityManager da EntityManagerFactory
        EventDAO ed = new EventDAO(em);  // creo un nuovo EventDAO e gli passo come parametro l'EntityManager appena creato in modo da poterlo poi utilizzare nella classe EventDAO
        PersonDAO pd = new PersonDAO(em);
        LocationDAO ld = new LocationDAO(em);
        PartecipationDAO ptd = new PartecipationDAO(em);


        Location location1 = new Location("Colosseo", "Roma");
        Location location2 = new Location("Duomo", "Milano");
        Location location3 = new Location("Arena di Verona", "Verona");

//        ld.save(location1);
//        ld.save(location2);
//        ld.save(location3);

        Location colosseoFromDb = ld.getById("a6c07346-580a-4682-b81e-c113d7066808");
        Location duomoFromDb = ld.getById("cda4c688-847b-4017-97b6-bb9e6eeb73c0");
        Location arenaFromDb = ld.getById("1b9bb9a9-444c-475a-bc96-c0e18d0690c9");

        Concert concert1 = new Concert("Rock in Rome", LocalDate.of(2024, 9, 15), "Concerto rock con le migliori band italiane e internazionali.", EventType.PUBBLIC, 80000, colosseoFromDb, ConcertType.ROCK, false);
        Concert concert2 = new Concert("Notte d'Opera", LocalDate.of(2024, 11, 10), "Una serata dedicata alle arie più famose delle opere italiane.", EventType.PUBBLIC, 1800, arenaFromDb, ConcertType.CLASSIC, true);
        Concert concert3 = new Concert("Summer Pop Festival", LocalDate.of(2024, 7, 20), "Il meglio della musica pop in una serata indimenticabile.", EventType.PUBBLIC, 25000, duomoFromDb, ConcertType.POP, true);


//        ed.save(concert1);
//        ed.save(concert2);
//        ed.save(concert3);

        ed.getStreamingConcert().forEach(System.out::println);

        ed.getConcertPerGenere(ConcertType.CLASSIC).forEach(System.out::println);
    }
}
