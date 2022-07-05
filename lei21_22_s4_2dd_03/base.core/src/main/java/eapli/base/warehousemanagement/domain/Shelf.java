package eapli.base.warehousemanagement.domain;

import eapli.base.productmanagement.domain.Product;
import eapli.framework.domain.model.AggregateRoot;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Ana Rita Silva
 */
@Entity
public class Shelf implements Serializable, AggregateRoot<Integer> {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int identifier;

    /**
     * Represents a shelf present in a row of the warehouse
     *
     * @param identifier shelf identification
     */
    public Shelf(int identifier) {
        this.identifier = identifier;
    }

    /**
     * Empty constructor
     */
    public Shelf() {

    }

    @Override
    public String toString() {
        return "Shelf{" +
                "id=" + id +
                ", identifier=" + identifier +
                '}';
    }

    @Override
    public boolean sameAs(Object other) {
        return false;
    }

    @Override
    public Integer identity() {
        return id;
    }
}
