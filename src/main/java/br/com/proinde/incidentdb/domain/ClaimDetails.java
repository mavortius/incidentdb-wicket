package br.com.proinde.incidentdb.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class ClaimDetails implements Serializable {

    @Id
    private Long id;

    @MapsId
    @OneToOne
    private Incident incident;

    @Temporal(TemporalType.DATE)
    private Date receivedDate;

    @Temporal(TemporalType.DATE)
    private Date completeDate;

    private BigDecimal amount;

    private BigDecimal settlementAmount;

    private String description;

    @ManyToOne
    private Currency currency;

    @ManyToOne
    private Currency settlementCurrency;

    @ManyToOne
    private LossType lossType;

    @ManyToOne
    private LossCause lossCause;

    @OneToMany(cascade = CascadeType.ALL)
    private List<ClaimDetailsClaimant> claimDetailsClaimants = new ArrayList<>();

    @Embedded
    private PersistenceLogger logger;

    public ClaimDetails() {
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

    public Date getReceivedDate() {
        return receivedDate;
    }

    public void setReceivedDate(Date receivedDate) {
        this.receivedDate = receivedDate;
    }

    public Date getCompleteDate() {
        return completeDate;
    }

    public void setCompleteDate(Date completeDate) {
        this.completeDate = completeDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getSettlementAmount() {
        return settlementAmount;
    }

    public void setSettlementAmount(BigDecimal settlementAmount) {
        this.settlementAmount = settlementAmount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Currency getSettlementCurrency() {
        return settlementCurrency;
    }

    public void setSettlementCurrency(Currency settlementCurrency) {
        this.settlementCurrency = settlementCurrency;
    }

    public LossType getLossType() {
        return lossType;
    }

    public void setLossType(LossType lossType) {
        this.lossType = lossType;
    }

    public LossCause getLossCause() {
        return lossCause;
    }

    public void setLossCause(LossCause lossCause) {
        this.lossCause = lossCause;
    }

    public PersistenceLogger getLogger() {
        return logger;
    }

    public void setLogger(PersistenceLogger logger) {
        this.logger = logger;
    }

    public List<ClaimDetailsClaimant> getClaimDetailsClaimants() {
        return claimDetailsClaimants;
    }

    public void setClaimDetailsClaimants(List<ClaimDetailsClaimant> claimDetailsClaimants) {
        this.claimDetailsClaimants = claimDetailsClaimants;
    }
}
