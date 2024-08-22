package mirkoabozzi.entities;

import jakarta.persistence.*;
import mirkoabozzi.enums.EventType;

import java.time.LocalDate;
import java.util.List;

@Entity
@DiscriminatorValue("athletic_competition")
public class AthleticCompetition extends Event {

    @ManyToMany()
    @JoinTable(name = "athlete_competition_list",
            joinColumns = @JoinColumn(name = "competition_id"),
            inverseJoinColumns = @JoinColumn(name = "athlete_id"))
    private List<Person> athletes;

    @ManyToOne
    @JoinColumn(name = "winner_id", nullable = false)
    private Person winner;


    public AthleticCompetition() {
    }

    public AthleticCompetition(List<Person> athletes, Person winner) {
        this.athletes = athletes;
        this.winner = winner;
    }

    public AthleticCompetition(String title, LocalDate eventData, String description, EventType eventType, int maxPeople, Location location, List<Person> athletes, Person winner) {
        super(title, eventData, description, eventType, maxPeople, location);
        this.athletes = athletes;
        this.winner = winner;
    }

    public List<Person> getAthletes() {
        return athletes;
    }

    public void setAthletes(List<Person> athletes) {
        this.athletes = athletes;
    }

    public Person getWinner() {
        return winner;
    }

    public void setWinner(Person winner) {
        this.winner = winner;
    }

    @Override
    public String toString() {
        return "AthleticCompetition{" +
                "athletes=" + athletes +
                ", winner=" + winner +
                '}';
    }
}
