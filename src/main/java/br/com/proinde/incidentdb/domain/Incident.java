package br.com.proinde.incidentdb.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table
public class Incident implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    private IncidentReference reference;

    @Enumerated(EnumType.STRING)
    private IncidentStatusType status;

    @Temporal(TemporalType.DATE)
    private Date closingDate;

    @ManyToOne
    private Ship ship;

    private String voyageAndLeg;

    @Temporal(TemporalType.DATE)
    private Date berthingBate;

    @Temporal(TemporalType.DATE)
    private Date incidentDate;

    @ManyToOne
    private Club club;

    private String clubReference;

    @ManyToOne
    private Member member;

    @ManyToOne
    private Member owner;

    @ManyToOne
    private Agent localAgent;

    @Temporal(TemporalType.DATE)
    private Date timeBarDate;

    @ManyToOne
    private Port incidentPlace;

    @ManyToOne
    private IncidentType type;

    @ManyToOne
    private IncidentType reason;

    private Boolean claimPresented;

    private Boolean cargoInvolved;

    @Temporal(TemporalType.DATE)
    private Date latestReportDate;

    @Temporal(TemporalType.DATE)
    private Date nextReviewDate;

    private String description;

    @ManyToOne
    private ClaimHandler handler;

    @Temporal(TemporalType.DATE)
    private Date estimatedDisposalDate;

    @Temporal(TemporalType.DATE)
    private Date effectiveDisposalDate;

    @Embedded
    private PersistenceLogger logger;

    @OneToMany(cascade = CascadeType.ALL)
    private List<IncidentReporter> incidentReporters = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL)
    private List<IncidentClub> incidentClubs = new ArrayList<>();

    @OneToOne(mappedBy = "incident", cascade = CascadeType.ALL, orphanRemoval = true)
    private CargoInformation cargoInformation;

    @OneToOne(mappedBy = "incident", cascade = CascadeType.ALL, orphanRemoval = true)
    private ClaimDetails claimDetails;

    @OneToOne(mappedBy = "incident", cascade = CascadeType.ALL, orphanRemoval = true)
    private Comments comments;


    public Incident() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public IncidentReference getReference() {
        return reference;
    }

    public void setReference(IncidentReference reference) {
        this.reference = reference;
    }

    public IncidentStatusType getStatus() {
        return status;
    }

    public void setStatus(IncidentStatusType status) {
        this.status = status;
    }

    public Date getClosingDate() {
        return closingDate;
    }

    public void setClosingDate(Date closingDate) {
        this.closingDate = closingDate;
    }

    public Ship getShip() {
        return ship;
    }

    public void setShip(Ship ship) {
        this.ship = ship;
    }

    public String getVoyageAndLeg() {
        return voyageAndLeg;
    }

    public void setVoyageAndLeg(String voyageAndLeg) {
        this.voyageAndLeg = voyageAndLeg;
    }

    public Date getBerthingBate() {
        return berthingBate;
    }

    public void setBerthingBate(Date berthingBate) {
        this.berthingBate = berthingBate;
    }

    public Date getIncidentDate() {
        return incidentDate;
    }

    public void setIncidentDate(Date incidentDate) {
        this.incidentDate = incidentDate;
    }

    public Club getClub() {
        return club;
    }

    public void setClub(Club club) {
        this.club = club;
    }

    public String getClubReference() {
        return clubReference;
    }

    public void setClubReference(String clubReference) {
        this.clubReference = clubReference;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Member getOwner() {
        return owner;
    }

    public void setOwner(Member owner) {
        this.owner = owner;
    }

    public Agent getLocalAgent() {
        return localAgent;
    }

    public void setLocalAgent(Agent localAgent) {
        this.localAgent = localAgent;
    }

    public Date getTimeBarDate() {
        return timeBarDate;
    }

    public void setTimeBarDate(Date timeBarDate) {
        this.timeBarDate = timeBarDate;
    }

    public Port getIncidentPlace() {
        return incidentPlace;
    }

    public void setIncidentPlace(Port incidentPlace) {
        this.incidentPlace = incidentPlace;
    }

    public IncidentType getType() {
        return type;
    }

    public void setType(IncidentType type) {
        this.type = type;
    }

    public IncidentType getReason() {
        return reason;
    }

    public void setReason(IncidentType reason) {
        this.reason = reason;
    }

    public Boolean getClaimPresented() {
        return claimPresented;
    }

    public void setClaimPresented(Boolean claimPresented) {
        this.claimPresented = claimPresented;
    }

    public Boolean getCargoInvolved() {
        return cargoInvolved;
    }

    public void setCargoInvolved(Boolean cargoInvolved) {
        this.cargoInvolved = cargoInvolved;
    }

    public Date getLatestReportDate() {
        return latestReportDate;
    }

    public void setLatestReportDate(Date latestReportDate) {
        this.latestReportDate = latestReportDate;
    }

    public Date getNextReviewDate() {
        return nextReviewDate;
    }

    public void setNextReviewDate(Date nextReviewDate) {
        this.nextReviewDate = nextReviewDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ClaimHandler getHandler() {
        return handler;
    }

    public void setHandler(ClaimHandler handler) {
        this.handler = handler;
    }

    public Date getEstimatedDisposalDate() {
        return estimatedDisposalDate;
    }

    public void setEstimatedDisposalDate(Date estimatedDisposalDate) {
        this.estimatedDisposalDate = estimatedDisposalDate;
    }

    public Date getEffectiveDisposalDate() {
        return effectiveDisposalDate;
    }

    public void setEffectiveDisposalDate(Date effectiveDisposalDate) {
        this.effectiveDisposalDate = effectiveDisposalDate;
    }

    public PersistenceLogger getLogger() {
        return logger;
    }

    public void setLogger(PersistenceLogger logger) {
        this.logger = logger;
    }

    public ClaimDetails getClaimDetails() {
        return claimDetails;
    }

    public void setClaimDetails(ClaimDetails claimDetails) {
        this.claimDetails = claimDetails;
    }

    public List<IncidentReporter> getIncidentReporters() {
        return this.incidentReporters;
    }

    public void setIncidentReporters(List<IncidentReporter> incidentReporters) {
        this.incidentReporters = incidentReporters;
    }

    public List<IncidentClub> getIncidentClubs() {
        return incidentClubs;
    }

    public void setIncidentClubs(List<IncidentClub> incidentClubs) {
        this.incidentClubs = incidentClubs;
    }

    public CargoInformation getCargoInformation() {
        return cargoInformation;
    }

    public void setCargoInformation(CargoInformation cargoInformation) {
        this.cargoInformation = cargoInformation;
    }

    @Embeddable
    @Access(AccessType.FIELD)
    public class IncidentReference {
        private Short number;
        private Short year;
        private Short subNumber;

        public IncidentReference() {
        }

        public IncidentReference(Short number) {
            this(number, (short) LocalDate.now().getYear(), (short) 0);
        }

        public IncidentReference(Short number, Short year) {
            this(number, year, (short) 0);
        }

        public IncidentReference(Short number, Short year, Short subNumber) {
            this.number = number;
            this.year = year;
            this.subNumber = subNumber;
        }

        public Short getNumber() {
            return number;
        }

        public void setNumber(Short number) {
            this.number = number;
        }

        public Short getYear() {
            return year;
        }

        public void setYear(Short year) {
            this.year = year;
        }

        public Short getSubNumber() {
            return subNumber;
        }

        public void setSubNumber(Short subNumber) {
            this.subNumber = subNumber;
        }

        @Override
        public String toString() {
            return number + "/" + year + "/" + subNumber;
        }
    }

    private enum IncidentStatusType {
        OPEN("Open"),
        CLOSED("Closed"),
        WITHDRAWN("Withdrawn"),
        SETTLED("Settled"),
        OUTSTANDING("Outstanding"),
        REPUDIATED("Repudiated"),
        DISCARDED("Discarded");

        private String label;

        IncidentStatusType(String label) {
            this.label = label;
        }

        @Override
        public String toString() {
            return label;
        }
    }
}
