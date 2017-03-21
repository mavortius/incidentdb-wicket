package br.com.proinde.incidentdb.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
public class IncidentReporter implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date reportingDate;

    @ManyToOne
    private Reporter reporter;

    @ManyToOne
    private Incident incident;

    public IncidentReporter() {
    }

    public IncidentReporter(Date reportingDate, Reporter reporter, Incident incident) {
        this.reportingDate = reportingDate;
        this.reporter = reporter;
        this.incident = incident;
    }

    public Date getReportingDate() {
        return reportingDate;
    }

    public void setReportingDate(Date reportingDate) {
        this.reportingDate = reportingDate;
    }

    public Reporter getReporter() {
        return reporter;
    }

    public void setReporter(Reporter reporter) {
        this.reporter = reporter;
    }

    public Incident getIncident() {
        return incident;
    }

    public void setIncident(Incident incident) {
        this.incident = incident;
    }
}
