package mirkoabozzi.entities;

import jakarta.persistence.*;
import mirkoabozzi.enums.ConcertType;
import mirkoabozzi.enums.EventType;

import java.time.LocalDate;

@Entity
@DiscriminatorValue("concert")
public class Concert extends Event {
    @Column(name = "concert_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private ConcertType concertType;
    @Column(name = "streaming")
    private Boolean streaming;

    public Concert() {
    }

    public Concert(ConcertType concertType, Boolean streaming) {
        this.concertType = concertType;
        this.streaming = streaming;
    }

    public Concert(String title, LocalDate eventData, String description, EventType eventType, int maxPeople, Location location, ConcertType concertType, Boolean streaming) {
        super(title, eventData, description, eventType, maxPeople, location);
        this.concertType = concertType;
        this.streaming = streaming;
    }

    @Override
    public String toString() {
        return "concert{" +
                "concertType=" + concertType +
                ", streaming=" + streaming +
                '}';
    }
}
