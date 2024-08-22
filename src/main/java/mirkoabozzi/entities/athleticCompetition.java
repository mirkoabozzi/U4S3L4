package mirkoabozzi.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
@DiscriminatorValue("athletic_competition")
public class athleticCompetition extends Event {

    @ManyToOne
    @JoinColumn(name = "winner", nullable = false)
    private Person winner;

    public athleticCompetition() {
    }

    public athleticCompetition(Person winner) {
        this.winner = winner;
    }


    public Person getWinner() {
        return winner;
    }

    public void setWinner(Person winner) {
        this.winner = winner;
    }

    @Override
    public String toString() {
        return "athleticCompetition{" +
                ", winner=" + winner +
                '}';
    }
}
