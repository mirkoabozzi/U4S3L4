package mirkoabozzi.entities;

import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import mirkoabozzi.enums.EventType;

import java.time.LocalDate;


@Entity
@DiscriminatorValue("football_match")
public class FootballMatch extends Event {
    @Column(name = "home_football_team", nullable = false)
    private String homeFootballTeam;
    @Column(name = "guest_football_team", nullable = false)
    private String guestFootballTeam;
    @Column(name = "winner")
    private String winner;
    @Column(name = "goal_home_team", nullable = false)
    private int goalHomeTeam;
    @Column(name = "goal_guest_team", nullable = false)
    private int goalGuestTeam;

    public FootballMatch() {
    }

    public FootballMatch(String homeFootballTeam, String guestFootballTeam, String winner, int goalHomeTeam, int goalGuestTeam) {
        this.homeFootballTeam = homeFootballTeam;
        this.guestFootballTeam = guestFootballTeam;
        this.winner = winner;
        this.goalHomeTeam = goalHomeTeam;
        this.goalGuestTeam = goalGuestTeam;
    }

    public FootballMatch(String title, LocalDate eventData, String description, EventType eventType, int maxPeople, Location location, String homeFootballTeam, String guestFootballTeam, String winner, int goalHomeTeam, int goalGuestTeam) {
        super(title, eventData, description, eventType, maxPeople, location);
        this.homeFootballTeam = homeFootballTeam;
        this.guestFootballTeam = guestFootballTeam;
        this.winner = winner;
        this.goalHomeTeam = goalHomeTeam;
        this.goalGuestTeam = goalGuestTeam;
    }

    public FootballMatch(String title, LocalDate eventData, String description, EventType eventType, int maxPeople, Location location, String homeFootballTeam, String guestFootballTeam, int goalHomeTeam, int goalGuestTeam) {
        super(title, eventData, description, eventType, maxPeople, location);
        this.homeFootballTeam = homeFootballTeam;
        this.guestFootballTeam = guestFootballTeam;
        this.goalHomeTeam = goalHomeTeam;
        this.goalGuestTeam = goalGuestTeam;
    }

    public String getHomeFootballTeam() {
        return homeFootballTeam;
    }

    public void setHomeFootballTeam(String homeFootballTeam) {
        this.homeFootballTeam = homeFootballTeam;
    }

    public String getGuestFootballTeam() {
        return guestFootballTeam;
    }

    public void setGuestFootballTeam(String guestFootballTeam) {
        this.guestFootballTeam = guestFootballTeam;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public int getGoalHomeTeam() {
        return goalHomeTeam;
    }

    public void setGoalHomeTeam(int goalHomeTeam) {
        this.goalHomeTeam = goalHomeTeam;
    }

    public int getGoalGuestTeam() {
        return goalGuestTeam;
    }

    public void setGoalGuestTeam(int goalGuestTeam) {
        this.goalGuestTeam = goalGuestTeam;
    }

    @Override
    public String toString() {
        return "footballMatch{" +
                "homeFootballTeam='" + homeFootballTeam + '\'' +
                ", guestFootballTeam='" + guestFootballTeam + '\'' +
                ", winner='" + winner + '\'' +
                ", goalHomeTeam=" + goalHomeTeam +
                ", goalGuestTeam=" + goalGuestTeam +
                '}';
    }
}
