package br.com.proinde.incidentdb.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Currency implements Serializable {

    @Id
    private Long id;

    private String name;

    private String cultureName;

    public Currency() {
    }

    public Currency(String name, String cultureName) {
        this.name = name;
        this.cultureName = cultureName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCultureName() {
        return cultureName;
    }

    public void setCultureName(String cultureName) {
        this.cultureName = cultureName;
    }
}
