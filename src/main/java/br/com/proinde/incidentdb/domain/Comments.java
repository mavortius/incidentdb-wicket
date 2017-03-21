package br.com.proinde.incidentdb.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import java.io.Serializable;

@Entity
public class Comments implements Serializable {

    @Id
    private Long id;

    @MapsId
    @OneToOne
    private Incident incident;

    private String subject;

    private String commentText;

    public Comments() {
    }

    public Comments(Incident incident, String subject, String commentText) {
        this.incident = incident;
        this.subject = subject;
        this.commentText = commentText;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Incident getIncident() {
        return incident;
    }

    public void setIncident(Incident incident) {
        this.incident = incident;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }
}
