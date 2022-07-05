package eapli.base.agvmanagement.domain;

import eapli.base.ordermanagement.domain.ProductOrder;
import eapli.base.warehousemanagement.domain.Coordinates;
import eapli.framework.domain.model.AggregateRoot;
import eapli.framework.domain.model.DomainEntities;

import javax.persistence.*;
import java.io.Serializable;


/**
 * @author Lucas Guimarães <1201216@isep.ipp.pt>
 * @author Ana Rita Silva
 */
@Entity
public class AGV implements Serializable, AggregateRoot<Integer> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Embedded
    private MaxWeight maxWeight;
    @Embedded
    private Volume volume;
    @Embedded
    private Status status;
    @Embedded
    private Autonomy autonomy;
    @Embedded
    @Column(unique = true)
    private Identifier identifier;
    @Embedded
    private Description description;
    @Embedded
    private Model model;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "length", column = @Column(name = "length")),
            @AttributeOverride(name = "width", column = @Column(name = "width")),
    })
    private Coordinates coordinates;

    @Embedded
    private Speed speed;

    private String docker;

    protected AGV() {
    }

    protected AGV(MaxWeight maxWeight, Volume volume, Status status, String docker, Autonomy autonomy, Identifier identifier, Description description, Model model, Speed speed) {
        this.maxWeight = maxWeight;
        this.volume = volume;
        this.status = status;
        this.docker = docker;
        this.autonomy = autonomy;
        this.identifier = identifier;
        this.description = description;
        this.model = model;
        this.coordinates = null;
        this.speed = speed;
    }

    /**
     * new constructor
     *
     * @param maxWeight   max weight carried
     * @param volume      max volume carried
     * @param status      status
     * @param autonomy    autonomy
     * @param identifier  identifier
     * @param description description
     * @param model       model
     * @return agv
     */
    public static AGV valueOf(MaxWeight maxWeight, Volume volume, Status status, String docker, Autonomy autonomy, Identifier identifier, Description description, Model model, Speed speed) {
        return new AGV(maxWeight, volume, status, docker, autonomy, identifier, description, model, speed);
    }

    /**
     * equals method
     *
     * @param other agv
     * @return true or false
     */
    @Override
    public boolean sameAs(final Object other) {
        return DomainEntities.areEqual(this, other);
    }

    /**
     * returns agv id
     *
     * @return id
     */
    @Override
    public Integer identity() {
        return this.id;
    }

    /**
     * Returns the agv's identifier
     *
     * @return agv's identifier
     */
    public Identifier identifier() {
        return this.identifier;
    }

    /**
     * Returns the agv's status
     *
     * @return agv's status
     */
    public String status() {
        return this.status.status();
    }

    /**
     * Returns the agv's autonomy
     *
     * @return agv's autonomy
     */
    public Status agvStatus() {
        return this.status;
    }

    public int autonomy() {
        return this.autonomy.autonomy();
    }

    public String docker() {
        return docker;
    }

    /**
     * Returns the current agv's coordinates
     *
     * @return agv's coordinates
     */
    public Coordinates coordinates() {
        return this.coordinates;
    }

    /**
     * Returns the agv's max weight
     *
     * @return agv's max weight
     */
    public double maxWeight() {
        return this.maxWeight.maxWeight();
    }

    /**
     * Returns the agv's max volume
     *
     * @return agv's max volume
     */
    public double volume() {
        return this.volume.volume();
    }

    /**
     * Assigns an order to the agv
     * - Changes the status to occupied
     *
     * @param order order assigned
     * @return true if success, false otherwise
     */
    public boolean assignOrder(ProductOrder order) {
        return this.status.assignOrder(order);
    }

    /**
     * Changes the status of an agv to "free" after an order was deployed
     *
     * @return true if the status of the agv was modified and false otherwise
     */
    public boolean deployOrder() {
        return this.status.deployOrder();
    }

    /**
     * Updates the current AGV coordinates
     *
     * @param length Current length
     * @param width  Current Width
     */
    public void updateCoordinates(String length, String width) {
        this.coordinates = new Coordinates(length, width);
    }

    /**
     * Updates the current AGV autonomy
     * @param autonomy autonomy
     */
    public void updateAutonomy(Autonomy autonomy) {
        this.autonomy = autonomy;
    }

    @Override
    public String toString() {
        return "AGV:\n" +
                "Max Weight = " + maxWeight +
                "\nVolume = " + volume +
                "\nStatus = " + status +
                "\nDocker = " + docker +
                "\nAutonomy = " + autonomy +
                "\nIdentifier = " + identifier +
                "\nDescription = " + description +
                "\nModel = " + model;
    }
}
