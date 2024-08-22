package mirkoabozzi.entities;

import jakarta.persistence.*;
import mirkoabozzi.enums.GenderType;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "surname", nullable = false)
    private String surname;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "birth_date", nullable = false)
    private LocalDate date;

    @Column(name = "gender", nullable = false)
    @Enumerated(EnumType.STRING)
    private GenderType genderType;

    @OneToMany(mappedBy = "person")
    private List<Partecipation> partecipationList;

    @OneToMany()
    @JoinColumn(name = "winner")
    private List<AthleticCompetition> athleticCompetitionList;


    public Person() {
    }

    public Person(String name, String surname, String email, LocalDate date, GenderType genderType) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.date = date;
        this.genderType = genderType;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public GenderType getGenderType() {
        return genderType;
    }

    public void setGenderType(GenderType genderType) {
        this.genderType = genderType;
    }

    public List<Partecipation> getPartecipationList() {
        return partecipationList;
    }

    public void setPartecipationList(List<Partecipation> partecipationList) {
        this.partecipationList = partecipationList;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", date=" + date +
                ", genderType=" + genderType +
                ", partecipationList=" + partecipationList +
                '}';
    }
}
