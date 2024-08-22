package mirkoabozzi.entities;

import jakarta.persistence.*;
import mirkoabozzi.enums.ConcertType;

@Entity
@DiscriminatorValue("concert")
public class concert extends Event {
    @Column(name = "concert_type", nullable = false)
    @Enumerated(EnumType.STRING)
    private ConcertType concertType;
    @Column(name = "streaming")
    private Boolean streaming;

    public concert() {
    }

    public concert(ConcertType concertType, Boolean streaming) {
        this.concertType = concertType;
        this.streaming = streaming;
    }

    public ConcertType getConcertType() {
        return concertType;
    }

    public void setConcertType(ConcertType concertType) {
        this.concertType = concertType;
    }

    public Boolean getStreaming() {
        return streaming;
    }

    public void setStreaming(Boolean streaming) {
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
