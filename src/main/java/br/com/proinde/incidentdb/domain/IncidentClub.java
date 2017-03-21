package br.com.proinde.incidentdb.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class IncidentClub implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String clubReference;

    @ManyToOne
    private Club club;

    @ManyToOne
    private Incident incident;

    public IncidentClub() {
    }

    public IncidentClub(String clubReference, Club club, Incident incident) {
        this.clubReference = clubReference;
        this.club = club;
        this.incident = incident;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClubReference() {
        return clubReference;
    }

    public void setClubReference(String clubReference) {
        this.clubReference = clubReference;
    }

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    public Incident getIncident() {
        return incident;
    }

    public void setIncident(Incident incident) {
        this.incident = incident;
    }
}
