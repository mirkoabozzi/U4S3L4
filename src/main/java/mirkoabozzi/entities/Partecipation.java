package mirkoabozzi.entities;

import jakarta.persistence.*;
import mirkoabozzi.enums.StateType;

import java.util.UUID;

@Entity
@Table(name = "participation")
public class Partecipation {
    @Id
    @GeneratedValue
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "person_id", nullable = false)
    private Person person;

    @ManyToOne()
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;

    @Column(name = "state", nullable = false)
    @Enumerated(EnumType.STRING)
    private StateType stateType;

    public Partecipation() {
    }

    public Partecipation(Person person, Event event, StateType stateType) {
        this.person = person;
        this.event = event;
        this.stateType = stateType;
    }

    public UUID getId() {
        return id;
    }


    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public StateType getStateType() {
        return stateType;
    }

    public void setStateType(StateType stateType) {
        this.stateType = stateType;
    }

    @Override
    public String toString() {
        return "Partecipation{" +
                "id=" + id +
//                ", person=" + person +
                ", event=" + event +
                ", stateType=" + stateType +
                '}';
    }
}
