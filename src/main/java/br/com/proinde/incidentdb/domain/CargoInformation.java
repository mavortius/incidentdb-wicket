package br.com.proinde.incidentdb.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
public class CargoInformation implements Serializable {

    @Id
    private Long id;

    @MapsId
    @OneToOne
    private Incident incident;

    private String description;

    private String billOfLadingNumber;

    private String containerNumber;

    @ManyToOne
    private CargoType cargoType;

    @Embedded
    private PersistenceLogger logger;

    @ManyToMany
    @JoinTable(name = "cargo_information_discarge_ports",
                joinColumns = @JoinColumn(name = "cargo_information_id"),
                inverseJoinColumns = @JoinColumn(name = "port_id"))
    private List<Port> discargePorts = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "cargo_information_loading_ports",
            joinColumns = @JoinColumn(name = "cargo_information_id"),
            inverseJoinColumns = @JoinColumn(name = "port_id"))
    private List<Port> loadingPorts = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "cargo_information_receivers",
            joinColumns = @JoinColumn(name = "cargo_information_id"),
            inverseJoinColumns = @JoinColumn(name = "trader_id"))
    private List<Trader> receivers = new ArrayList<>();

    @ManyToMany
    @JoinTable(name = "cargo_information_shippers",
            joinColumns = @JoinColumn(name = "cargo_information_id"),
            inverseJoinColumns = @JoinColumn(name = "trader_id"))
    private List<Trader> shippers = new ArrayList<>();

    public CargoInformation() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBillOfLadingNumber() {
        return billOfLadingNumber;
    }

    public void setBillOfLadingNumber(String billOfLadingNumber) {
        this.billOfLadingNumber = billOfLadingNumber;
    }

    public String getContainerNumber() {
        return containerNumber;
    }

    public void setContainerNumber(String containerNumber) {
        this.containerNumber = containerNumber;
    }

    public CargoType getCargoType() {
        return cargoType;
    }

    public void setCargoType(CargoType cargoType) {
        this.cargoType = cargoType;
    }

    public Incident getIncident() {
        return incident;
    }

    public void setIncident(Incident incident) {
        this.incident = incident;
    }

    public PersistenceLogger getLogger() {
        return logger;
    }

    public void setLogger(PersistenceLogger logger) {
        this.logger = logger;
    }

    public List<Port> getDiscargePorts() {
        return discargePorts;
    }

    public void setDiscargePorts(List<Port> discargePorts) {
        this.discargePorts = discargePorts;
    }

    public List<Port> getLoadingPorts() {
        return loadingPorts;
    }

    public void setLoadingPorts(List<Port> loadingPorts) {
        this.loadingPorts = loadingPorts;
    }

    public List<Trader> getReceivers() {
        return receivers;
    }

    public void setReceivers(List<Trader> receivers) {
        this.receivers = receivers;
    }

    public List<Trader> getShippers() {
        return shippers;
    }

    public void setShippers(List<Trader> shippers) {
        this.shippers = shippers;
    }
}
