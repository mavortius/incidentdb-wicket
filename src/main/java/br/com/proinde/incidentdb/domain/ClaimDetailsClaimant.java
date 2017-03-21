package br.com.proinde.incidentdb.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
public class ClaimDetailsClaimant implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String claimantReference;

    private Boolean directlyClaimant;

    @ManyToOne
    private Claimant claimant;

    @ManyToOne
    private ClaimDetails claimDetails;

    public ClaimDetailsClaimant() {
    }

    public ClaimDetailsClaimant(String claimantReference, Boolean directlyClaimant, Claimant claimant, ClaimDetails claimDetails) {
        this.claimantReference = claimantReference;
        this.directlyClaimant = directlyClaimant;
        this.claimant = claimant;
        this.claimDetails = claimDetails;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getClaimantReference() {
        return claimantReference;
    }

    public void setClaimantReference(String claimantReference) {
        this.claimantReference = claimantReference;
    }

    public Boolean getDirectlyClaimant() {
        return directlyClaimant;
    }

    public void setDirectlyClaimant(Boolean directlyClaimant) {
        this.directlyClaimant = directlyClaimant;
    }

    public Claimant getClaimant() {
        return claimant;
    }

    public void setClaimant(Claimant claimant) {
        this.claimant = claimant;
    }

    public ClaimDetails getClaimDetails() {
        return claimDetails;
    }

    public void setClaimDetails(ClaimDetails claimDetails) {
        this.claimDetails = claimDetails;
    }
}
