package br.com.proinde.incidentdb.domain;

import br.com.proinde.incidentdb.domain.enumeration.InvoiceStatus;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class Appointment implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.DATE)
    private Date appointmentDate;

    @Temporal(TemporalType.DATE)
    private Date surveyDate;

    @Temporal(TemporalType.DATE)
    private Date preliminaryDate;

    @Temporal(TemporalType.DATE)
    private Date reportDate;

    private Boolean invoiceProinde;

    private BigDecimal invoiceValue;

    @Temporal(TemporalType.DATE)
    private Date sendDate;

    @Temporal(TemporalType.DATE)
    private Date chasingDate;

    @Temporal(TemporalType.DATE)
    private Date receiptDate;

    @Enumerated(EnumType.STRING)
    private InvoiceStatus invoiceStatus;

    @ManyToOne
    private Consultant consultant;

    @Embedded
    private PersistenceLogger logger;

    @ManyToOne
    private Incident incident;

    public Appointment() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public Date getSurveyDate() {
        return surveyDate;
    }

    public void setSurveyDate(Date surveyDate) {
        this.surveyDate = surveyDate;
    }

    public Date getPreliminaryDate() {
        return preliminaryDate;
    }

    public void setPreliminaryDate(Date preliminaryDate) {
        this.preliminaryDate = preliminaryDate;
    }

    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    public Boolean getInvoiceProinde() {
        return invoiceProinde;
    }

    public void setInvoiceProinde(Boolean invoiceProinde) {
        this.invoiceProinde = invoiceProinde;
    }

    public BigDecimal getInvoiceValue() {
        return invoiceValue;
    }

    public void setInvoiceValue(BigDecimal invoiceValue) {
        this.invoiceValue = invoiceValue;
    }

    public Date getSendDate() {
        return sendDate;
    }

    public void setSendDate(Date sendDate) {
        this.sendDate = sendDate;
    }

    public Date getChasingDate() {
        return chasingDate;
    }

    public void setChasingDate(Date chasingDate) {
        this.chasingDate = chasingDate;
    }

    public Date getReceiptDate() {
        return receiptDate;
    }

    public void setReceiptDate(Date receiptDate) {
        this.receiptDate = receiptDate;
    }

    public InvoiceStatus getInvoiceStatus() {
        return invoiceStatus;
    }

    public void setInvoiceStatus(InvoiceStatus invoiceStatus) {
        this.invoiceStatus = invoiceStatus;
    }

    public Consultant getConsultant() {
        return consultant;
    }

    public void setConsultant(Consultant consultant) {
        this.consultant = consultant;
    }

    public PersistenceLogger getLogger() {
        return logger;
    }

    public void setLogger(PersistenceLogger logger) {
        this.logger = logger;
    }

    public Incident getIncident() {
        return incident;
    }

    public void setIncident(Incident incident) {
        this.incident = incident;
    }
}
