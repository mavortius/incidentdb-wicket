package br.com.proinde.incidentdb.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Embeddable
@Access(AccessType.FIELD)
public class PersistenceLogger implements Serializable {
    @ManyToOne
    private User creationUser;

    @Temporal(TemporalType.DATE)
    private Date dateCreated;

    @Temporal(TemporalType.DATE)
    private Date lastUpdated;

    @ManyToOne
    private User updateUser;

    public PersistenceLogger() {
    }

    public PersistenceLogger(User creationUser) {
        this(creationUser, new Date(), null, null);
    }

    public PersistenceLogger(User creationUser, Date dateCreated) {
        this(creationUser, dateCreated, null, null);
    }

    public PersistenceLogger(User creationUser, Date dateCreated, Date lastUpdated, User updateUser) {
        this.creationUser = creationUser;
        this.dateCreated = dateCreated;
        this.lastUpdated = lastUpdated;
        this.updateUser = updateUser;
    }

    public User getCreationUser() {
        return creationUser;
    }

    public void setCreationUser(User creationUser) {
        this.creationUser = creationUser;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Date getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(Date lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public User getUpdateUser() {
        return updateUser;
    }

    public void setUpdateUser(User updateUser) {
        this.updateUser = updateUser;
    }
}
