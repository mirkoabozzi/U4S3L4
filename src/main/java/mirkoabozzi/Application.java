package mirkoabozzi;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import mirkoabozzi.dao.EventDAO;
import mirkoabozzi.dao.LocationDAO;
import mirkoabozzi.dao.PartecipationDAO;
import mirkoabozzi.dao.PersonDAO;
import mirkoabozzi.entities.Concert;
import mirkoabozzi.entities.FootballMatch;
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

        Location sanSiro = new Location("San Siro", "Milano");
        Location campNow = new Location("Camp Nou", "Barcellona");
        Location allianz = new Location("Allianz Arena", "Monaco");

//        ld.save(sanSiro);
//        ld.save(campNow);
//        ld.save(allianz);

        Location sanSiroFromDb = ld.getById("c7d2b753-3104-43ea-a821-fff20b430034");
        Location campNowFromDb = ld.getById("0e9e216c-a4bf-485e-b923-26ef039d34fa");
        Location allianzFromDb = ld.getById("3e5d4312-7b61-4fe0-ba30-6f5a0a8f04b9");

        FootballMatch match1 = new FootballMatch("Derby della Madonnina", LocalDate.of(2024, 10, 22), "Il famoso derby di Milano tra Inter e Milan.", EventType.PUBBLIC, 75000, sanSiroFromDb, "Inter", "Milan", "Milan", 1, 2);
        FootballMatch match2 = new FootballMatch("El Clásico", LocalDate.of(2024, 11, 3), "La storica sfida tra Barcellona e Real Madrid.", EventType.PUBBLIC, 95000, campNowFromDb, "Barcellona", "Real Madrid", "Real Madrid", 2, 3);
        FootballMatch match3 = new FootballMatch("Bundesliga Clash", LocalDate.of(2024, 9, 12), "Una partita decisiva tra Bayern Monaco e Borussia Dortmund.", EventType.PRIVATE, 70000, allianzFromDb, "Bayern Monaco", "Borussia Dortmund", "Bayern Monaco", 3, 1);

//        ed.save(match1);
//        ed.save(match2);
//        ed.save(match3);

        ed.getStreamingConcert().forEach(System.out::println);

        ed.getConcertPerGenere(ConcertType.CLASSIC).forEach(System.out::println);

        ed.getHomeMatchWon().forEach(System.out::println);


    }
}
